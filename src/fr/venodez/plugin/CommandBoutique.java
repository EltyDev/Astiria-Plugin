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

public class CommandBoutique implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("boutique")) {
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				Inventory gui = Bukkit.createInventory(null, 27, "§bBoutique");
				ItemStack oGlass = Methods.generateItem(Material.STAINED_GLASS_PANE, null, null, 1, (short) 1);
				ItemStack yGlass = Methods.generateItem(Material.STAINED_GLASS_PANE, null, null, 1, (short) 4);
				ItemStack gold = Methods.generateItem(Material.GOLD_BLOCK, "§eGrades", null, 1, (short) 0);
				gui.setItem(0, oGlass);
				gui.setItem(1, yGlass);
				gui.setItem(2, oGlass);
				gui.setItem(3, yGlass);
				gui.setItem(4, oGlass);
				gui.setItem(5, yGlass);
				gui.setItem(6, oGlass);
				gui.setItem(7, yGlass);
				gui.setItem(8, oGlass);
				gui.setItem(9, yGlass);
				gui.setItem(10, oGlass);
				gui.setItem(11, yGlass);
				gui.setItem(12, oGlass);
				gui.setItem(13, gold);
				gui.setItem(14, oGlass);
				gui.setItem(15, yGlass);
				gui.setItem(16, oGlass);
				gui.setItem(17, yGlass);
				gui.setItem(18, oGlass);
				gui.setItem(19, yGlass);
				gui.setItem(20, oGlass);
				gui.setItem(21, yGlass);
				gui.setItem(22, oGlass);
				gui.setItem(23, yGlass);
				gui.setItem(24, oGlass);
				gui.setItem(25, yGlass);
				gui.setItem(26, oGlass);
				player.openInventory(gui);
				
			}
		
		}
		
		return false;
	
	}

}
