package com.mynamesraph.pastelpalettes.data.datagen.block

import com.mynamesraph.pastelpalettes.PastelPalettes
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class PastelPalettesBlockTagProvider(
    output: PackOutput,
    lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper?
) : BlockTagsProvider(output, lookupProvider,PastelPalettes.MOD_ID, existingFileHelper) {

    override fun addTags(provider: HolderLookup.Provider) {

        /*tag(Tags.Blocks.)
            .add()*/

    }

}