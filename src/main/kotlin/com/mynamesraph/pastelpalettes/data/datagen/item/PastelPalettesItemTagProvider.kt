package com.mynamesraph.pastelpalettes.data.datagen.item

import com.mynamesraph.pastelpalettes.PastelPalettes
import com.mynamesraph.pastelpalettes.registry.PastelPalettesItems
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class PastelPalettesItemTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    blockTags: CompletableFuture<TagLookup<Block>>,
    existingFileHelper: ExistingFileHelper
): ItemTagsProvider(output,lookupProvider,blockTags,PastelPalettes.MOD_ID,existingFileHelper) {

    override fun addTags(provider: HolderLookup.Provider) {

        for (item in PastelPalettesItems.ITEMS.entries) {
            tag(Tags.Items.DYES)
                .add(item.get())
        }

    }


}