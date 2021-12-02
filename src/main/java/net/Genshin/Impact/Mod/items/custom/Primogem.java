package net.Genshin.Impact.Mod.items.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Primogem extends Item {
    public Primogem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        playerEntity.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, 0.7F, 1.0F);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
    
    
}