package net.Genshin.Impact.Mod.entity;

import net.Genshin.Impact.Mod.genshin;
import net.Genshin.Impact.Mod.entity.custom.HilichurlEntity;
import net.Genshin.Impact.Mod.entity.npc.KatheryneNPC;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public final class ModEntity {

    public static final EntityType<HilichurlEntity> HILICHURL = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier(genshin.MOD_ID, "hilichurl"),
        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HilichurlEntity::new).dimensions(EntityDimensions.fixed(.85f, 2f)).build()
    );

    public static final EntityType<KatheryneNPC> KATHERYNE = Registry.register(
        Registry.ENTITY_TYPE,
        new Identifier(genshin.MOD_ID, "katheryne"),
        FabricEntityTypeBuilder.create(SpawnGroup.MISC, KatheryneNPC::new).dimensions(EntityDimensions.fixed(.6f, 2f)).build()
    );



    public static void registerEntity() {
        FabricDefaultAttributeRegistry.register(HILICHURL, HilichurlEntity.createHilichurlAttributes());
        FabricDefaultAttributeRegistry.register(KATHERYNE, KatheryneNPC.createKatheryneAttributes());
    }

}

