package com.github.jp.erudo.elts;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.jp.erudo.elts.command.CommandManager;
import com.github.jp.erudo.elts.config.Config;
import com.github.jp.erudo.elts.config.CustomConfig;
import com.github.jp.erudo.elts.config.TeamConfig;
import com.github.jp.erudo.elts.listener.ArrowListener;
import com.github.jp.erudo.elts.listener.DeathListener;
import com.github.jp.erudo.elts.listener.EntityDamageListener;
import com.github.jp.erudo.elts.listener.JoinLeaveListener;
import com.github.jp.erudo.elts.utils.BorderManager;

public class Main extends JavaPlugin {

	private static Main instance;
	private static Config config;
	private static TeamConfig teamConfig;

	private BorderManager border;

	public CommandManager commandManager;

	private GameState state;
	private GameMode mode;

	private CustomConfig Customconfig;
	private CustomConfig teamsConf;

	@Override
	public void onDisable() {
		// TODO 自動生成されたメソッド・スタブ
		super.onDisable();
	}

	@Override
	public void onEnable() {
		setInstance(this);

		//Command
		commandManager = new CommandManager();
		commandManager.setup();

		//Config
		Customconfig = new CustomConfig(this);
		teamsConf = new CustomConfig(this, "teams.yml");
		Customconfig.saveDefaultConfig();
		teamsConf.saveDefaultConfig();

		config = new Config(Customconfig);
		teamConfig = new TeamConfig(teamsConf);

		//Listener
		new JoinLeaveListener(this);
		new EntityDamageListener(this);
		new ArrowListener(this);
		new DeathListener(this);

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

	public static Config getMyConfig() {
		return config;
	}

	public static TeamConfig getTeamConfig() {
		return teamConfig;
	}

	public BorderManager getBorder() {
		return border;
	}

	public void setBorder(BorderManager border) {
		this.border = border;
	}


}
