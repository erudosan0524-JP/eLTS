package com.github.jp.erudo.elts.listener;

import java.util.Objects;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.scheduler.BukkitTask;

import com.github.jp.erudo.elts.GameState;
import com.github.jp.erudo.elts.Main;
import com.github.jp.erudo.elts.runnable.Interval;

public class ArrowListener implements Listener {

	private final Main plugin = Main.getInstance();
	private BukkitTask task;

	public ArrowListener(Main plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onShoot(EntityShootBowEvent e) {
		if(!(e.getEntity() instanceof Player)) {
			return;
		}

		Player player = (Player) e.getEntity();
		int interval = plugin.getConfig().getDefaultInterval();

		//プレイヤーのEXPを0に
		player.setExp(0);

		//Interval Runnableの起動
		Interval intervalRun = new Interval(interval,player);
		task = intervalRun.runTaskTimer(plugin, 0, 20L);
		intervalRun.setTask(task);
	}

	@EventHandler
	public void onProjectileHit(ProjectileHitEvent e) {
		if(plugin.getState() != GameState.GAMING) {
			return;
		}

		if(!(e.getEntity() instanceof Arrow)) {
			return;
		}

		if(Objects.isNull(e.getHitBlock())) {
			return;
		}

		Arrow arrow = (Arrow) e.getEntity();
		Block block = e.getHitBlock();
		Location loc = block.getLocation();

		arrow.remove();
		loc.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, loc, 1);
	}

}
