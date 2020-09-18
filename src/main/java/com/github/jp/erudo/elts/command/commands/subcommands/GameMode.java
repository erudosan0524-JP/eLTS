package com.github.jp.erudo.elts.command.commands.subcommands;

import org.bukkit.entity.Player;

import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import com.github.jp.erudo.elts.utils.MessageManager;


public class GameMode extends SubCommand {

	private final Main plugin = Main.getInstance();

	@Override
	public void onCommand(Player player, String[] args) {
		switch(args[0]) {
			case "solo":
				plugin.setMode(com.github.jp.erudo.elts.GameMode.SOLO);
				MessageManager.send(player, "ゲームモードを『ソロ』に設定しました");
				break;

			case "duo":
				plugin.setMode(com.github.jp.erudo.elts.GameMode.DUO);
				MessageManager.send(player, "ゲームモードを『デュオ』に設定しました");
				break;

			case "trio":
				plugin.setMode(com.github.jp.erudo.elts.GameMode.TRIO);
				MessageManager.send(player, "ゲームモードを『トリオ』に設定しました");
				break;

			default:
				plugin.setMode(com.github.jp.erudo.elts.GameMode.SOLO);
				MessageManager.send(player, "ゲームモードを『ソロ』に設定しました");
				break;
		}

	}

	@Override
	public String name() {
		return "gamemode";
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
