package com.github.jp.erudo.elts.command.commands.subcommands;

import org.bukkit.entity.Player;

import com.github.jp.erudo.elts.command.commands.SubCommand;

public class Help extends SubCommand {

	@Override
	public void onCommand(Player player, String[] args) {
		player.sendMessage("This help command is cool");
	}

	@Override
	public String name() {
		return "help";
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
