package com.mynamesraph.pastelpalettes.data.datagen

import com.mynamesraph.pastelpalettes.data.datagen.block.PastelPalettesBlockStateProvider
import com.mynamesraph.pastelpalettes.PastelPalettes
import com.mynamesraph.pastelpalettes.data.datagen.block.PastelPalettesBlockTagProvider
import com.mynamesraph.pastelpalettes.data.datagen.item.PastelPalettesItemModelProvider
import com.mynamesraph.pastelpalettes.data.datagen.item.PastelPalettesItemTagProvider
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent

@EventBusSubscriber(modid = PastelPalettes.MOD_ID,bus= EventBusSubscriber.Bus.MOD)
object DataGenerators {

    @SubscribeEvent
    fun gatherData(event:GatherDataEvent) {
        val generator = event.generator
        val packOutput= generator.packOutput
        val existingFileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider

        /*generator.addProvider(
            event.includeServer(),
            LootTableProvider(
                packOutput,
                Collections.emptySet(),
                listOf(
                    LootTableProvider.SubProviderEntry(
                        ::PastelPalettesBlockLootTableProvider,
                        LootContextParamSets.BLOCK
                    )
                ),
                lookupProvider
            )
        )*/

        val blockTagProvider = PastelPalettesBlockTagProvider(packOutput,lookupProvider,existingFileHelper)
        generator.addProvider(event.includeServer(),blockTagProvider)
        generator.addProvider(event.includeServer(), PastelPalettesItemTagProvider(
            packOutput,
            lookupProvider,
            blockTagProvider.contentsGetter(),
            existingFileHelper
        )
        )

        generator.addProvider(event.includeClient(), PastelPalettesBlockStateProvider(packOutput,existingFileHelper))
        generator.addProvider(event.includeClient(), PastelPalettesItemModelProvider(packOutput,existingFileHelper))
    }
}