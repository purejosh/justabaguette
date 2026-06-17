package net.purejosh.justabaguette.entity;

import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.VillagerInteractionRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.purejosh.justabaguette.item.ModItems;

public class ModVillagerInteractions {

    public static void init() {
        VillagerInteractionRegistries.registerFood(ModItems.BAGUETTE, 12);

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((world, entity, random) -> new MerchantOffer(
                            new ItemCost(Items.EMERALD, 1),
                            new ItemStack(ModItems.BAGUETTE, 2),
                            12, 2, 0.05f
                    ));
                }
        );
    }
}