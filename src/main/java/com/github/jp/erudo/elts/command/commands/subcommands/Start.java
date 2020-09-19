package com.github.jp.erudo.elts.command.commands.subcommands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

import com.github.jp.erudo.elts.GameState;
import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.command.commands.SubCommand;
import com.github.jp.erudo.elts.runnable.Counter;
import com.github.jp.erudo.elts.utils.ItemMaker;
import com.github.jp.erudo.elts.utils.MessageManager;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R2.PacketPlayOutTitle.EnumTitleAction;

public class Start extends SubCommand {

	private Main plugin = Main.getInstance();

	private BukkitTask task;

	@SuppressWarnings("deprecation")
	@Override
	public void onCommand(Player player, String[] args) {
		List<String> descs = new ArrayList<String>();
		descs.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "最後まで生き残れ...");

		List<Enchantment> enchant = new ArrayList<Enchantment>();
		enchant.add(Enchantment.ARROW_INFINITE);
		enchant.add(Enchantment.ARROW_DAMAGE);


		for(Player p : Bukkit.getServer().getOnlinePlayers()) {
			p.setMaxHealth(1);
			ItemStack bow = ItemMaker.makeBow("生殺与奪の権", descs, enchant);
			p.getInventory().addItem(bow);
			p.getInventory().addItem(new ItemStack(Material.ARROW));
		}


		MessageManager.sendTitleAll(ChatColor.BOLD + "Last Team Standing", 20, 40, 20, EnumTitleAction.TITLE);
		MessageManager.sendTitleAll(ChatColor.GRAY + "最後まで生き残れ...", 20, 40, 20, EnumTitleAction.SUBTITLE);

		MessageManager.log(String.valueOf(Main.getMyConfig().getDefaultCount()));
		plugin.setState(GameState.COUNTING);
		Counter counter = new Counter(Main.getMyConfig().getDefaultCount());
		task = counter.runTaskTimer(plugin, 0, 20L);
		counter.setTask(task);
	}

	@Override
	public String name() {
		return "start";
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
