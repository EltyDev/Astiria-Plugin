package fr.venodez.plugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Methods {
	
	public static ItemStack generateItem(Material objet, String nom, int nombre , short metadata) {
		
		ItemStack item = new ItemStack(objet,nombre,metadata);
		ItemMeta mItem = item.getItemMeta();
		mItem.setDisplayName(nom);
		item.setItemMeta(mItem);
		return item;
	}

}
