package net.purejosh.justabaguette.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

public class ModItemGroups {

    public static void init() {
        // ModItems sorting
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register((itemGroup) -> itemGroup.addAfter(
                Items.BREAD.getDefaultStack(), ModItems.BAGUETTE.getDefaultStack()));
    }
}
