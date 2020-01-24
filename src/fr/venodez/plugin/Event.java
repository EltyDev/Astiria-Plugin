package fr.venodez.plugin;

import java.util.List;

import fr.venodez.plugin.Methods;

import org.bukkit.Bukkit;
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
	
	public ItemStack bGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 11);
	public ItemStack rGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 14);
	
	@EventHandler
	public void onClick(InventoryClickEvent event) {
		
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		if (item == null) return;
		
		if (inventory.getName().equalsIgnoreCase("§eShop")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.TNT && item.hasItemMeta() && item.getItemMeta().getDisplayName() == "§cPillage") {
			
				Inventory gui = Bukkit.createInventory(null, 9, "§cPillage");
				ItemStack tnt = new ItemStack (Material.TNT, 16);
				ItemMeta mTnt = tnt.getItemMeta();
				mTnt.setDisplayName("§7§l16x Tnt");
				tnt.setItemMeta(mTnt);
				ItemStack creeper = Methods.generateItem(Material.MONSTER_EGG, "§7§l16x Oeufs de Creeper", 16, (short) 50);
				ItemStack wither = Methods.generateItem(Material.SKULL_ITEM, "§7§l3x Tête de Wither skull", 3,  (short) 1);
				ItemStack soulsand = Methods.generateItem(Material.SOUL_SAND, "§7§l4 Soulsands", 4, (short) 0);
				ItemStack enderpearl = Methods.generateItem(Material.ENDER_PEARL, "§7§l16 Enderpearls", 16, (short) 0);
				ItemStack bGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 11);
				ItemStack rGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 14);
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
		
			else if (item.getType() == Material.SEEDS && item.hasItemMeta() && item.getItemMeta().getDisplayName() == "§bAgriculture") {
				
				Inventory gui = Bukkit.createInventory(null, 9, "§bAgriculture");
				ItemStack seed = Methods.generateItem(Material.SEEDS, "§7§l16x Graines", 16, (short) 0);
				ItemStack melonSeed = Methods.generateItem(Material.MELON_SEEDS, "§7§l16x Graines de melons", 16, (short) 0);
				ItemStack pumpkinSeed = Methods.generateItem(Material.PUMPKIN_SEEDS, "§7§l16x Graines de citrouilles", 16, (short) 0);
				ItemStack wheat = Methods.generateItem(Material.WHEAT, "§7§l16x Blés", 16, (short) 0);
				ItemStack melon = Methods.generateItem(Material.MELON, "§7§l16x Melons", 16, (short) 0);
				ItemStack pumpkin = Methods.generateItem(Material.PUMPKIN, "§7§l16x Citrouilles", 16, (short) 0);
				ItemStack carrot = Methods.generateItem(Material.CARROT_ITEM, "§7§l16x Carottes", 16, (short) 0);
				ItemStack potato = Methods.generateItem(Material.POTATO_ITEM, "§7§l16x Patates", 16, (short) 0);
				ItemStack cactus = Methods.generateItem(Material.CACTUS, "§7§l32x Cactus", 32, (short) 0);
				gui.setItem(0, seed);
				gui.setItem(1, melonSeed);
				gui.setItem(2, pumpkinSeed);
				gui.setItem(3, wheat);
				gui.setItem(4, melon);
				gui.setItem(5, pumpkin);
				gui.setItem(6, carrot);
				gui.setItem(7, potato);
				gui.setItem(8, cactus);
			}	
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		
		List<String> list = Main.getFrozen();
		Player player = event.getPlayer();
		System.out.println(list);
		if (!list.contains(player.getName())) {
			
			player.getInventory().clear();
			player.updateInventory();
			list.add(player.getName());
		}
	}
}