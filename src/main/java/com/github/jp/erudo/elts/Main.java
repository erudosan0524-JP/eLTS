package com.github.jp.erudo.elts;

import com.github.jp.erudo.elts.utils.GameMode;
import com.github.jp.erudo.elts.utils.GameState;
import com.github.jp.erudo.elts.utils.sql.DBManager;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.jp.erudo.elts.command.CommandManager;
import com.github.jp.erudo.elts.utils.Config;
import com.github.jp.erudo.elts.listener.ArrowListener;
import com.github.jp.erudo.elts.listener.DeathListener;
import com.github.jp.erudo.elts.listener.EntityDamageListener;
import com.github.jp.erudo.elts.listener.JoinLeaveListener;
import com.github.jp.erudo.elts.utils.BorderManager;

public class Main extends JavaPlugin {

	//TODO チーム管理をDBで

	@Getter
	@Setter
	private static Main instance;

	@Getter
	@Setter
	private BorderManager border;

	public CommandManager commandManager;

	@Getter
	@Setter
	private GameState state;
	@Getter
	@Setter
	private GameMode mode;

	@Getter
	private Config config;

	@Getter
	private DBManager dbManager;

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
		config = new Config(this);

		//Listener
		new JoinLeaveListener(this);
		new EntityDamageListener(this);
		new ArrowListener(this);
		new DeathListener(this);

		//Database
		if(config.isSQLEnabled()) {
			dbManager = new DBManager(config.getHost(),config.getDatabase(),config.getUsername(), config.getPassword(), config.getPort());
		}

	}


}
