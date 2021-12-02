package net.Genshin.Impact.Mod.blocks.tile;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.Genshin.Impact.Mod.genshin;
import net.Genshin.Impact.Mod.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class ModBlockEntitys {
	public static BlockEntityType<WishingBlockTileEntity> WishingBlockTileEntity = registerBlockEntity("wishing_block", FabricBlockEntityTypeBuilder.create(WishingBlockTileEntity::new, ModBlocks.WishingBlock).build(null));

    private static BlockEntityType<WishingBlockTileEntity> registerBlockEntity(String name, BlockEntityType<WishingBlockTileEntity> blockEntityType) {
        return Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(genshin.MOD_ID, name), blockEntityType);
    }



    public static void registerModBlockEntitys() {
        System.out.println("Registering Mod Block Entitys for " + genshin.MOD_ID);
    }
}
