package net.Genshin.Impact.Mod.mixin;

import net.minecraft.structure.pool.StructurePool;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.structure.pool.StructurePools;
import net.minecraft.structure.processor.StructureProcessorLists;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.Genshin.Impact.Mod.feature.ModifiableStructurePool;

@Mixin(StructurePools.class)
public class StructurePoolsMixin {
    @Inject(method = "register", at = @At("HEAD"), cancellable = true)
    private static void registerMixin(StructurePool spool, CallbackInfoReturnable<StructurePool> cir) {
        StructurePool pool = spool;
        pool = tryAddElementToPool(new Identifier("village/plains/houses"), pool, "genshin:village/plains/houses/plainsguild", StructurePool.Projection.RIGID, 2);
        pool = tryAddElementToPool(new Identifier("village/desert/houses"), pool, "genshin:village/desert/houses/desertguild", StructurePool.Projection.RIGID, 2);
        pool = tryAddElementToPool(new Identifier("village/savanna/houses"), pool, "genshin:village/savanna/houses/acaciaguild", StructurePool.Projection.RIGID, 2);
        pool = tryAddElementToPool(new Identifier("village/taiga/houses"), pool, "genshin:village/taiga/houses/spruceguild", StructurePool.Projection.RIGID, 2);
        pool = tryAddElementToPool(new Identifier("village/snowy/houses"), pool, "genshin:village/snowy/houses/snowguild", StructurePool.Projection.RIGID, 2);

        cir.setReturnValue(BuiltinRegistries.add(BuiltinRegistries.STRUCTURE_POOL, pool.getId(), pool));
        cir.cancel();
    }

	private static StructurePool tryAddElementToPool(Identifier targetPool, StructurePool pool, String elementId, StructurePool.Projection projection, int weight) {
        if(targetPool.equals(pool.getId())) {
            ModifiableStructurePool modPool = new ModifiableStructurePool(pool);
            modPool.addStructurePoolElement(StructurePoolElement.ofProcessedLegacySingle(elementId, StructureProcessorLists.EMPTY).apply(projection), weight);
            return modPool.getStructurePool();
        }
        return pool;
    }
}