package net.Genshin.Impact.Mod.sounds;

import net.Genshin.Impact.Mod.genshin;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    

    
    public static final SoundEvent HILICHURL_YA = new SoundEvent(genshin.id("hilichurl_ya"));

    public static void register() {
        Registry.register(Registry.SOUND_EVENT, HILICHURL_YA.getId(), HILICHURL_YA);
    }
    
}