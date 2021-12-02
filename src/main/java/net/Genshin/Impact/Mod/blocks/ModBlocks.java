package net.Genshin.Impact.Mod.blocks;

import net.Genshin.Impact.Mod.genshin;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {
    
    public static final Block WishingBlock = registerBlock("wishing_block",
        new WishingBlock());



    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(genshin.MOD_ID, name), block);
    }


    public static void registerModBlocks() {
        System.out.println("Registering Mod Blocks for " + genshin.MOD_ID);
    }

}