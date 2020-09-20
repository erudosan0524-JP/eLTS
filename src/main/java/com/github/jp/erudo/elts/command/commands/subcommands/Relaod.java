package com.github.jp.erudo.elts.command.commands.subcommands;

import org.bukkit.entity.Player;

import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import com.github.jp.erudo.elts.utils.MessageManager;

public class Relaod extends SubCommand {

	@Override
	public void onCommand(Player player, String[] args) {
		Main.getMyConfig().reload();
		Main.getTeamConfig().reload();

		MessageManager.send(player, "リロード完了");
	}

	@Override
	public String name() {
		return "reload";
	}

	@Override
	public String info() {
		return "reload config";
	}

	@Override
	public String[] aliases() {
		return new String[0];
	}

}
