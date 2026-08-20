// JumpController.java
package com.applesauce3840.controller.client;

import net.minecraft.client.MinecraftClient;

public class JumpController {
    private boolean jumpRequested = false;

    /** Request a single jump (will occur on the next tick). */
    public void jump() {
        this.jumpRequested = true;
    }

    public void tick(MinecraftClient client) {
        if (client.player == null) return;
        if (jumpRequested) {
            client.player.input.jump();
            jumpRequested = false;
        }
    }
}
