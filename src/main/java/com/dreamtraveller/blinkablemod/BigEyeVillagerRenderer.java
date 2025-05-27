package com.dreamtraveller.blinkablemod;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;


import java.util.WeakHashMap;
import java.util.Random;

public class BigEyeVillagerRenderer extends VillagerRenderer {
    private static final Identifier BIG_EYES_TEXTURE = new Identifier("blinkablemod", "resources/assets/blinkablemod/icon.png");

    private static final Identifier BLINK_TEXTURE = new Identifier("blinkablemod", "resources/assets/blinkablemod/icon.png");

    private final WeakHashMap<VillagerEntity, Integer> nextBlinkMap = new WeakHashMap<>();
    private final Random random = new Random();

    public BigEyeVillagerRenderer(EntityRendererFactory.Context context) {
        wait(context, new VillagerModel(context.getPart(EntityModelLayers.VILLAGER)), 0.5f);
    }

    private void wait(EntityRendererFactory.Context context, VillagerModel villagerModel, float v) {
    }

    @Override
    public Identifier getTexture(VillagerEntity entity) {
        int currentTick = entity.age;

        // Initialize next blink time if not set
        nextBlinkMap.putIfAbsent(entity, currentTick + random.nextInt(100) + 60);  // random between 3–8 seconds

        int nextBlinkTick = nextBlinkMap.get(entity);

        // Blink lasts for 5 ticks
        if (currentTick >= nextBlinkTick && currentTick < nextBlinkTick + 5) {
            return BLINK_TEXTURE;
        }

        // Reset blink timer after blinking finishes
        if (currentTick >= nextBlinkTick + 5) {
            nextBlinkMap.put(entity, currentTick + random.nextInt(100) + 60);
        }

        return BIG_EYES_TEXTURE;
    }
}
