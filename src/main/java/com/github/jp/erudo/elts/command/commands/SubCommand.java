package com.github.jp.erudo.elts.command.commands;

import org.bukkit.entity.Player;

/**
 * @author hiroto-05241414
 *
 */
public abstract class SubCommand {

	/*
	 *  <command> <subcommand> args[0] args[1] ...
	 */

	public SubCommand() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	/**
	 * @param player コマンドが実行されたプレイヤー
	 * @param args コマンドのエイリアス
	 */
	public abstract void onCommand(Player player, String[] args);


	/**
	 * @return サブコマンドの名前
	 */
	public abstract String name();


	/**
	 * @return サブコマンドの詳細
	 */
	public abstract String info();


	/**
	 * @return args[]の部分
	 */
	public abstract String[] aliases();
}
