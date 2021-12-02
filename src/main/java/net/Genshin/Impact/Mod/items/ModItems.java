package net.Genshin.Impact.Mod.items;

import net.Genshin.Impact.Mod.genshin;
import net.Genshin.Impact.Mod.blocks.ModBlocks;
import net.Genshin.Impact.Mod.items.custom.CoalesentFate;
import net.Genshin.Impact.Mod.items.custom.Primogem;
import net.Genshin.Impact.Mod.items.custom.Handbook;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //actual items
    public static final Item Primogem = registerItem("primogem",
        new Primogem(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP).rarity(Rarity.RARE)));

    public static final Item CoalesentFate = registerItem("coalesent_fate",
        new CoalesentFate(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP).rarity(Rarity.EPIC)));

    public static final Item Handbook = registerItem("handbook",
        new Handbook(new FabricItemSettings().group(ModItemGroup.ITEM_GROUP).rarity(Rarity.UNCOMMON)));

    //characters


    //weapons


    //artifacts


    //block items
    public static final BlockItem WishingBlockItem = registerBlockItem("wishing_block", 
        new BlockItem(ModBlocks.WishingBlock, new FabricItemSettings().group(ModItemGroup.ITEM_GROUP).rarity(Rarity.UNCOMMON)));



    
    


    //Registering    
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(genshin.MOD_ID, name), item);
    }

    private static BlockItem registerBlockItem(String name, BlockItem blockItem) {
        return Registry.register(Registry.ITEM, new Identifier(genshin.MOD_ID, name), blockItem);
    }


    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + genshin.MOD_ID);
    }

}   