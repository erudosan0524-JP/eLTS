package com.github.jp.erudo.elts.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.jp.erudo.elts.Main;

public class JoinLeaveListener implements Listener {

	public JoinLeaveListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}


	@EventHandler
	public void onJoin(PlayerJoinEvent e) {

	}
}
