package net.purejosh.justabaguette;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.purejosh.justabaguette.entity.ModVillagerInteractions;
import net.purejosh.justabaguette.item.ModItemGroups;
import net.purejosh.justabaguette.item.ModItems;
import net.purejosh.justabaguette.loot.ModLootTableModifiers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JustABaguette implements ModInitializer {
	public static final String MOD_ID = "justabaguette";
	public static final String MOD_NAME = "Just A Baguette";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
	private static final boolean DEV_MODE = FabricLoader.getInstance().isDevelopmentEnvironment();

	// Allows for logging in dev environments, but won't log in release environments.
	public static void devLogging(Player player, String message) {
		if (DEV_MODE) {
			if (player != null) player.displayClientMessage(Component.literal(message), true);
			LOGGER.info(message);
		}
	}

	// This code is executed when the mod is loaded.
	@Override
	public void onInitialize() {
		// Capture start time
		long startTime = System.currentTimeMillis();

		// Begin initializations
		ModItems.init();
		ModItemGroups.init();
		ModLootTableModifiers.init();
		ModVillagerInteractions.init();

		// Log elapsed time
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		LOGGER.info(MOD_NAME + " by purejosh has been loaded! Initialization took {} milliseconds.", elapsedTime);
	}
}
