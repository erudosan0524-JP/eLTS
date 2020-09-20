package com.github.jp.erudo.elts.runnable;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.github.jp.erudo.elts.Main;

public class Interval extends BukkitRunnable{

	private Main plugin = Main.getInstance();

	private BukkitTask task;
	private int interval;
	private int exp;
	private Player player;

	public Interval(int interval, Player player) {
		this.interval = interval;
		this.player = player;
		this.exp = 0;
	}

	@Override
	public void run() {
		if(interval <= 0) {
			player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			interval = 0;
			plugin.getServer().getScheduler().cancelTask(task.getTaskId());
		}

		interval--;
		exp++;
		player.setExp(exp);
	}

	public void setTask(BukkitTask task) {
		this.task = task;
	}

}
