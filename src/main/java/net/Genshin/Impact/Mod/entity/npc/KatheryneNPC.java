package net.Genshin.Impact.Mod.entity.npc;

import java.util.HashMap;
import java.util.Map;

import net.Genshin.Impact.Mod.procedures.KathRightClickedOnEntityProcedure;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class KatheryneNPC extends PathAwareEntity implements IAnimatable {
    AnimationFactory factory = new AnimationFactory(this);
    

    public final LookAtEntityGoal lookPlayerGoal = new LookAtEntityGoal(this, PlayerEntity.class, 8.0F);
    public final LookAroundGoal lookAroundGoal = new LookAroundGoal(this);


    public KatheryneNPC(EntityType<? extends PathAwareEntity> entityType, World world) {
        super(entityType, world);
        this.setInvulnerable(true);
        this.canBeLeashedBy(null);
        this.cannotDespawn();
    }


    public static DefaultAttributeContainer.Builder createKatheryneAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20D)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 2D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, 1D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.4D);
    }

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }


    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(
            new AnimationController<KatheryneNPC>(this, "controller", 0, this::predicate));
        
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

	@Override
	protected void initGoals() {
		super.initGoals();
		this.goalSelector.add(1, new LookAtEntityGoal(this, PlayerEntity.class, (float) 6));
    }

	@Override
	public ActionResult interactMob(PlayerEntity sourceentity, Hand hand) {
		sourceentity.getStackInHand(hand);
		ActionResult retval = ActionResult.success(this.world.isClient);
		this.getX();
		this.getY();
		this.getZ();
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("sourceentity", sourceentity);
			$_dependencies.put("world", world);
			KathRightClickedOnEntityProcedure.executeProcedure($_dependencies);
		}
		return retval;
	}

}

    

