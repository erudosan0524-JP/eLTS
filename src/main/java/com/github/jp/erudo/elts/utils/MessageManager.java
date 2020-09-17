package com.github.jp.erudo.elts.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.github.jp.erudo.elts.Main;

public class MessageManager {

	private static Main plugin = Main.getInstance();

	public static void log(String message) {
		plugin.getLogger().info(message);
	}

	public static void send(Player player, String message) {
		player.sendMessage(message);
	}

	public static void sendAll(String message) {
		Bukkit.getOnlinePlayers().forEach(player -> player.sendMessage(message));
	}

	public static void broadcast(String message) {
		Bukkit.broadcastMessage(message);
	}

	public static void sendTitle() {

	}
}
