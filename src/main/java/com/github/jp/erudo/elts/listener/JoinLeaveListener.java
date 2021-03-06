package com.github.jp.erudo.elts.listener;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.jp.erudo.elts.Main;

public class JoinLeaveListener implements Listener {

	public JoinLeaveListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}


	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();

		e.setJoinMessage(ChatColor.BOLD + player.getName() + "がログインしました");
	}

	@EventHandler
	public void onLeave(PlayerQuitEvent e) {
		Player player = e.getPlayer();

		e.setQuitMessage(ChatColor.BOLD + player.getName() + "がログアウトしました");
	}
}
