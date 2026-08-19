package com.applesauce3840.controller.client;

import net.fabricmc.api.ClientModInitializer;


public class ControllerClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		Commands.register();
	}
}