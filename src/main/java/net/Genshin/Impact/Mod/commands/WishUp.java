package net.Genshin.Impact.Mod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.Genshin.Impact.Mod.mixin.PlayerEntityMixin;

final class WishUp implements Command<Object>{

    @Override
    public int run(CommandContext<Object> context) throws CommandSyntaxException {
        PlayerEntityMixin.NewWish(1);
        return 1;
    }
    
}
