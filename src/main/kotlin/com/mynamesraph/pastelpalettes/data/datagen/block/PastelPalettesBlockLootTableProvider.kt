package com.mynamesraph.pastelpalettes.data.datagen.block

import net.minecraft.core.HolderLookup
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags


class PastelPalettesBlockLootTableProvider(
registries: HolderLookup.Provider
): BlockLootSubProvider(setOf(),FeatureFlags.REGISTRY.allFlags(),registries) {
    override fun generate() {
        //dropSelf()
    }


}