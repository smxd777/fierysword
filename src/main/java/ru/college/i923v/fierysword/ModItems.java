package ru.college.i923v.fierysword;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModItems {

    public static final Item FIERY_SWORD = register(
            "fiery_sword",
            new Item(new Item.Properties().stacksTo(1).durability(3000))
    );

    private static Item register(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(FierySword.MOD_ID, name),
                item
        );
    }

    public static void initialize() {
    }
}