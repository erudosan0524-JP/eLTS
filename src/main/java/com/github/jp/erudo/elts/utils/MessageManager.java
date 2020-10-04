package com.github.jp.erudo.elts.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R2.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.github.jp.erudo.elts.Main;

import net.minecraft.server.v1_16_R2.IChatBaseComponent.ChatSerializer;
import net.minecraft.server.v1_16_R2.PacketPlayOutTitle;
import net.minecraft.server.v1_16_R2.PacketPlayOutTitle.EnumTitleAction;

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

	public static void sendTitle(Player player, String message, int fadein, int showtime, int fadeout, EnumTitleAction type) {
		PacketPlayOutTitle title = new PacketPlayOutTitle(type,
				ChatSerializer.a("{\"text\":\"" + message + "\"}"), fadein, showtime, fadeout);

		((CraftPlayer) player).getHandle().playerConnection.sendPacket(title);
	}

	public static void sendTitleAll(String message, int fadein, int showtime, int fadeout, EnumTitleAction type) {
		PacketPlayOutTitle title = new PacketPlayOutTitle(type,
				ChatSerializer.a("{\"text\":\"" + message + "\"}"), fadein, showtime, fadeout);

		Bukkit.getServer().getOnlinePlayers().forEach(player -> ((CraftPlayer) player).getHandle().playerConnection.sendPacket(title));
	}

	public static String getCoordinate(Location loc) {
		String[] coordinates = {Double.toString(loc.getX()), Double.toString(loc.getY()), Double.toString(loc.getZ())};

		String result = String.join(",",coordinates);

		return result;
	}
}
