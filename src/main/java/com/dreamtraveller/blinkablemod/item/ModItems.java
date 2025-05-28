package com.dreamtraveller.blinkablemod.item;

import com.dreamtraveller.blinkablemod.BlinkableEye;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BLINKING_EYE = registerItem("blinking_eye", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(BlinkableEye.MOD_ID, name), item);
    }

    public static void registerModItems(){
        BlinkableEye.LOGGER.info("Registering Mod Items for" + BlinkableEye.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(BLINKING_EYE);
        });
    }
}
