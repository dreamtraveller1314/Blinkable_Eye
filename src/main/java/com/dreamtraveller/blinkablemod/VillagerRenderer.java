package com.dreamtraveller.blinkablemod;

import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.util.Identifier;

public abstract class VillagerRenderer {
    public abstract Identifier getTexture(VillagerEntity entity);
}
