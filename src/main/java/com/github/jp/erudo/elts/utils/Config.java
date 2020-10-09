package com.github.jp.erudo.elts.utils;

import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;
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
	private int borderSize, borderDamage;

	@Getter
	private boolean isSQLEnabled;
	@Getter
	private String host,database,username,password, teams_table, members_table;
	@Getter
	private int port;

	@Getter
	private List<Integer> phaseIntervals = new ArrayList<>();
	@Getter
	private int shrinkTime;

	public List<Integer> borderTime = new ArrayList<>();

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
		borderSize = config.getInt("border-size");
		borderDamage = config.getInt("border-damage");
		host = config.getString("host");
		database = config.getString("database");
		username = config.getString("username");
		password = config.getString("password");
		port = config.getInt("port");
		teams_table = config.getString("teams_table");
		members_table = config.getString("members_table");
		isSQLEnabled = config.getBoolean("enabled-sql");
		phaseIntervals = config.getIntegerList("phase-intervals");
		shrinkTime = config.getInt("shrink-time");


		for(int i=0; i < phaseIntervals.size(); i++) {
			borderTime.add(phaseIntervals.get(i-1) + phaseIntervals.get(i));
		}


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
