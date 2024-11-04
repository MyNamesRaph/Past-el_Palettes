package com.mynamesraph.pastelpalettes.data.datagen.item

import com.mynamesraph.pastelpalettes.PastelPalettes
import com.mynamesraph.pastelpalettes.registry.PastelPalettesItems
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper

class PastelPalettesItemModelProvider(
    output: PackOutput,
    existingFileHelper: ExistingFileHelper
) : ItemModelProvider(output, PastelPalettes.MOD_ID, existingFileHelper) {

    override fun registerModels() {
        for (item in PastelPalettesItems.ITEMS.entries) {
            basicItem(item.get())
        }
    }

}