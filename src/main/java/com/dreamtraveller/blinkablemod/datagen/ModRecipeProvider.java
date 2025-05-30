package com.dreamtraveller.blinkablemod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import com.dreamtraveller.blinkablemod.block.ModBlocks;
import com.dreamtraveller.blinkablemod.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BLINKING_EYE_BLOCK)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .input('R', ModItems.BLINKING_EYE)
                .criterion(hasItem(ModItems.BLINKING_EYE), conditionsFromItem(ModItems.BLINKING_EYE))
                .offerTo((RecipeExporter) ModBlocks.BLINKING_EYE_BLOCK);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BLINKING_EYE, 9)
                .input(ModBlocks.BLINKING_EYE_BLOCK)
                .criterion(hasItem(ModBlocks.BLINKING_EYE_BLOCK), conditionsFromItem(ModBlocks.BLINKING_EYE_BLOCK))
                .offerTo((RecipeExporter) ModItems.BLINKING_EYE);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.CHISEL)
                .pattern("R")
                .pattern("#")
                .pattern("#")
                .input('R', ModItems.BLINKING_EYE)
                .input('#', Items.STICK)
                .criterion(hasItem(ModItems.BLINKING_EYE), conditionsFromItem(ModItems.BLINKING_EYE))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo((RecipeExporter) ModItems.CHISEL);
    }
}
