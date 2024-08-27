package net.purejosh.justabaguette.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.purejosh.justabaguette.JustABaguette;
import net.purejosh.justabaguette.component.type.ModFoodComponents;

public class ModItems {

    public static final Item BAGUETTE = register("baguette", new Item(new Item.Settings()
            .food(ModFoodComponents.BAGUETTE)));

    // Helper method for registering an item.
    public static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(JustABaguette.MOD_ID, id), item);
    }

    // Class initializer called from the entrypoint.
    public static void init() {
    }
}
