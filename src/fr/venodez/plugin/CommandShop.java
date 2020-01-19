package fr.venodez.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandShop implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("shop") && sender instanceof Player) {
			
			Player player = (Player) sender;
			Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
			ItemStack bGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 11);
			ItemStack rGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 14);
			ItemStack pillage = new ItemStack (Material.TNT);
			ItemMeta mPillage  = pillage.getItemMeta();
			mPillage.setDisplayName("§cPillage");
			pillage.setItemMeta(mPillage);
			ItemStack agriculture = new ItemStack (Material.SEEDS);
			ItemMeta mAgriculture  = agriculture.getItemMeta();
			mAgriculture.setDisplayName("§bAgriculture");
			agriculture.setItemMeta(mAgriculture);
			ItemStack alchimie = new ItemStack (Material.POTION, 1, (short) 8229);
			ItemMeta mAlchimie  = alchimie.getItemMeta();
			mAlchimie.setDisplayName("§5Alchimie");
			alchimie.setItemMeta(mAlchimie);
			ItemStack minerai = new ItemStack (Material.IRON_ORE);
			ItemMeta mMinerai  = minerai.getItemMeta();
			mMinerai.setDisplayName("§8Minerai");
			minerai.setItemMeta(mMinerai);
			ItemStack spawner = new ItemStack (Material.MOB_SPAWNER);
			ItemMeta mSpawner  = spawner.getItemMeta();
			mSpawner.setDisplayName("§eSpawner");
			spawner.setItemMeta(mSpawner);
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
