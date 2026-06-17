package net.purejosh.justabaguette.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.purejosh.justabaguette.item.ModItems;

public class ModLootTableModifiers {

    private static ResourceKey<LootTable> lootKey(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("minecraft", path));
    }

    public static void addToLootTable(String tablePath, Item item, int weight, int minCount, int maxCount) {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) return;

            if (key.equals(lootKey(tablePath))) {
                LootPool.Builder poolBuilder = LootPool.lootPool()
                        .add(LootItem.lootTableItem(item).setWeight(weight));

                if (minCount != 1 || maxCount != 1) {
                    poolBuilder.apply(SetItemCountFunction.setCount(
                            UniformGenerator.between(minCount, maxCount)
                    ));
                }

                tableBuilder.withPool(poolBuilder);
            }
        });
    }

    public static void init() {
        addToLootTable("chests/abandoned_mineshaft", ModItems.BAGUETTE, 4, 1, 2);
        addToLootTable("chests/stronghold_corridor", ModItems.BAGUETTE, 6, 1, 3);
        addToLootTable("chests/stronghold_crossing", ModItems.BAGUETTE, 6, 1, 3);
        addToLootTable("spawners/trial_chamber/consumables", ModItems.BAGUETTE, 8, 1, 1);
        addToLootTable("gameplay/hero_of_the_village/farmer_gift", ModItems.BAGUETTE, 20, 1, 3);
        addToLootTable("chests/woodland_mansion", ModItems.BAGUETTE, 5, 1, 4);
        addToLootTable("chests/village/village_plains_house", ModItems.BAGUETTE, 8, 1, 4);
        addToLootTable("chests/village/village_toolsmith", ModItems.BAGUETTE, 10, 1, 4);
        addToLootTable("chests/spawn_bonus_chest", ModItems.BAGUETTE, 10, 1, 4);
    }
}
