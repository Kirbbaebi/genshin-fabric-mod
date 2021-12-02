package net.Genshin.Impact.Mod.client.model;

import net.Genshin.Impact.Mod.entity.npc.KatheryneNPC;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static net.Genshin.Impact.Mod.genshin.MOD_ID;

public class KatheryneModel extends AnimatedGeoModel<KatheryneNPC> {

    @Override
    public Identifier getAnimationFileLocation(KatheryneNPC enitity) {
        return new Identifier(MOD_ID, "animations/katheryne.animation.json");
    }

    @Override
    public Identifier getModelLocation(KatheryneNPC entity) {
        return new Identifier(MOD_ID, "geo/katheryne.geo.json");
    }

    @Override
    public Identifier getTextureLocation(KatheryneNPC entity) {
        return new Identifier(MOD_ID, "textures/entity/katheryne/katheryne.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(KatheryneNPC entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI /270F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}
