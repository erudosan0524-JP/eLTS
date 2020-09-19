package com.github.jp.erudo.elts.utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMaker {

	public static ItemStack makeItem(Material m, int amount, String name, List<String> descs) {
		ItemStack item = new ItemStack(m,amount);

		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(name);

		List<String> lore = new ArrayList<String>();
		for(String desc : descs) {
			lore.add(desc);
		}

		meta.setLore(lore);
		meta.setUnbreakable(true);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);

		item.setItemMeta(meta);

		return item;
	}

	public static ItemStack makeBow(String name, List<String> descs, List<Enchantment> enchants) {
		ItemStack bow = makeItem(Material.BOW, 1, name, descs);

		for(Enchantment enchant : enchants) {
			bow.addEnchantment(enchant, 1);
		}

		return bow;

	}

}
