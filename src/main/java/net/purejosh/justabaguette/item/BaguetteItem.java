
package net.purejosh.justabaguette.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.food.FoodProperties;

public class BaguetteItem extends Item {
	public BaguetteItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_FOOD).stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(15).saturationMod(0.6f)

				.build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 50;
	}
}
