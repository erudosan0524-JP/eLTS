package com.github.jp.erudo.elts.listener;

import java.util.Objects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.github.jp.erudo.elts.GameState;
import com.github.jp.erudo.elts.Main;

public class ArrowListener implements Listener {

	private final Main instance = Main.getInstance();

	public ArrowListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		if(instance.getState() != GameState.GAMING) {
			return;
		}

		if(!(e.getEntity() instanceof Arrow)) {
			return;
		}

		if(Objects.isNull(e.getHitBlock())) {
			return;
		}

		Block block = e.getHitBlock();
		Location loc = block.getLocation();

		loc.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc, 1);
	}

}
