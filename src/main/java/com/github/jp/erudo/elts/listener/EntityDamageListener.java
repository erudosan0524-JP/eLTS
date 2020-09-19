package com.github.jp.erudo.elts.listener;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import com.github.jp.erudo.elts.GameState;
import com.github.jp.erudo.elts.Main;

public class EntityDamageListener implements Listener {

	private final Main instance = Main.getInstance();

	public EntityDamageListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onDamageByEntity(EntityDamageByEntityEvent e) {
		if(instance.getState() != GameState.GAMING) {
			return;
		}

		if(!((e.getDamager() instanceof Arrow) && (e.getEntity() instanceof Player))) {
			return;
		}

		Arrow arrow = (Arrow) e.getDamager();

		if(!(arrow.getShooter() instanceof Player)) {
			return;
		}

		Player player = (Player) e.getEntity();
		Player shooter = (Player) arrow.getShooter();

		//弓のシューターとダメージ受けたプレイヤーが一緒の時
		if(shooter == player) {
			Vector boost = player.getLocation().getDirection().normalize().multiply(2.5);

			player.setVelocity(boost);
		}



	}

}
