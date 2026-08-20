// MovementController.java
package com.applesauce3840.controller.client;

import net.minecraft.client.MinecraftClient;

public class MovementController {
    private int ticksRemaining = 0;

    /** Request the player to move forward for the given number of ticks. */
    public void moveForward(int ticks) {
        this.ticksRemaining = ticks;
    }

    public void tick(MinecraftClient client) {
        if (ticksRemaining > 0) {
            client.player.input.movementForward = 1.0f;
            ticksRemaining--;
        } else {
            client.player.input.movementForward = 0.0f;
        }
    }
}
