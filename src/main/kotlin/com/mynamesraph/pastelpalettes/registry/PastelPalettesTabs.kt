package com.mynamesraph.pastelpalettes.registry

import com.mynamesraph.pastelpalettes.PastelPalettes
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object PastelPalettesTabs {
    private val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB,
        PastelPalettes.MOD_ID
    )

    val PASTEL_PALETTES_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_MODE_TABS.register("past_el_palettes_tab",
        Supplier {
            CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.past_el_palettes"))
                .icon { PastelPalettesItems.FUCHSIA_DYE.get().defaultInstance }
                .displayItems { parameters: ItemDisplayParameters?, output: CreativeModeTab.Output ->
                    for (item in PastelPalettesItems.ITEMS.entries) {
                        output.accept(item.get())
                    }
                }.build()
        })

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TABS.register(eventBus)
    }
}