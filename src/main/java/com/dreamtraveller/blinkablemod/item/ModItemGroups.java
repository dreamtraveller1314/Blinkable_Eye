package com.dreamtraveller.blinkablemod.item;

import com.dreamtraveller.blinkablemod.BlinkableEye;
import com.dreamtraveller.blinkablemod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup BLINKING_EYE_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(BlinkableEye.MOD_ID,"blinking_eye_group"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModItems.BLINKING_EYE))
                    .displayName(Text.translatable("itemgroup.blinkablemod.blinking_eye_group"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.BLINKING_EYE);
                        entries.add(ModBlocks.BLINKING_EYE_BLOCK);
                    }).build());

    public static void registerItemGroups(){
        BlinkableEye.LOGGER.info("Registering Item Groups  for " + BlinkableEye.MOD_ID);
    }

}
