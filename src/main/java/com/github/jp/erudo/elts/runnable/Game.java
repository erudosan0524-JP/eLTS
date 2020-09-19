package com.github.jp.erudo.elts.runnable;

import org.bukkit.scheduler.BukkitRunnable;

import com.github.jp.erudo.elts.GameState;
import com.github.jp.erudo.elts.Main;

public class Game extends BukkitRunnable {

	private Main plugin = Main.getInstance();

	//TODO: がんばる
	@Override
	public void run() {
		if(plugin.getState() != GameState.GAMING) {
			return;
		}




	}

}
