package com.github.jp.erudo.elts.runnable;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import com.github.jp.erudo.elts.GameState;
import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.utils.MessageManager;

import net.minecraft.server.v1_16_R2.PacketPlayOutTitle.EnumTitleAction;

public class Counter extends BukkitRunnable {

	private Main plugin = Main.getInstance();

	private BukkitTask task;
	private int count;

	public Counter(int count) {
		this.count = count;
	}

	@Override
	public void run() {
		if(plugin.getState() != GameState.COUNTING) {
			return;
		}

		if(count <= 0) {
			plugin.setState(GameState.GAMING);
			count = 0;
			plugin.getServer().getScheduler().cancelTask(task.getTaskId());
		}

		if(count > 0 && count <= 5) {
			Bukkit.getServer().getOnlinePlayers().forEach(player -> player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_HIT, 0.5F, 1));
		}


		MessageManager.sendTitleAll(String.valueOf(count), 20, 20, 20, EnumTitleAction.TITLE);
		count--;

	}

	public void setTask(BukkitTask task) {
		this.task = task;
	}

}
