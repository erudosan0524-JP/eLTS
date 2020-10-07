package com.github.jp.erudo.elts.config;

import com.github.jp.erudo.elts.GameMode;
import com.github.jp.erudo.elts.Main;
import lombok.Getter;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Objects;

public class Config {

	private final Main plugin;
	private FileConfiguration config = null;

	public String defaultGameMode;

	@Getter
	public int defaultInterval;
	@Getter
	public int defaultCount;


	public Config(Main plugin) {
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
