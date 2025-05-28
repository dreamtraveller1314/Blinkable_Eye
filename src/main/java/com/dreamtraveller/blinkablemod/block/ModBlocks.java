package com.dreamtraveller.blinkablemod.block;

import com.dreamtraveller.blinkablemod.BlinkableEye;
import com.dreamtraveller.blinkablemod.block.custom.Blinking_Eye_Block;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLINKING_EYE_BLOCK = registerBlock("blinking_eye_block",
            new Blinking_Eye_Block(AbstractBlock.Settings.create().strength(3f).sounds(BlockSoundGroup.CHERRY_WOOD)));

    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(BlinkableEye.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block){
        Registry.register(Registries.ITEM, Identifier.of(BlinkableEye.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        BlinkableEye.LOGGER.info("Registering Mod Blocks for " + BlinkableEye.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.BLINKING_EYE_BLOCK);
        }) ;
    }

}
