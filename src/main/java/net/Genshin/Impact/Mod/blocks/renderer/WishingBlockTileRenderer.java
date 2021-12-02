package net.Genshin.Impact.Mod.blocks.renderer;

import net.Genshin.Impact.Mod.blocks.model.WishingBlockModel;
import net.Genshin.Impact.Mod.blocks.tile.WishingBlockTileEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.renderers.geo.GeoBlockRenderer;

public class WishingBlockTileRenderer extends GeoBlockRenderer<WishingBlockTileEntity> {
	public WishingBlockTileRenderer() {
		super(new WishingBlockModel());
	}

	@Override
	public RenderLayer getRenderType(WishingBlockTileEntity animatable, float partialTicks, MatrixStack stack,
			VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			Identifier textureLocation) {
		return RenderLayer.getEntityTranslucent(getTextureLocation(animatable));
	}
}