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

	private final Main instance = Main.getInstance();
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
		int interval = Main.getMyConfig().getDefaultInterval();

		//プレイヤーのEXPを0に
		player.setExp(0);
		player.setTotalExperience(interval);

		//Interval Runnableの起動
		Interval intervalRun = new Interval(interval,player);
		task = intervalRun.runTaskTimer(instance, 0, 20L);
		intervalRun.setTask(task);
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
