package com.github.jp.erudo.elts.command.commands.subcommands;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import com.github.jp.erudo.elts.runnable.Counter;
import com.github.jp.erudo.elts.utils.MessageManager;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R2.PacketPlayOutTitle.EnumTitleAction;

public class Start extends SubCommand {

	private Main plugin = Main.getInstance();

	private BukkitTask task;

	@SuppressWarnings("deprecation")
	@Override
	public void onCommand(Player player, String[] args) {
		MessageManager.sendTitleAll(ChatColor.BOLD + "Last Team Standing", 40, 20, 40, EnumTitleAction.TITLE);
		MessageManager.sendTitleAll(ChatColor.GRAY + "最後まで生き残れ...", 40, 20, 40, EnumTitleAction.SUBTITLE);

		Counter counter = new Counter(Main.getMyConfig().getDefaultCount());
		task = plugin.getServer().getScheduler().runTaskTimer(plugin, counter, 0, 20L);
		counter.setTask(task);
	}

	@Override
	public String name() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String info() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public String[] aliases() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
