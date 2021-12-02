package net.Genshin.Impact.Mod.client.gui;

import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.WPlainPanel;
import io.github.cottonmc.cotton.gui.widget.WSprite;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.util.Identifier;


public class HandbookExp extends LightweightGuiDescription {

    public HandbookExp() { 
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


        root.add(new WLabel(new LiteralText("WIP")), 70,23,30,35);

        root.add(exp,2,32,62,24);
        root.add(com,2,68,62,24);
        root.add(dom,2,104,62,24);
        root.add(bos,2,140,62,24);
        root.add(X,555,32,26,20);  

 
        exp.setOnClick(() -> {
            System.out.println("stop that");
        });
        com.setOnClick(() -> {
            MinecraftClient.getInstance().setScreen(new CottonClientScreen(new HandbookCom()));
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


    @Environment(EnvType.CLIENT)
    @Override
    public void addPainters() {
        this.titleVisible = false;
    };
}	
    

