package com.deceasedghost.aimbooot.event;

import com.deceasedghost.aimbooot.util.KeyBinds;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = "aimbooot", value = Dist.CLIENT)
    public static class ClientForgeEvents {

        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            //KeyBinds.onKeyInput();
            if(KeyBinds.targetLockToggle.consumeClick()) {
                //do something
                assert Minecraft.getInstance().player != null;
                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Target Lock Toggled"));
            }
        }
    }
    @Mod.EventBusSubscriber(modid = "aimbooot",  bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyregister(RegisterKeyMappingsEvent event) {
            //KeyBinds.register();
            event.register(KeyBinds.targetLockToggle);
        }
    }

}
