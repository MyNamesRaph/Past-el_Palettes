package com.mynamesraph.mystcraft.data.datagen.block

import com.mynamesraph.pastelpalettes.PastelPalettes
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredBlock

class PastelPalettesBlockStateProvider(
    output: PackOutput,
    private val exFileHelper: ExistingFileHelper
) : BlockStateProvider(output, PastelPalettes.MOD_ID, exFileHelper) {

    override fun registerStatesAndModels() {

    }

    private fun cubeWithItem(block: DeferredBlock<*>) {
        simpleBlockWithItem(block.get(),cubeAll(block.get()))
    }

}