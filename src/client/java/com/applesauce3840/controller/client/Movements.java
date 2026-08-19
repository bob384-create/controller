package com.applesauce3840.controller.client;

import net.minecraft.client.MinecraftClient;

public class Movements {

    //variables ooo

    //movement always is good

    public static void moveForward() {
        MinecraftClient.getInstance().player.input.movementForward = 1.0f;
    }

    public static void moveBackward() {
        MinecraftClient.getInstance().player.input.movementForward = -1.0f;
    }

    public static void moveLeft() {
        MinecraftClient.getInstance().player.input.movementSideways = 1.0f;
    }

    public static void moveRight() {
        MinecraftClient.getInstance().player.input.movementSideways = -1.0f;
    }

    public static void stopForwardBackward() {
        MinecraftClient.getInstance().player.input.movementForward = 0.0f;
    }

    public static void stopLeftRight() {
        MinecraftClient.getInstance().player.input.movementSideways = 0.0f;
    }
}