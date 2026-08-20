// ControllerClient.java
package com.applesauce3840.controller.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class ControllerClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Register command(s)
		Commands.register();
		// Register the per-tick callback exactly once
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			BotController.getInstance().tick(client);
		});
	}
}
