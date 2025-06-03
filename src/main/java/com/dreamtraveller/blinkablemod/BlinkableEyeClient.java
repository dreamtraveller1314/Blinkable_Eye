package com.dreamtraveller.blinkablemod;

import com.dreamtraveller.blinkablemod.item.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ArmorRenderer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;


public class BlinkableEyeClient implements ClientModInitializer{

    @Override
    public void onInitializeClient() {
        ArmorRenderer.register((matrices, vertexConsumers, stack, entity, slot, light, contextModel) -> {
            long time = entity.getWorld().getTime();
            boolean blink = (time / 10) % 2 == 0;

            Identifier texture = Identifier.of("blinkablemod",
                    "textures/models/armor/" + (blink ? "blinking_eye" : "close_eye") + "_layer_1.png");
            matrices.push();
            float scale = 1.05f;
            matrices.scale(scale, scale, scale);
            var vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getArmorCutoutNoCull(texture));
            contextModel.head.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV);
            matrices.pop();

        }, ModItems.BLINKING_EYE_HELMET);
    }
}