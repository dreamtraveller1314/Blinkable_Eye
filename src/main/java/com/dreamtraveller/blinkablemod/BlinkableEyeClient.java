package com.dreamtraveller.blinkablemod;

import net.fabricmc.api.ClientModInitializer;

public class BlinkableEyeClient implements ClientModInitializer{
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityType.VILLAGER, BigEyeVillagerRenderer::new);
    }
}
