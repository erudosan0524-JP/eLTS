package com.github.jp.erudo.elts.command.commands.subcommands;

import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import org.bukkit.entity.Player;

public class Set extends SubCommand {

    private Main plugin = Main.getInstance();

    @Override
    public void onCommand(Player player, String[] args) {


    }

    @Override
    public String name() {
        return "set";
    }

    @Override
    public String info() {
        return "";
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
