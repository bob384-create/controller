// TurnController.java
package com.applesauce3840.controller.client;

import net.minecraft.client.MinecraftClient;

public class TurnController {
    private float targetYaw = 0f;
    private int duration = 0;
    private int elapsed = 0;

    // Simple PD (proportional-derivative) controller constants
    private final double kp = 0.5;
    private final double kd = 0.3;
    private double prevError = 0;

    /** Request a relative turn (in degrees) over a fixed duration (in ticks). */
    public void turn(double degrees, int ticks) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player == null) return;
        float currentYaw = client.player.getYaw();
        targetYaw = currentYaw + (float)degrees;
        duration = ticks;
        elapsed = 0;
        prevError = 0;
    }

    public void tick(MinecraftClient client) {
        if (elapsed >= duration || client.player == null) {
            return;
        }
        float currentYaw = client.player.getYaw();
        // Compute the smallest-angle error, accounting for wrap-around
        float error = targetYaw - currentYaw;
        while (error < -180.0F) error += 360.0F;
        while (error > 180.0F) error -= 360.0F;

        // PD controller to compute rotational step
        double derivative = error - prevError;
        double output = kp * error + kd * derivative;
        // Limit to avoid too-quick rotation
        double maxStep = 360.0 / duration;
        output = Math.max(-maxStep, Math.min(maxStep, output));

        client.player.setYaw((float)(currentYaw + output));
        prevError = error;
        elapsed++;
    }
}
