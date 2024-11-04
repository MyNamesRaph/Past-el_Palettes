package com.mynamesraph.pastelpalettes.registry

import com.mynamesraph.pastelpalettes.PastelDyeColor
import com.mynamesraph.pastelpalettes.PastelPalettes.Companion.MOD_ID
import com.mynamesraph.pastelpalettes.item.PastelDyeItem
import net.minecraft.world.item.Item

import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object PastelPalettesItems {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MOD_ID
    )

    val CRIMSON_DYE = ITEMS.register(
        "crimson_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.CRIMSON,
                Item.Properties()
            )
        }
    )

    val AMBER_DYE = ITEMS.register(
        "amber_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.AMBER,
                Item.Properties()
            )
        }
    )

    val CANARY_DYE = ITEMS.register(
        "canary_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.CANARY,
                Item.Properties()
            )
        }
    )

    val CHARTREUSE_DYE = ITEMS.register(
        "chartreuse_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.CHARTREUSE,
                Item.Properties()
            )
        }
    )

    val EMERALD_DYE = ITEMS.register(
        "emerald_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.EMERALD,
                Item.Properties()
            )
        }
    )

    val SPRING_GREEN_DYE = ITEMS.register(
        "spring_green_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.SPRING_GREEN,
                Item.Properties()
            )
        }
    )

    val AQUA_DYE = ITEMS.register(
        "aqua_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.AQUA,
                Item.Properties()
            )
        }
    )

    val CAPRI_DYE = ITEMS.register(
        "capri_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.CAPRI,
                Item.Properties()
            )
        }
    )

    val ULTRAMARINE_DYE = ITEMS.register(
        "ultramarine_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.ULTRAMARINE,
                Item.Properties()
            )
        }
    )

    val VIOLET_DYE = ITEMS.register(
        "violet_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.VIOLET,
                Item.Properties()
            )
        }
    )

    val LILAC_DYE = ITEMS.register(
        "lilac_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.LILAC,
                Item.Properties()
            )
        }
    )

    val FUCHSIA_DYE = ITEMS.register(
        "fuchsia_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.FUCHSIA,
                Item.Properties()
            )
        }
    )

    val ROSE_DYE = ITEMS.register(
        "rose_dye",
        Supplier {
            PastelDyeItem (
                PastelDyeColor.ROSE,
                Item.Properties()
            )
        }
    )

    fun register(eventBus: IEventBus) {
        ITEMS.register(eventBus)
    }
}