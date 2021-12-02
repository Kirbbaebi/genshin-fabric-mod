package net.Genshin.Impact.Mod.blocks.tile;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class WishingBlockTileEntity extends BlockEntity implements IAnimatable {
	private final AnimationFactory manager = new AnimationFactory(this);

    public WishingBlockTileEntity(BlockPos Ppos, BlockState Spos) {
        super(ModBlockEntitys.WishingBlockTileEntity, Ppos, Spos);
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
		AnimationController<?> controller = event.getController();
		controller.transitionLengthTicks = 0;
		if (event.getAnimatable() != null) {
			controller.setAnimation(new AnimationBuilder().addAnimation("animation.model.idle", true));
		}
		return PlayState.CONTINUE;
	}

	@Override
	public void registerControllers(AnimationData data) {
		data.addAnimationController(
				new AnimationController<WishingBlockTileEntity>(this, "controller", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.manager;
	}
}