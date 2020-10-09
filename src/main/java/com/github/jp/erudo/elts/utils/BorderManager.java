package com.github.jp.erudo.elts.utils;

import org.bukkit.World;
import org.bukkit.WorldBorder;

public class BorderManager {

	private WorldBorder border;

	public BorderManager(World world) {
		this.border = world.getWorldBorder();
	}

	public void shrinkBorder(int amount, long time) {
		border.setSize(border.getSize() - amount,time);
	}

	public WorldBorder getBorder() {
		return border;
	}
}
