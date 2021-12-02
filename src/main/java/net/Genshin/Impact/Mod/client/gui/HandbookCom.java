package net.Genshin.Impact.Mod.client.gui;

import io.github.cottonmc.cotton.gui.PropertyDelegateHolder;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WBar;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import io.github.cottonmc.cotton.gui.widget.WBar.Direction;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;


public class HandbookCom extends LightweightGuiDescription implements PropertyDelegateHolder{

    public HandbookCom() { 
        WPlainPanel root = new WPlainPanel();
        this.setRootPanel(root);
        root.setSize(600, 329);
        
        //background
        WSprite book = new WSprite(new Identifier("genshin:textures/gui/handbookopen.png"));
        root.add(book, 0, 0, 600, 329);


        //button stuff
        WButton exp = new WButton(new LiteralText("Experience"));
        WButton com = new WButton(new LiteralText("Commissions"));
        WButton dom = new WButton(new LiteralText("Domains"));
        WButton bos = new WButton(new LiteralText("Bosses"));
        WButton X = new WButton(new LiteralText("X"));

        WBar progress = new WBar(new Identifier("genshin:textures/gui/circle_back.png"), new Identifier("genshin:textures/gui/circle_fill.png"), 0, 2, Direction.RIGHT);

        //adding them all
        root.add(new WLabel(new LiteralText("Daily Commissions Rewards")), 86,23,50,35);

        root.add(new WLabel(new LiteralText("Complete 2 Commissions")), 92,43,79,74);
        root.add(new WLabel(new LiteralText("daily to recieve bonus")), 94,51,79,74);
        root.add(new WLabel(new LiteralText("rewards from the")), 105,59,79,74);
        root.add(new WLabel(new LiteralText("Adventurers' Guild")), 103,67,79,74);

        root.add(progress, 115,80,60,35);

        root.add(exp,2,32,62,24);
        root.add(com,2,68,62,24);
        root.add(dom,2,104,62,24);
        root.add(bos,2,140,62,24);
        root.add(X,555,32,26,20);  

        //button actions
        exp.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new HandbookExp()));
        });
        com.setOnClick(() -> {
            System.out.println("stop that");
        });
        dom.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new HandbookDom()));
        });
        bos.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new HandbookBos()));
        });
        X.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(null);
        });

        root.validate(this);
    };

    private static final int MAX_PROGRESS = 2;
    private int progress = 0;

    private final PropertyDelegate propertyDelegate = new PropertyDelegate() {
        @Override
        public int size() {
            // This is how many properties you have. We have two of them, so we'll return 2.
            return 2;
        }

        @Override
        public int get(int index) {
            // Each property has a unique index that you can choose.
            // Our properties will be 0 for the progress and 1 for the maximum.

            if (index == 0) {
                return progress;
            } else if (index == 1) {
                return MAX_PROGRESS;
            }

            // Unknown property IDs will fall back to -1
            return -1;
        }

        @Override
        public void set(int index, int value) {
            // This is used on the other side of the sync if you're using extended screen handlers.
            // Generally you'll want to have a working implementation for mutable properties, such as our progress.

            if (index == 0) {
                progress = value;
            }
        }
    };

    @Override
    public PropertyDelegate getPropertyDelegate() {
        return propertyDelegate;
    };

    @Environment(EnvType.CLIENT)
    @Override
    public void addPainters() {
        this.titleVisible = false;
    };
}	
    

