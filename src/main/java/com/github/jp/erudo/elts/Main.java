package com.github.jp.erudo.elts;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.jp.erudo.elts.command.CommandManager;

public class Main extends JavaPlugin {

	private static Main instance;

	public CommandManager commandManager;

	private GameState state;
	private GameMode mode;

	@Override
	public void onDisable() {
		// TODO 自動生成されたメソッド・スタブ
		super.onDisable();
	}

	@Override
	public void onEnable() {
		setInstance(this);

		commandManager = new CommandManager();

		commandManager.setup();
	}

	public static Main getInstance() {
		return instance;
	}

	private static void setInstance(Main instance) {
		Main.instance = instance;
	}

	public GameState getState() {
		return state;
	}

	public void setState(GameState state) {
		this.state = state;
	}

	public GameMode getMode() {
		return mode;
	}

	public void setMode(GameMode mode) {
		this.mode = mode;
	}




}
