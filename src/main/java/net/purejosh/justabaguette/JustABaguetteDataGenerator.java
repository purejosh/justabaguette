package net.purejosh.justabaguette;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.purejosh.justabaguette.datagen.ModItemTagProvider;
import net.purejosh.justabaguette.datagen.ModLangProvider;
import net.purejosh.justabaguette.datagen.ModModelProvider;
import net.purejosh.justabaguette.datagen.ModRecipeProvider;

public class JustABaguetteDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModModelProvider::new);
		pack.addProvider(ModRecipeProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		pack.addProvider(ModLangProvider::new);
	}
}
