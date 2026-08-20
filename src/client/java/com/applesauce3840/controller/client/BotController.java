// BotController.java
package com.applesauce3840.controller.client;

import net.minecraft.client.MinecraftClient;

public class BotController {
    private static final BotController INSTANCE = new BotController();
    public static BotController getInstance() { return INSTANCE; }

    private final MovementController movement = new MovementController();
    private final TurnController turn = new TurnController();
    private final JumpController jump = new JumpController();

    private boolean running = false;

    /** Call to start the bot's activity (e.g. in /controller run). */
    public void start() {
        running = true;
        // Example sequence of actions:
        movement.moveForward(40);      // move forward for 40 ticks (~2 seconds)
        turn.turn(-90.0, 20);         // then turn left 90° over 20 ticks (~1 second)
        // The jump can be triggered later, e.g. via AI decision.
    }

    /** Called every client tick via END_CLIENT_TICK. */
    public void tick(MinecraftClient client) {
        if (!running || client.player == null || client.world == null) return;
        movement.tick(client);
        turn.tick(client);
        jump.tick(client);
    }
}
