package net.purejosh.justabaguette.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.world.item.Item;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Registry;
import net.minecraft.core.HolderLookup;
import net.purejosh.justabaguette.item.ModItems;

import java.lang.reflect.Field;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class ModLangProvider extends FabricLanguageProvider {
    public ModLangProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    // Override for any block/item name
    private static final Map<String, String> OVERRIDES = Map.ofEntries(
    );

    @Override
    public void generateTranslations(HolderLookup.Provider wrapperLookup, TranslationBuilder t) {

        // Items
        for (Field f : ModItems.class.getFields()) {
            if (f.getType().isAssignableFrom(Item.class)) {
                addEntry(f, BuiltInRegistries.ITEM, t::add);
            }
        }

        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit1", "Baguette bonk!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit2", "Ooh la la!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit3", "Crisp crit!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit4", "Painful pain!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit5", "Gluten tag!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit6", "Yeast beaten!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit7", "Dough! That hurt.");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit8", "Bread-knuckle sandwich!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit9", "Rise and whine!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit10", "Baguette‑yo‑face!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit11", "Soggy slap!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit12", "Crumb bump!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit13", "Breadstick beatdown!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit14", "Flour power!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit15", "Boule‑dozer!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit16", "Stale strike!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit17", "Butter believe it hurts!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit18", "Loaf‑a my fist!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit19", "Toast‑ed!");
        t.add(ModItems.BAGUETTE.getDescriptionId() + ".hit20", "Baguette outta here!");
    }

    // Iterates over every entry from the previous calls, and creates an en_us translation from the registry key name
    @SuppressWarnings("unchecked")
    private <T> void addEntry(Field field, Registry<T> registry, BiConsumer<T, String> adder) {
        try {
            T value = (T) field.get(null);
            if (value != null) {
                String path = Objects.requireNonNull(registry.getKey(value)).getPath();
                adder.accept(value, OVERRIDES.getOrDefault(path, humanize(path)));
            }
        } catch (Exception ignored) {}
    }

    private static String humanize(String path) {
        if (OVERRIDES.containsKey(path)) return OVERRIDES.get(path);

        String[] parts = path.split("_");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String p = parts[i].toLowerCase(Locale.ROOT);
            // small word handling (optional): keep "of", "and" lowercase unless first word
            String word = Character.toUpperCase(p.charAt(0)) + p.substring(1);
            if (i > 0) sb.append(' ');
            sb.append(word);
        }
        return sb.toString();
    }
}
