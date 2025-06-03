package com.dreamtraveller.blinkablemod;

import com.dreamtraveller.blinkablemod.block.ModBlocks;
import com.dreamtraveller.blinkablemod.item.ModItemGroups;
import com.dreamtraveller.blinkablemod.item.ModItems;
import com.dreamtraveller.blinkablemod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BlinkableEye implements ModInitializer {
	public static final String MOD_ID = "blinkablemod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModWorldGeneration.generateModWorldGen();
	}
}