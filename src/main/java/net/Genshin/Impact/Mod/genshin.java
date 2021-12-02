package net.Genshin.Impact.Mod;


import net.Genshin.Impact.Mod.blocks.ModBlocks;
import net.Genshin.Impact.Mod.blocks.tile.ModBlockEntitys;
import net.Genshin.Impact.Mod.client.gui.RegisterGUIStuff;
import net.Genshin.Impact.Mod.entity.ModEntity;
import net.Genshin.Impact.Mod.items.ModItems;
import net.Genshin.Impact.Mod.procedures.KathRightClickedOnEntityProcedure;
import net.Genshin.Impact.Mod.sounds.ModSounds;
import net.fabricmc.api.ModInitializer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import software.bernie.geckolib3.GeckoLib;

public class genshin implements ModInitializer {

    public static final String MOD_ID = "genshin";

    public static SoundEvent HILICHURL_YA;
    @Override
    public void onInitialize() {
        new KathRightClickedOnEntityProcedure();
        GeckoLib.initialize();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModBlockEntitys.registerModBlockEntitys();
        ModSounds.register();
        ModEntity.registerEntity();
        RegisterGUIStuff.registerGUI();
        
        System.out.println("Hello Fabric world!");
    }

    public static Identifier id(String namespace) {
        return new Identifier(MOD_ID, namespace);
    }
    
}