package com.github.jp.erudo.elts.runnable;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.github.jp.erudo.elts.Main;

public class BowInterval extends BukkitRunnable{

	private Main plugin = Main.getInstance();

	private int interval;
	private float n;
	private float exp;
	private Player player;

	private final int total;

	public BowInterval(int interval, Player player) {
		this.interval = interval;
		this.player = player;
		this.total = interval;
		this.exp = 0;
		this.n = 0;
	}

	//1s1回
	@Override
	public void run() {
		if(interval <= 0) {
			player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
			interval = 0;
			this.cancel();
		}
		//interval秒たつまでにexpの値を0から1に変化させたい
		exp = n / total;
		player.setExp(exp);
		interval--;
		n++;
	}
}
