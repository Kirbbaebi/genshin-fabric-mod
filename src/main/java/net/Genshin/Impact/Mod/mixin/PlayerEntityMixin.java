package net.Genshin.Impact.Mod.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.At;

import net.Genshin.Impact.Mod.ext.PlayerEntityExt;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity implements PlayerEntityExt{

    private static boolean firstKath = false;
    public int FourPity = 0;
    public int FivePity = 0;

    private static int wishCount;




    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
        }
    
    public static boolean bookCheck() {
        if (firstKath == false) {
            return false;
        }
        return firstKath;
    }

    public static boolean GotBook() {
        if (bookCheck() == false){
            firstKath = true;
        }
        return firstKath;
    }




    public static void NewWish(int wish) {
        wishCount = wishCount + wish;
    }

    public void addFourPity(int fouramount) {
        wishCount += fouramount;
        System.out.println(fouramount);
    }

    public void addFivePity(int fiveamount) {
        wishCount += fiveamount;
        System.out.println(fiveamount);
    }




    @Inject(method = "writeCustomDataToTag", at = @At("RETURN"))
    public void writeCustomDataToTag(NbtCompound tag, CallbackInfo ci) {
        tag.putInt("wishCount", PlayerEntityMixin.wishCount);
    }

    @Inject(method = "readCustomDataToTag", at = @At("RETURN"))
    public void readCustomDataToTag(NbtCompound tag, CallbackInfo ci) {
        wishCount = tag.getInt("wishCount");
    }
}
