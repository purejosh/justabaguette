package net.purejosh.justabaguette.component.type;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent BAGUETTE = new FoodComponent.Builder()
            .nutrition(15)
            .saturationModifier(0.6f)
            .build();
}