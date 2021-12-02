package net.Genshin.Impact.Mod.blocks.model;

import net.Genshin.Impact.Mod.genshin;
import net.Genshin.Impact.Mod.blocks.tile.WishingBlockTileEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WishingBlockModel extends AnimatedGeoModel<WishingBlockTileEntity> {



    
	@Override
	public Identifier getAnimationFileLocation(WishingBlockTileEntity animatable) {
			return new Identifier(genshin.MOD_ID + ":animations/wishblock.animation.json");
    }
	@Override
	public Identifier getModelLocation(WishingBlockTileEntity animatable) {
		return new Identifier(genshin.MOD_ID + ":geo/wishing_block.geo.json");
    }

	@Override
	public Identifier getTextureLocation(WishingBlockTileEntity entity) {
		return new Identifier(genshin.MOD_ID + ":textures/block/wishbox.png");
    }
}