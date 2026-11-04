package ru.college.i923v.fierysword;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

public class ModItems {


    public static final Item FIERY_SWORD = register(
            "fiery_sword",
            new FierySwordItem(
                    Tiers.NETHERITE,
                    new Item.Properties()
                            .stacksTo(1)
                            .durability(3000)
                            .attributes(
                                    FierySwordItem.createAttributes(
                                            Tiers.NETHERITE,
                                            5,      // доп. урон → итого ~10
                                            -2.4f   // скорость атаки меча
                                    )
                            )
            )
    );


    private static Item register(String name, Item item) {
        return Registry.register(
                BuiltInRegistries.ITEM,
                ResourceLocation.fromNamespaceAndPath(FierySword.MOD_ID, name),
                item
        );
    }


    public static void initialize() {
        // Вкладка "Бой" / Combat
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(entries -> {
            entries.accept(FIERY_SWORD);
        });
    }

}
