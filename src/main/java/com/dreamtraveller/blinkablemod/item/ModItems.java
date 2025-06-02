package com.dreamtraveller.blinkablemod.item;

import com.dreamtraveller.blinkablemod.BlinkableEye;
import com.dreamtraveller.blinkablemod.item.custom.BlinkingEyeArmorItem;
import com.dreamtraveller.blinkablemod.item.custom.ChiselItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item BLINKING_EYE = registerItem("blinking_eye", new Item(new Item.Settings()));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    //    public static final Item BLINKING_EYE_HELMET = registerItem("blinking_eye_helmet",
//            new ArmorItem(ModArmorMaterials.BLINKING_EYE_ARMOR_MATERIAL,  ArmorItem.Type.HELMET, new Item.Settings()
//                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));
    public static final Item BLINKING_EYE_HELMET = Registry.register(
            Registries.ITEM, Identifier.of("blinkablemod", "blinking_eye_helmet"),
            new BlinkingEyeArmorItem(ModArmorMaterials.BLINKING_EYE_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(15))));

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
