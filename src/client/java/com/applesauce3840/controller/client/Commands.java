// Commands.java
package com.applesauce3840.controller.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;

public class Commands {

    /** Register the /controller run command. */
    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    ClientCommandManager.literal("controller")
                            .then(ClientCommandManager.literal("run")
                                    .executes(context -> {
                                        // Activate the bot controller
                                        BotController.getInstance().start();
                                        // Send feedback to player
                                        MinecraftClient client = MinecraftClient.getInstance();
                                        client.player.sendMessage(
                                                Text.literal("Controller bot is online with no goal!"),
                                                MessageType.SYSTEM, client.player.getUuid()
                                        );
                                        return 1;
                                    })
                            )
            );
        });
    }
}
