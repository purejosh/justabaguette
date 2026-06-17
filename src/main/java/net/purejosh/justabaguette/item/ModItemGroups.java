package net.purejosh.justabaguette.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;

public class ModItemGroups {

    public static void init() {
        // ModItems sorting
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FOOD_AND_DRINKS).register((itemGroup) -> itemGroup.addAfter(
                Items.BREAD.getDefaultInstance(), ModItems.BAGUETTE.getDefaultInstance()));
    }
}
