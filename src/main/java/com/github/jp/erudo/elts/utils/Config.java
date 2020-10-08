package com.github.jp.erudo.elts.utils;

import com.github.jp.erudo.elts.GameMode;
import com.github.jp.erudo.elts.Main;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.Objects;

public class Config {

	private final Plugin plugin;
	private FileConfiguration config = null;

	private String defaultGameMode;
	@Getter
	private int defaultInterval;
	@Getter
	private int defaultCount;

	@Getter
	private String host,database,username,password, teams_table, members_table;
	@Getter
	private int port;

	public Config(Plugin plugin) {
		this.plugin = plugin;

		load();
	}

	private void load() {
		plugin.saveDefaultConfig();

		if (Objects.nonNull(config)) {
			plugin.reloadConfig();
		}

		config = plugin.getConfig();

		defaultGameMode = config.getString("defaultGameMode");
		defaultInterval = config.getInt("defaultInterval");
		defaultCount = config.getInt("defaultCount");
		host = config.getString("host");
		database = config.getString("database");
		username = config.getString("username");
		password = config.getString("password");
		port = config.getInt("port");
		teams_table = config.getString("teams_table");
		members_table = config.getString("members_table");

	}

	public void reload() {
		plugin.reloadConfig();
		plugin.saveConfig();
	}

	public GameMode getDefaultGameMode() {
		switch (defaultGameMode.toLowerCase()) {
			case "solo":
				return GameMode.SOLO;
			case "duo":
				return GameMode.DUO;
			case "trio":
				return GameMode.TRIO;
			default:
				return null;
		}
	}



}
