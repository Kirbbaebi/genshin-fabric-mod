/*
package net.Genshin.Impact.Mod.client.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Rarity;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class GuiItem extends Item {

	public GuiItem() {
		super(new Item.Settings().group(ItemGroup.TOOLS).rarity(Rarity.EPIC));
	}
	
	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
		if (world.isClient) {
			openScreen(); // In its own method to prevent class loading issues
		}
		
		return new TypedActionResult<ItemStack>(ActionResult.SUCCESS, (hand==Hand.MAIN_HAND) ? player.getMainHandStack() : player.getOffHandStack());
	}

	@Environment(EnvType.CLIENT)
	private void openScreen() {
		MinecraftClient.getInstance().setScreen(new CottonClientScreen(new HandbookOpen()));
	}
}
*/
