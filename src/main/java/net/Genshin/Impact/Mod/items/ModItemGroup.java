package net.Genshin.Impact.Mod.items;


import net.Genshin.Impact.Mod.genshin;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
        new Identifier(genshin.MOD_ID, "general"),
        () -> new ItemStack(ModItems.Primogem));

}