package net.Genshin.Impact.Mod.client.gui;

import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WTextField;
import io.github.cottonmc.cotton.gui.widget.icon.TextureIcon;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;

public class Description extends SyncedGuiDescription {
	private static final int PROPERTY_COUNT = 2;
	
    public Description(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(type, syncId, playerInventory, null, /*getBlockInventory(context, GuiBlockEntity.INVENTORY_SIZE),*/ getBlockPropertyDelegate(context, PROPERTY_COUNT));
		
		WGridPanel root = (WGridPanel)this.getRootPanel();

		WItemSlot slot = WItemSlot.of(blockInventory, 0, 4, 1);
		root.add(slot, 0, 1);

		WButton buttonA = new WButton(new LiteralText("Send Message"));

		root.add(buttonA, 0, 3, 4, 1);

		WButton buttonB = new WButton(new LiteralText("Show Warnings"));
		buttonB.setOnClick(() -> slot.setIcon(new TextureIcon(new Identifier("libgui-test", "saddle.png"))));

		root.add(buttonB, 5, 3, 4, 1);
		root.add(new WButton(new LiteralText("Button C")), 0, 5, 4, 1);
		root.add(new WButton(new LiteralText("Button D")), 5, 5, 4, 1);
		root.add(new WTextField(new LiteralText("Type something...")), 0, 7, 5, 1);

		root.add(new WLabel(new LiteralText("Large slot:")), 0, 9);
		root.add(WItemSlot.outputOf(blockInventory, 0), 4, 9);

		root.add(WItemSlot.of(blockInventory, 7).setIcon(new TextureIcon(new Identifier("libgui-test", "saddle.png"))), 7, 9);

		root.add(createPlayerInventoryPanel(), 0, 11);
		System.out.println(root.toString());

		this.getRootPanel().validate(this);

		try {
			slot.onHidden();
			slot.onShown();
		} catch (Throwable t) {
			throw new AssertionError("ValidatedSlot.setVisible crashed", t);
		}
	}
    
}
