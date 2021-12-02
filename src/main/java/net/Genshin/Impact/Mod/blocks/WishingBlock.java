package net.Genshin.Impact.Mod.blocks;

import org.jetbrains.annotations.Nullable;

import net.Genshin.Impact.Mod.blocks.tile.ModBlockEntitys;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;

public class WishingBlock extends FacingBlock implements BlockEntityProvider{

    public WishingBlock() {
        super(FabricBlockSettings.of(Material.METAL).hardness(5.0f).nonOpaque());
    }

	@Override
	public BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.ENTITYBLOCK_ANIMATED;
	}

	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(FACING);
	}

	@Override
	public BlockState getPlacementState(ItemPlacementContext context) {
		return this.getDefaultState().with(FACING, context.getPlayerLookDirection().getOpposite());
	}

    
    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos Ppos, BlockState Spos) {
        return ModBlockEntitys.WishingBlockTileEntity.instantiate(Ppos, Spos);
    }
}
