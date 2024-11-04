package com.mynamesraph.pastelpalettes

import com.mojang.logging.LogUtils
import com.mynamesraph.pastelpalettes.registry.PastelPalettesItems
import com.mynamesraph.pastelpalettes.registry.PastelPalettesTabs
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.event.server.ServerStartingEvent
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent
import net.neoforged.neoforge.network.registration.PayloadRegistrar


@Mod(PastelPalettes.MOD_ID)
class PastelPalettes(modEventBus: IEventBus, modContainer: ModContainer) {
    companion object {
        const val MOD_ID = "past_el_palettes"
        private val LOGGER = LogUtils.getLogger()

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
        object ClientModEvents {
            @SubscribeEvent
            fun onClientSetup(event: FMLClientSetupEvent?) {
                // Some client setup code
            }

            @SubscribeEvent
            fun register(event: RegisterPayloadHandlersEvent) {
                val payloadRegistrar: PayloadRegistrar = event.registrar("1")
            }

            @SubscribeEvent
            fun registerScreens(event: RegisterMenuScreensEvent) {
            }

            @SubscribeEvent
            fun registerBlockColorHandlers(event: RegisterColorHandlersEvent.Block) {
            }
        }

        @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.DEDICATED_SERVER])
        object ServerModEvents {
            @SubscribeEvent
            fun onClientSetup(event: FMLClientSetupEvent?) {
                // Some server setup code
                LOGGER.info("HELLO FROM SERVER SETUP")
            }

            @SubscribeEvent
            fun register(event: RegisterPayloadHandlersEvent) {
                val payloadRegistrar: PayloadRegistrar = event.registrar("1")
            }

            @SubscribeEvent
            fun registerScreens(event: RegisterMenuScreensEvent) {

            }
        }
    }

    init {
        modEventBus.addListener(::commonSetup)
        PastelPalettesItems.register(modEventBus)
        PastelPalettesTabs.register(modEventBus)
        NeoForge.EVENT_BUS.register(this)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {

    }


    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        // Do something when the server starts
    }


}