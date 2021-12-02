package net.Genshin.Impact.Mod.client.model;

import net.Genshin.Impact.Mod.entity.custom.HilichurlEntity;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

import static net.Genshin.Impact.Mod.genshin.MOD_ID;

public class HilichurlModel extends AnimatedGeoModel<HilichurlEntity> {

    @Override
    public Identifier getAnimationFileLocation(HilichurlEntity enitity) {
        return new Identifier(MOD_ID, "animations/hilichurl.animation.json");
    }

    @Override
    public Identifier getModelLocation(HilichurlEntity entity) {
        return new Identifier(MOD_ID, "geo/hilichurl.geo.json");
    }

    @Override
    public Identifier getTextureLocation(HilichurlEntity entity) {
        return new Identifier(MOD_ID, "textures/entity/hilichurl/hilichurl.png");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void setLivingAnimations(HilichurlEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        if (head != null) {
            head.setRotationX(extraData.headPitch * ((float) Math.PI /270F));
            head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
        }
    }
}