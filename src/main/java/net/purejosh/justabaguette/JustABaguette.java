package net.purejosh.justabaguette;

import net.fabricmc.api.ModInitializer;
import net.purejosh.justabaguette.item.ModItemGroups;
import net.purejosh.justabaguette.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JustABaguette implements ModInitializer {
	public static final String MOD_ID = "justabaguette";
	public static final String MOD_NAME = "Just A Baguette";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	// This code is executed when the mod is loaded.
	@Override
	public void onInitialize() {
		// This is the log line that gets printed when the mod is loaded.
		LOGGER.info(JustABaguette.MOD_NAME + " by purejosh has been loaded!");
		// Now, I call the init methods in the registry classes.
		ModItems.init();
		ModItemGroups.init();
	}
}