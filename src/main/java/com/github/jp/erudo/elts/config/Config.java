package com.github.jp.erudo.elts.config;

public class Config {


	private CustomConfig config;

	private String defaultGameMode;
	private int defaultInterval;
	private int defaultCount;

	public Config(CustomConfig config) {
		this.config = config;

		load();
	}

	private void load() {
		if(config != null) {
			config.reloadConfig();
		}

		defaultGameMode = config.getConfig().getString("defaultGameMode");
		defaultInterval = config.getConfig().getInt("defaultInterval");
		defaultCount = config.getConfig().getInt("defaultCount");

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

	public int getDefaultCount() {
		return defaultCount;
	}

	public void setDefaultCount(int defaultCount) {
		this.defaultCount = defaultCount;
	}

	public void reload() {
		config.reloadConfig();
	}

}
