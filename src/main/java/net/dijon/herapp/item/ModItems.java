package net.dijon.herapp.item;

import net.dijon.herapp.HerobrineApple;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item HEROBRINE_APPLE = registerItem("herobrine_apple", new HerobrineAppleLighter(new FabricItemSettings().food(ModFoodComponents.HAPPLE)));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(HerobrineApple.MOD_ID, name), item);
    }

    private static void ingredientGroup(FabricItemGroupEntries entries){
        entries.add(HEROBRINE_APPLE);
    }

    public static void registerModItems(){
        HerobrineApple.LOGGER.info("Registering Items");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::ingredientGroup);
    }
}
