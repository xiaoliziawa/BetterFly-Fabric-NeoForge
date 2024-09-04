package com.tyxcnjiu.main.untitled2;

import dev.architectury.event.events.common.TickEvent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.client.player.Input;
import net.minecraft.client.player.LocalPlayer;

public class BetterFlyHandler {
    public static void init() {
        TickEvent.PLAYER_POST.register(BetterFlyHandler::onPlayerTick);
    }


    private static void onPlayerTick(Player player) {
        if (player instanceof LocalPlayer localPlayer) {
            if (localPlayer.getAbilities().flying) {
                handleInstantStop(localPlayer);
            }
        }
    }

    private static void handleInstantStop(LocalPlayer player) {
        Input input = player.input;
        if (!input.jumping && !input.shiftKeyDown && Math.abs(input.leftImpulse) < 0.01 && Math.abs(input.forwardImpulse) < 0.01) {
            player.setDeltaMovement(0, 0, 0);
        }
    }
}
