package net.purejosh.justabaguette.item;

import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.purejosh.justabaguette.JustABaguette;
import net.purejosh.justabaguette.component.type.ModFoodComponents;

import java.util.function.Function;

public class ModItems {

    public static final Item BAGUETTE = register("baguette",
            settings -> new Item(settings) {
                private int lastIndex = -1; // Track the last used message index

                @Override
                public void hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
                    if (!attacker.level().isClientSide() && attacker instanceof Player player) {
                        String[] keys = {
                                "item.justabaguette.baguette.hit1",
                                "item.justabaguette.baguette.hit2",
                                "item.justabaguette.baguette.hit3",
                                "item.justabaguette.baguette.hit4",
                                "item.justabaguette.baguette.hit5",
                                "item.justabaguette.baguette.hit6",
                                "item.justabaguette.baguette.hit7",
                                "item.justabaguette.baguette.hit8",
                                "item.justabaguette.baguette.hit9",
                                "item.justabaguette.baguette.hit10",
                                "item.justabaguette.baguette.hit11",
                                "item.justabaguette.baguette.hit12",
                                "item.justabaguette.baguette.hit13",
                                "item.justabaguette.baguette.hit14",
                                "item.justabaguette.baguette.hit15",
                                "item.justabaguette.baguette.hit16",
                                "item.justabaguette.baguette.hit17",
                                "item.justabaguette.baguette.hit18",
                                "item.justabaguette.baguette.hit19",
                                "item.justabaguette.baguette.hit20"
                        };
                        int newIndex;
                        do {
                            newIndex = player.getRandom().nextIntBetweenInclusive(0, keys.length - 1);
                        } while (newIndex == lastIndex);
                        lastIndex = newIndex;

                        String randomKey = keys[newIndex];
                        player.displayClientMessage(Component.translatable(randomKey), true);
                    }
                }
            },
            new Item.Properties().food(ModFoodComponents.BAGUETTE)
    );

    // Helper method for registering an item.
    public static <T extends Item> T register(String name, Function<Item.Properties, T> itemFactory, Item.Properties settings) {
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(JustABaguette.MOD_ID, name));
        T item = itemFactory.apply(settings.setId(itemKey));
        return Registry.register(BuiltInRegistries.ITEM, itemKey, item);
    }

    // Class initializer called from the entrypoint.
    public static void init() {
        CompostingChanceRegistry.INSTANCE.add(ModItems.BAGUETTE, 1f);
    }
}
