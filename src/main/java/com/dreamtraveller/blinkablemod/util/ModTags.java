package com.dreamtraveller.blinkablemod.util;

import com.dreamtraveller.blinkablemod.BlinkableEye;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.block.Block;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> EYE_ITEMS = createTag("eye_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(BlinkableEye.MOD_ID, name));
        }
    }

    public static class Blocks{

        public static final TagKey<Block> EYE_BLOCKS = createTag("eye_blocks");

        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(BlinkableEye.MOD_ID, name));
        }
    }
}
