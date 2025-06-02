package com.dreamtraveller.blinkablemod.item.custom;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;

public class BlinkingEyeArmorItem extends ArmorItem {

    public BlinkingEyeArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    // No need for getArmorTexture() override — handled on client via ArmorRenderer
}
