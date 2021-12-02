package net.Genshin.Impact.Mod.items.custom;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import net.Genshin.Impact.Mod.client.gui.HandbookExp;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Handbook extends Item{
    public Handbook(Settings settings) {
        super(settings);
    }


	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (world.isClient) {
			openScreen();
		}
		return super.use(world, user, hand);
		
	}
	@Environment(EnvType.CLIENT)
	private void openScreen() {
		MinecraftClient.getInstance().setScreen(new CottonClientScreen(new HandbookExp()));
	}
}