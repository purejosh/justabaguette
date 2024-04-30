
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.purejosh.justabaguette.init;

import net.purejosh.justabaguette.item.BaguetteItem;
import net.purejosh.justabaguette.JustabaguetteMod;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;

public class JustabaguetteModItems {
	public static Item BAGUETTE;

	public static void load() {
		BAGUETTE = Registry.register(BuiltInRegistries.ITEM, new ResourceLocation(JustabaguetteMod.MODID, "baguette"), new BaguetteItem());
	}
}
