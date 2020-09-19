package com.github.jp.erudo.elts.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import com.github.jp.erudo.elts.command.commands.subcommands.GameMode;
import com.github.jp.erudo.elts.command.commands.subcommands.Help;
import com.github.jp.erudo.elts.command.commands.subcommands.Start;
import com.github.jp.erudo.elts.utils.MessageManager;

public class CommandManager implements CommandExecutor {

	private ArrayList<SubCommand> commands = new ArrayList<SubCommand>();
	private Main plugin = Main.getInstance();

	public CommandManager() {}

	//メインコマンド
	public String main = "lts";


	public void setup() {
		plugin.getCommand(main).setExecutor(this);

		this.commands.add(new Help());
		this.commands.add(new GameMode());
		this.commands.add(new Start());
	}


	public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

		if(!(sender instanceof Player)) {
			MessageManager.log("プレイヤーのみがこのコマンドを実行できます");
			return true;
		}

		Player player = (Player) sender;

		if(command.getName().equalsIgnoreCase(main)) {
			if(args.length == 0) {
				MessageManager.send(player, "/ltsでヘルプを表示できます");
				return true;
			}

			//<command> args[0] args[1] args[2]...

			SubCommand target = this.get(args[0]);

			if(Objects.isNull(target)) {
				MessageManager.send(player,ChatColor.RED + "不正なサブコマンド");
				return true;
			}

			ArrayList<String> arrayList = new ArrayList<String>();

			//<command> <subcommand> args[0] args[1]...

			arrayList.addAll(Arrays.asList(args));
			arrayList.remove(0); //index 0 はサブコマンド本体

			try {
				target.onCommand(player, args);
			} catch(Exception e) {
				MessageManager.send(player,ChatColor.RED + "エラーが検出されました");

				e.printStackTrace();
			}

		}

		return true;
	}


	private SubCommand get(String name) {
		Iterator<SubCommand> subcommands = this.commands.iterator();

		while(subcommands.hasNext()) {
			SubCommand sc = (SubCommand) subcommands.next();

			if(sc.name().equalsIgnoreCase(name)) {
				return sc;
			}

			String[] aliases;
			int var6 = (aliases = sc.aliases()).length;

			for(int var5 = 0; var5 < var6; var5++) {
				String alias = aliases[var5];
				if(name.equalsIgnoreCase(alias)) {
					return sc;
				}
			}
		}

		return null;
	}

}
