package net.Genshin.Impact.Mod.procedures;

import java.util.Map;

import net.Genshin.Impact.Mod.items.ModItems;
import net.Genshin.Impact.Mod.mixin.PlayerEntityMixin;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class KathRightClickedOnEntityProcedure {

	public static String executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("sourceentity") == null) {
			System.err.println("Failed to load dependency sourceentity for procedure KathRightClickedOnEntity!");
			return "";
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure KathRightClickedOnEntity!");
			return "";
		}
		Entity sourceentity = (Entity) dependencies.get("sourceentity");
		World world = (World) dependencies.get("world");
		if ((PlayerEntityMixin.bookCheck() == (true))) {
			return "I already gave you a handbook!";
		} else {
			if (!world.isClient()) {
				ItemEntity entityToSpawn = new ItemEntity(world, (sourceentity.getX()), (sourceentity.getY()), (sourceentity.getZ()),
						new ItemStack(ModItems.Handbook));
				entityToSpawn.setPickupDelay(10);
				world.spawnEntity(entityToSpawn);
				PlayerEntityMixin.GotBook();
			}
		
			return "There is your handbook!";
		}
	}
}

