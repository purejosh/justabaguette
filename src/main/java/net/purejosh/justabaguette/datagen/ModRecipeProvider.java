package net.purejosh.justabaguette.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.item.Items;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.purejosh.justabaguette.JustABaguette;
import net.purejosh.justabaguette.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider wrapperLookup, RecipeOutput recipeExporter) {
        return new RecipeProvider(wrapperLookup, recipeExporter) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.FOOD, ModItems.BAGUETTE)
                        .pattern("BBB")
                        .define('B', Items.BREAD)
                        .group("baguette")
                        .unlockedBy(getHasName(Items.BREAD), has(Items.BREAD))
                        .save(output);
                shaped(RecipeCategory.FOOD, ModItems.BAGUETTE, 3)
                        .pattern("HHH")
                        .define('H', Items.HAY_BLOCK)
                        .group("baguette")
                        .unlockedBy(getHasName(Items.HAY_BLOCK), has(Items.HAY_BLOCK))
                        .save(output, String.valueOf(Identifier.fromNamespaceAndPath(JustABaguette.MOD_ID, "baguette_from_hay_block")));
            }
        };
    }

    @Override
    public String getName() {
        return "Recipe Provider";
    }
}