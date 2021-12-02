package net.Genshin.Impact.Mod.client.renderer;

import org.jetbrains.annotations.Nullable;

import net.Genshin.Impact.Mod.client.model.KatheryneModel;
import net.Genshin.Impact.Mod.entity.npc.KatheryneNPC;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.geo.render.built.GeoModel;

public class KatheryneRenderer extends GeoMobRenderer<KatheryneNPC> {
    public KatheryneRenderer(EntityRendererFactory.Context ctx) {
        super(ctx, new KatheryneModel());
    }

    @Override
    public RenderLayer getRenderType(KatheryneNPC animatable, float partialTicks, MatrixStack stack,
                                     @Nullable VertexConsumerProvider renderTypeBuffer, @Nullable VertexConsumer vertexBuilder,
                                     int packedLightIn, Identifier textureLocation) {
        return RenderLayer.getEntityTranslucent(this.getTextureLocation(animatable));
    }

    @Override
    public void render(GeoModel model, KatheryneNPC animatable, float partialTicks, RenderLayer type,
                       MatrixStack matrixStackIn, VertexConsumerProvider renderTypeBuffer, VertexConsumer vertexBuilder,
                       int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {

        super.render(model, animatable, partialTicks, type, matrixStackIn, renderTypeBuffer, vertexBuilder,
                packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
