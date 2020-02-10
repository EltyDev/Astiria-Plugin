package fr.venodez.plugin;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class CommandMod implements CommandExecutor {
	
	public boolean inMod;
	public HashMap<Player, ItemStack[]> saveInv = new HashMap<Player, ItemStack[]>();
	public HashMap<Player, ItemStack[]> saveArmor = new HashMap<Player, ItemStack[]>();
	public HashMap<Player, GameMode> saveGamemode = new HashMap<Player, GameMode>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("mod")) {
			
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				
				if (inMod) {
					
					inMod = false;
					ItemStack[] inv = saveInv.get(player);
					ItemStack[] armor = saveArmor.get(player);
					GameMode gm = saveGamemode.get(player);
					saveInv.remove(player);
					saveArmor.remove(player);
					saveGamemode.remove(player);
					int n = 0;
					for (ItemStack item : inv) {
						
						player.getInventory().setItem(n, item);
						n += 1;
						
					}
					
					player.getInventory().setArmorContents(armor);
					player.setGameMode(gm);
					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						
						all.showPlayer(player);
						
					}
				
				}
				
				else {
					
					ItemStack[] vide = null;
					inMod = true;
					PlayerInventory inv = player.getInventory();
					ItemStack[] cInv = inv.getContents();
					ItemStack[] armor = inv.getArmorContents();
					saveInv.put(player, cInv);
					saveArmor.put(player, armor);
					saveGamemode.put(player, player.getGameMode());
					inv.clear();
					inv.setArmorContents(vide);
					player.setGameMode(GameMode.CREATIVE);
					for (Player all : Bukkit.getServer().getOnlinePlayers()) {
						
						all.hidePlayer(player);
						
					}
					
					ItemStack freeze = Methods.generateItem(Material.PACKED_ICE, "§bFreeze", null, 1, (short) 0);
					inv.addItem(freeze);
					ItemStack vanishOff = Methods.generateItem(Material.INK_SACK, "§7Vanish off", null, 1, (short) 8);
					inv.addItem(vanishOff);
					ItemStack kill = Methods.generateItem(Material.GOLD_HOE, "§eKiller", null, 1, (short) 0);
					inv.addItem(kill);
					ItemStack kb = Methods.generateItem(Material.STICK, "§2Test de recul", null, 1, (short) 0);
					ItemMeta mKb = kb.getItemMeta();
					mKb.addEnchant(Enchantment.KNOCKBACK, 10, true);
					mKb.addItemFlags(ItemFlag.HIDE_ENCHANTS);
					kb.setItemMeta(mKb);
					inv.addItem(kb);
					ItemStack rtp = Methods.generateItem(Material.EYE_OF_ENDER, "§6Téléportation aléatoire", null, 1, (short) 0);
					inv.addItem(rtp);
					player.updateInventory();
					
				}
			
			}
		
		}
		
		return false;
	
	}

}
