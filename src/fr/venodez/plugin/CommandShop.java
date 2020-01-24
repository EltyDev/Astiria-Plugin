package fr.venodez.plugin;

import fr.venodez.plugin.Methods;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class CommandShop implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("shop") && sender instanceof Player) {
			
			Player player = (Player) sender;
			Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
			ItemStack bGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 11);
			ItemStack rGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemStack pillage = Methods.generateItem(Material.TNT,"§cPillage",1, (short) 0);
			ItemStack agriculture = Methods.generateItem(Material.SEEDS,"§bAgriculture",1 ,(short) 0);
			ItemStack alchimie = Methods.generateItem(Material.POTION, "§5Alchimie", 1, (short) 8229);
			ItemStack minerai = Methods.generateItem(Material.IRON_ORE, "§8Minerai", 1, (short) 0);
			ItemStack spawner = Methods.generateItem(Material.MOB_SPAWNER, "§eSpawner", 1, (short) 0);
			gui.setItem(0, bGlass);
			gui.setItem(1, rGlass);
			gui.setItem(2, bGlass);
			gui.setItem(3, rGlass);
			gui.setItem(4, bGlass);
			gui.setItem(5, rGlass);
			gui.setItem(6, bGlass);
			gui.setItem(7, rGlass);
			gui.setItem(8, bGlass);
			gui.setItem(9, pillage);
			gui.setItem(10, bGlass);
			gui.setItem(11, agriculture);
			gui.setItem(12, bGlass);
			gui.setItem(13, alchimie);
			gui.setItem(14, bGlass);
			gui.setItem(15, minerai);
			gui.setItem(16, bGlass);
			gui.setItem(17, spawner);
			gui.setItem(18, bGlass);
			gui.setItem(19, rGlass);
			gui.setItem(20, bGlass);
			gui.setItem(21, rGlass);
			gui.setItem(22, bGlass);
			gui.setItem(23, rGlass);
			gui.setItem(24, bGlass);
			gui.setItem(25, rGlass);
			gui.setItem(26, bGlass);
			player.openInventory(gui);
			
		}
		
		return false;
	}

}
