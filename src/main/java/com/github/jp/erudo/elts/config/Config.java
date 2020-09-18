package com.github.jp.erudo.elts.config;

import com.github.jp.erudo.elts.Main;

public class Config {

	private Main plugin;
	private CustomConfig config;

	private String defaultGameMode;
	private int defaultInterval;

	public Config(Main plugin, CustomConfig config) {
		this.plugin = plugin;
		this.config = config;

		load();
	}

	private void load() {
		if(config != null) {
			config.reloadConfig();
		}

		defaultGameMode = config.getConfig().getString("defaultGameMode");
		defaultInterval = config.getConfig().getInt("defaultInterval");

	}

	public String getDefaultGameMode() {
		return defaultGameMode;
	}

	public void setDefaultGameMode(String defaultGameMode) {
		this.defaultGameMode = defaultGameMode;
	}

	public int getDefaultInterval() {
		return defaultInterval;
	}

	public void setDefaultInterval(int defaultInterval) {
		this.defaultInterval = defaultInterval;
	}



}
