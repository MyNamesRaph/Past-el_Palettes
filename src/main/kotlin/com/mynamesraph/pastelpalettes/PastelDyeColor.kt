package com.mynamesraph.pastelpalettes

import io.netty.buffer.ByteBuf
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.util.ByIdMap
import net.minecraft.util.StringRepresentable
import net.minecraft.util.StringRepresentable.EnumCodec
import net.minecraft.world.item.Item
import net.minecraft.world.level.material.MapColor
import org.jetbrains.annotations.Contract
import java.util.*
import java.util.function.IntFunction
import java.util.stream.Collectors

enum class PastelDyeColor(
    val id: Int,
    val displayName: String,
    private val defuseColor: Int,
    val mapColor: MapColor,
    val fireworkColor: Int,
    val textColor: Int
):StringRepresentable {
    CRIMSON(0,"crimson",0xFF3A3A,MapColor.COLOR_RED,0xFF3A3A,0xFF3A3A),
    AMBER(1,"amber",0xE58C34,MapColor.COLOR_ORANGE, 0xE58C34, 0xE58C34),
    CANARY(2, "canary",0xFFFF3A,MapColor.COLOR_YELLOW,0xFFFF3A,0xFFFF3A),
    CHARTREUSE(3, "chartreuse",0x8FEB35,MapColor.COLOR_LIGHT_GREEN,0x8FEB35,0x8FEB35),
    EMERALD(4,"emerald",0x34E834, MapColor.COLOR_GREEN,0x34E834,0x34E834),
    SPRING_GREEN(5,"spring_green",0x34E58C,MapColor.COLOR_LIGHT_GREEN,0x34E58C, 0x34E58C),
    AQUA(6,"aqua",0x34E8E8,MapColor.COLOR_LIGHT_BLUE,0x34E8E8,0x34E8E8),
    CAPRI(7,"capri",0x6DAAE8,MapColor.COLOR_LIGHT_BLUE,0x6DAAE8,0x6DAAE8),
    ULTRAMARINE(8,"ultramarine",0x7E7EE8,MapColor.COLOR_PURPLE,0x7E7EE8,0x7E7EE8),
    VIOLET(9,"violet", 0x8E34E8, MapColor.COLOR_PURPLE,0x8E34E8,0x8E34E8),
    LILAC(10,"lilac",0xB84EEB,MapColor.COLOR_PURPLE,0xB84EEB,0xB84EEB),
    FUCHSIA(11,"fuchsia",0xEB35EB,MapColor.COLOR_MAGENTA,0xEB35EB,0xEB35EB),
    ROSE(12,"rose",0xEB358F,MapColor.COLOR_PINK,0xEB358F,0xEB358F);


    var dyesTag: TagKey<Item> = ItemTags.create(
        ResourceLocation.fromNamespaceAndPath(
            "c",
            "dyes/$displayName"
        )
    )
    var dyedTag: TagKey<Item>? = ItemTags.create(
        ResourceLocation.fromNamespaceAndPath(
            "c",
            "dyed/$displayName"
        )
    )
    var textureDefuseColor = 0

    init {
        textureDefuseColor = defuseColor
    }

    companion object {
        private val BY_ID: IntFunction<PastelDyeColor> = ByIdMap.continuous(
            { obj: PastelDyeColor -> obj.id },
            PastelDyeColor.entries.toTypedArray(),
            ByIdMap.OutOfBoundsStrategy.ZERO
        )
        private val BY_FIREWORK_COLOR: Int2ObjectOpenHashMap<PastelDyeColor> = Int2ObjectOpenHashMap(
            Arrays.stream(PastelDyeColor.entries.toTypedArray()).collect(
                Collectors.toMap(
                    { it.fireworkColor },
                    { it })
            )
        )
        val CODEC: EnumCodec<PastelDyeColor> = StringRepresentable.fromEnum { PastelDyeColor.entries.toTypedArray() }
         val STREAM_CODEC: StreamCodec<ByteBuf, PastelDyeColor> = ByteBufCodecs.idMapper(
            BY_ID
        ) { obj: PastelDyeColor -> obj.id }
    }




    fun byId(colorId: Int): PastelDyeColor {
        return BY_ID.apply(colorId)
    }

    @Contract("_,!null->!null;_,null->_")
    fun byName(translationKey: String?, fallback: PastelDyeColor?): PastelDyeColor? {
        val color = CODEC.byName(translationKey)
        return color ?: fallback
    }

    fun byFireworkColor(fireworkColor: Int): PastelDyeColor? {
        return BY_FIREWORK_COLOR[fireworkColor]
    }

    override fun toString(): String {
        return this.displayName
    }

    override fun getSerializedName(): String {
        return this.displayName
    }
}