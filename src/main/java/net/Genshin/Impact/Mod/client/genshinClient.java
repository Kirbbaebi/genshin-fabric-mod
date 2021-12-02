package net.Genshin.Impact.Mod.client;

import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;
import net.Genshin.Impact.Mod.blocks.ModBlocks;
import net.Genshin.Impact.Mod.blocks.renderer.WishingBlockTileRenderer;
import net.Genshin.Impact.Mod.blocks.tile.ModBlockEntitys;
import net.Genshin.Impact.Mod.client.gui.Description;
import net.Genshin.Impact.Mod.client.gui.RegisterGUIStuff;
import net.Genshin.Impact.Mod.client.renderer.HilichurlRenderer;
import net.Genshin.Impact.Mod.client.renderer.KatheryneRenderer;
import net.Genshin.Impact.Mod.entity.ModEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.impl.blockrenderlayer.BlockRenderLayerMapImpl;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;

public class genshinClient implements ClientModInitializer {

    @SuppressWarnings({ "unchecked" })
    @Override
    public void onInitializeClient() {
        
        EntityRendererRegistry.register(ModEntity.HILICHURL, HilichurlRenderer::new);
        EntityRendererRegistry.register(ModEntity.KATHERYNE, KatheryneRenderer::new);
        BlockEntityRendererRegistry.register(ModBlockEntitys.WishingBlockTileEntity,
					(BlockEntityRendererFactory.Context rendererDispatcherIn) -> new WishingBlockTileRenderer());
        BlockRenderLayerMapImpl.INSTANCE.putBlock(ModBlocks.WishingBlock, RenderLayer.getCutout());
		

        ScreenRegistry.<Description, CottonInventoryScreen<Description>>register(
				              RegisterGUIStuff.GUI_SCREEN_HANDLER_TYPE,
				              (desc, inventory, title) -> new CottonInventoryScreen<>(desc, inventory.player, title)
		);
    };
}

