package com.github.jp.erudo.elts.command.commands.subcommands;

import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import com.github.jp.erudo.elts.utils.MathUtils;
import com.github.jp.erudo.elts.utils.MessageManager;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;

public class SetBorder extends SubCommand {

    private Main plugin = Main.getInstance();

    @Override
    public void onCommand(Player player, String[] args) {
        if (args.length != 0) {
            //setborder center
            if (args[0].equalsIgnoreCase("center")) {
                WorldBorder border = plugin.getBorder().getBorder();
                border.setCenter(player.getLocation());
                player.sendMessage("ボーダーの中心を" + MathUtils.getCoordinatetoString(player.getLocation()) + "に設定しました");
            }
        } else {
            WorldBorder border = plugin.getBorder().getBorder();
            border.setSize(plugin.getConfig().getBorderSize());
            border.setDamageAmount(plugin.getConfig().getBorderDamage());
        }
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }
}
