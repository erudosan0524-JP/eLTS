package com.github.jp.erudo.elts.runnable;

import com.github.jp.erudo.elts.gameMod.SoloGame;
import com.github.jp.erudo.elts.utils.BorderManager;
import com.github.jp.erudo.elts.utils.GameState;
import org.bukkit.WorldBorder;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.jp.erudo.elts.Main;

import javax.swing.border.Border;

public class Game extends BukkitRunnable {

	private Main plugin = Main.getInstance();

	private int count;

	@Override
	public void run() {
		if(plugin.getState() != GameState.GAMING) {
			return;
		}

		if(plugin.getConfig().borderTime.contains(count)) {
			BorderManager border = plugin.getBorder();
			border.shrinkBorder(30,plugin.getConfig().getShrinkTime());
		}



		count++;
	}

}
