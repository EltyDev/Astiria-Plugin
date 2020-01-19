package fr.venodez.plugin;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Event implements Listener {

	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		if (item == null) return;
		
		if (inventory.getName().equalsIgnoreCase("§eShop")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.TNT) {
			
				Inventory gui = Bukkit.createInventory(null, 9, ChatColor.DARK_RED + "Pillage");
				ItemStack tnt = new ItemStack (Material.TNT, 16);
				ItemMeta mTnt = tnt.getItemMeta();
				mTnt.setDisplayName("§7§l16x Tnt");
				tnt.setItemMeta(mTnt);
				ItemStack bGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 11);
				ItemStack rGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 14);
				ItemStack creeper = new ItemStack (Material.MONSTER_EGG, 16,  (short) 50);
				ItemMeta mCreeper = creeper.getItemMeta();
				mCreeper.setDisplayName("§7§l16x Oeufs de Creeper");
				creeper.setItemMeta(mCreeper);
				ItemStack wither = new ItemStack (Material.SKULL_ITEM, 3,  (short) 1);
				ItemMeta mWither = wither.getItemMeta();
				mWither.setDisplayName("§7§l3x Tête de Wither skull");
				wither.setItemMeta(mWither);
				ItemStack soulsand = new ItemStack (Material.SOUL_SAND, 4);
				ItemMeta mSoulsand = soulsand.getItemMeta();
				mSoulsand.setDisplayName("§7§l4 Soulsands");
				soulsand.setItemMeta(mSoulsand);
				ItemStack enderpearl = new ItemStack (Material.ENDER_PEARL, 16);
				ItemMeta mEnderpearl = enderpearl.getItemMeta();
				mEnderpearl.setDisplayName("§7§l16 Enderpearls");
				enderpearl.setItemMeta(mEnderpearl);
				gui.setItem(0, bGlass);
				gui.setItem(1, rGlass);
				gui.setItem(2, tnt);
				gui.setItem(3, creeper);
				gui.setItem(4, wither);
				gui.setItem(5, soulsand);
				gui.setItem(6, enderpearl);
				gui.setItem(7, rGlass);
				gui.setItem(8, bGlass);
				player.openInventory(gui);
			}
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		List<String> list = CommandReset.getFrozen();
		Player player = event.getPlayer();
		if (!list.contains(player.getName()) && list.isEmpty()) {	
			
			player.getInventory().clear();
			player.updateInventory();
			list.add(player.getName());
			
		}
	}
}