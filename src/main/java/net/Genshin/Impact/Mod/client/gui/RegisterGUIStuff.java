package net.Genshin.Impact.Mod.client.gui;

import net.Genshin.Impact.Mod.genshin;
//import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
//import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
//import net.minecraft.util.registry.Registry;

public class RegisterGUIStuff {
    
    	
	//public static GuiBlock GUI_BLOCK;
	//public static BlockItem GUI_BLOCK_ITEM;
	//public static BlockEntityType<GuiBlockEntity> GUI_BLOCKENTITY_TYPE;
    public static ScreenHandlerType<Description> GUI_SCREEN_HANDLER_TYPE;

    public static void registerGUI() {
        /*GUI_BLOCK = new GuiBlock();
		Registry.register(Registry.BLOCK, new Identifier(genshin.MOD_ID, "gui"), GUI_BLOCK);
		GUI_BLOCK_ITEM = new BlockItem(GUI_BLOCK, new Item.Settings().group(ItemGroup.MISC));
		Registry.register(Registry.ITEM, new Identifier(genshin.MOD_ID, "gui"), GUI_BLOCK_ITEM);
		GUI_BLOCKENTITY_TYPE = FabricBlockEntityTypeBuilder.create(GuiBlockEntity::new, GUI_BLOCK).build(null);
		Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(genshin.MOD_ID, "gui"), GUI_BLOCKENTITY_TYPE);
*/
		GUI_SCREEN_HANDLER_TYPE = ScreenHandlerRegistry.registerSimple(new Identifier(genshin.MOD_ID, "gui"), (int syncId, PlayerInventory inventory) -> {
			return new Description(GUI_SCREEN_HANDLER_TYPE, syncId, inventory, ScreenHandlerContext.EMPTY);
        }); 
    }   
}
