package fr.venodez.plugin;

import java.util.ArrayList;
import java.util.List;

import fr.venodez.plugin.Methods;
import ru.tehkode.permissions.PermissionManager;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent.Result;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

public class Event implements Listener {
	
	public PermissionManager pexapi = PermissionsEx.getPermissionManager();
	public ItemStack bGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 11);
	public ItemStack rGlass = new ItemStack (Material.STAINED_GLASS_PANE, 1, (short) 14);
	public ItemStack oGlass = Methods.generateItem(Material.STAINED_GLASS_PANE, null, null, 1, (short) 1);
	public ItemStack yGlass = Methods.generateItem(Material.STAINED_GLASS_PANE, null, null, 1, (short) 4);
	public ItemStack back = Methods.generateItem(Material.BED, "§4Sortir", null, 1, (short) 0);
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onClick(InventoryClickEvent event) throws NoLoanPermittedException, IllegalArgumentException, UserDoesNotExistException {
		
		Player player = (Player) event.getWhoClicked();
		Inventory inventory = event.getInventory();
		ItemStack item = event.getCurrentItem();
		ClickType click = event.getClick();
		if (item == null) return;
		
		if (inventory.getName().equalsIgnoreCase("§eShop")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.TNT) {
			
				Inventory gui = Bukkit.createInventory(null, 27, "§cPillage");
				List<String> description = new ArrayList<>();
				description.add("§4Achat : §a7500$");
				description.add("§3Vente : §a2500$");
				description.add("§4Clique gauche §fpour acheter");
				description.add("§3Clique droit §fpour vendre");
				ItemStack tnt = Methods.generateItem(Material.TNT, "§7§l16x Tnt", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a125000$");
				description.add(1, "§3Vente : §4§lImpossible");
				ItemStack creeper = Methods.generateItem(Material.MONSTER_EGG, "§7§l8x Oeufs de Creeper", description, 8, (short) 50);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a200000$");
				description.add(1, "§3Vente : §a65000$");
				ItemStack wither = Methods.generateItem(Material.SKULL_ITEM, "§7§l3x Tête de Wither skull", description, 3,  (short) 1);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a200$");
				description.add(1, "§3Vente : §a65$");
				ItemStack soulsand = Methods.generateItem(Material.SOUL_SAND, "§7§l4 Soulsands", description, 4, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a10000$");
				description.add(1, "§3Vente : §a3500$");
				ItemStack enderpearl = Methods.generateItem(Material.ENDER_PEARL, "§7§l16 Enderpearls", description, 16, (short) 0);
				gui.setItem(0, bGlass);
				gui.setItem(1, rGlass);
				gui.setItem(2, bGlass);
				gui.setItem(3, rGlass);
				gui.setItem(4, bGlass);
				gui.setItem(5, rGlass);
				gui.setItem(6, bGlass);
				gui.setItem(7, rGlass);
				gui.setItem(8, bGlass);
				gui.setItem(9, tnt);
				gui.setItem(10, bGlass);
				gui.setItem(11, creeper);
				gui.setItem(12, bGlass);
				gui.setItem(13, wither);
				gui.setItem(14, bGlass);
				gui.setItem(15, soulsand);
				gui.setItem(16, bGlass);
				gui.setItem(17, enderpearl);
				gui.setItem(18, bGlass);
				gui.setItem(19, rGlass);
				gui.setItem(20, bGlass);
				gui.setItem(21, rGlass);
				gui.setItem(22, bGlass);
				gui.setItem(23, rGlass);
				gui.setItem(24, bGlass);
				gui.setItem(25, rGlass);
				gui.setItem(26, back);
				player.openInventory(gui);
			}
		
			else if (item.getType() == Material.SEEDS) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§bAgriculture");
				List<String> description = new ArrayList<>();
				description.add("§4Achat : §a150$");
				description.add("§3Vente : §a50$");
				description.add("§4Clique gauche §fpour acheter");
				description.add("§3Clique droit §fpour vendre");
				ItemStack seed = Methods.generateItem(Material.SEEDS, "§7§l16x Graines", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a500$");
				description.add(1, "§3Vente : §a150$");
				ItemStack melonSeed = Methods.generateItem(Material.MELON_SEEDS, "§7§l16x Graines de melons", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a500$");
				description.add(1, "§3Vente : §a150$");
				ItemStack pumpkinSeed = Methods.generateItem(Material.PUMPKIN_SEEDS, "§7§l16x Graines de citrouilles", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a1500$");
				description.add(1, "§3Vente : §a500$");
				ItemStack wheat = Methods.generateItem(Material.WHEAT, "§7§l16x Blés", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a5000$");
				description.add(1, "§3Vente : §a1500$");
				ItemStack melon = Methods.generateItem(Material.MELON, "§7§l16x Melons", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a5000$");
				description.add(1, "§3Vente : §a1500$");
				ItemStack pumpkin = Methods.generateItem(Material.PUMPKIN, "§7§l16x Citrouilles", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a1000$");
				description.add(1, "§3Vente : §a300$");
				ItemStack carrot = Methods.generateItem(Material.CARROT_ITEM, "§7§l16x Carottes", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a1250$");
				description.add(1, "§3Vente : §a400$");
				ItemStack potato = Methods.generateItem(Material.POTATO_ITEM, "§7§l16x Patates", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a2000$");
				description.add(1, "§3Vente : §a650$");
				ItemStack cactus = Methods.generateItem(Material.CACTUS, "§7§l32x Cactus", description, 32, (short) 0);
				gui.setItem(0, bGlass);
				gui.setItem(1, rGlass);
				gui.setItem(2, seed);
				gui.setItem(3, rGlass);
				gui.setItem(4, melonSeed);
				gui.setItem(5, rGlass);
				gui.setItem(6, pumpkinSeed);
				gui.setItem(7, rGlass);
				gui.setItem(8, bGlass);
				gui.setItem(9, rGlass);
				gui.setItem(10, bGlass);
				gui.setItem(11, wheat);
				gui.setItem(12, bGlass);
				gui.setItem(13, melon);
				gui.setItem(14, bGlass);
				gui.setItem(15, pumpkin);
				gui.setItem(16, bGlass);
				gui.setItem(17, rGlass);
				gui.setItem(18, bGlass);
				gui.setItem(19, rGlass);
				gui.setItem(20, carrot);
				gui.setItem(21, rGlass);
				gui.setItem(22, potato);
				gui.setItem(23, rGlass);
				gui.setItem(24, cactus);
				gui.setItem(25, rGlass);
				gui.setItem(26, back);
				player.openInventory(gui);
			}	
			
			else if (item.getType() == Material.POTION) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§5Alchimie");
				List<String> description = new ArrayList<>();
				description.add("§4Achat : §a5000$");
				description.add("§3Vente : §a1500$");
				description.add("§4Clique gauche §fpour acheter");
				description.add("§3Clique droit §fpour vendre");
				ItemStack heal = Methods.generateItem(Material.POTION, "§7§lPotion jetable de soin 2", description, 1, (short) 16421);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a3500$");
				description.add(1, "§3Vente : §a1500$");
				ItemStack speed = Methods.generateItem(Material.POTION, "§7§lPotion de vitesse 2", description, 1, (short) 8226);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a4000$");
				description.add(1, "§3Vente : §a1500$");
				ItemStack fire = Methods.generateItem(Material.POTION, "§7§lPotion de résistance au feu", description, 1, (short) 8259);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a7000$");
				description.add(1, "§3Vente : §a2500$");
				ItemStack strenght = Methods.generateItem(Material.POTION, "§7§lPotion de force 2", description, 1, (short) 8233);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a4500$");
				description.add(1, "§3Vente : §a1500$");
				ItemStack regen = Methods.generateItem(Material.POTION, "§7§lPotion de régénération", description, 1, (short) 8225);
				gui.setItem(0, bGlass);
				gui.setItem(1, rGlass);
				gui.setItem(2, bGlass);
				gui.setItem(3, rGlass);
				gui.setItem(4, bGlass);
				gui.setItem(5, rGlass);
				gui.setItem(6, bGlass);
				gui.setItem(7, rGlass);
				gui.setItem(8, bGlass);
				gui.setItem(9, heal);
				gui.setItem(10, bGlass);
				gui.setItem(11, speed);
				gui.setItem(12, bGlass);
				gui.setItem(13, fire);
				gui.setItem(14, bGlass);
				gui.setItem(15, strenght);
				gui.setItem(16, bGlass);
				gui.setItem(17, regen);
				gui.setItem(18, bGlass);
				gui.setItem(19, rGlass);
				gui.setItem(20, bGlass);
				gui.setItem(21, rGlass);
				gui.setItem(22, bGlass);
				gui.setItem(23, rGlass);
				gui.setItem(24, bGlass);
				gui.setItem(25, rGlass);
				gui.setItem(26, back);
				player.openInventory(gui);
			}
			
			else if (item.getType() == Material.IRON_ORE)  {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§8Minerai");
				List<String> description = new ArrayList<>();
				description.add("§4Achat : §a75000$");
				description.add("§3Vente : §a25000$");
				description.add("§4Clique gauche §fpour acheter");
				description.add("§3Clique droit §fpour vendre");
				ItemStack diam = Methods.generateItem(Material.DIAMOND, "§7§l16x Diamants", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a200000$");
				description.add(1, "§3Vente : §a75000$");
				ItemStack emerald = Methods.generateItem(Material.EMERALD, "§7§l16x Émeraudes", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a17500$");
				description.add(1, "§3Vente : §a5750$");
				ItemStack iron = Methods.generateItem(Material.IRON_INGOT, "§7§l16x Fers", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a6250$");
				description.add(1, "§3Vente : §a2075$");
				ItemStack coal = Methods.generateItem(Material.COAL, "§7§l16x Charbons", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a32500$");
				description.add(1, "§3Vente : §a12500$");
				ItemStack gold = Methods.generateItem(Material.GOLD_INGOT, "§7§l16x Ors", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a22500$");
				description.add(1, "§3Vente : §a7500$");
				ItemStack quartz = Methods.generateItem(Material.QUARTZ, "§7§l16x Quartz", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a12500$");
				description.add(1, "§3Vente : §a4250$");
				ItemStack glowstone = Methods.generateItem(Material.GLOWSTONE_DUST, "§7§l16x Poudres de glowstones", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a7500$");
				description.add(1, "§3Vente : §a2500$");
				ItemStack redstone = Methods.generateItem(Material.REDSTONE, "§7§l16x Redstone", description, 16, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a7500$");
				description.add(1, "§3Vente : §a2500$");
				ItemStack lapis = Methods.generateItem(Material.INK_SACK, "§7§l16x Lapis lazuli", description, 16, (short) 4);
				gui.setItem(0, bGlass);
				gui.setItem(1, rGlass);
				gui.setItem(2, quartz);
				gui.setItem(3, rGlass);
				gui.setItem(4, lapis);
				gui.setItem(5, rGlass);
				gui.setItem(6, glowstone);
				gui.setItem(7, rGlass);
				gui.setItem(8, bGlass);
				gui.setItem(9, rGlass);
				gui.setItem(10, bGlass);
				gui.setItem(11, redstone);
				gui.setItem(12, bGlass);
				gui.setItem(13, coal);
				gui.setItem(14, bGlass);
				gui.setItem(15, iron);
				gui.setItem(16, bGlass);
				gui.setItem(17, rGlass);
				gui.setItem(18, bGlass);
				gui.setItem(19, rGlass);
				gui.setItem(20, gold);
				gui.setItem(21, rGlass);
				gui.setItem(22, diam);
				gui.setItem(23, rGlass);
				gui.setItem(24, emerald);
				gui.setItem(25, rGlass);
				gui.setItem(26, back);
				player.openInventory(gui);
			}
			
			else if (item.getType() == Material.MOB_SPAWNER) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eSpawner");
				List<String> description = new ArrayList<>();
				description.add(0, "§4Achat : §a10000000$");
				description.add(1, "§3Vente : §4§lImpossible");
				description.add("§4Clique gauche §fpour acheter");
				description.add("§3Clique droit §fpour vendre");
				ItemStack zombie = Methods.generateItem(Material.MOB_SPAWNER, "§7§lSpawner à zombies", description, 1, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a15000000$");
				description.add(1, "§3Vente : §4§lImpossible");
				ItemStack spider = Methods.generateItem(Material.MOB_SPAWNER, "§7§lSpawner à araignées", description, 1, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a20000000$");
				description.add(1, "§3Vente : §4§lImpossible");
				ItemStack skeleton = Methods.generateItem(Material.MOB_SPAWNER, "§7§lSpawner à squelettes", description, 1, (short) 0);
				description.remove(0);
				description.remove(0);
				description.add(0, "§4Achat : §a5000000$");
				description.add(1, "§3Vente :  §4§lImpossible");
				ItemStack pig = Methods.generateItem(Material.MOB_SPAWNER, "§7§lSpawner à cochons", description, 1, (short) 0);
				gui.setItem(0, bGlass);
				gui.setItem(1, rGlass);
				gui.setItem(2, bGlass);
				gui.setItem(3, rGlass);
				gui.setItem(4, bGlass);
				gui.setItem(5, rGlass);
				gui.setItem(6, bGlass);
				gui.setItem(7, rGlass);
				gui.setItem(8, bGlass);
				gui.setItem(9, rGlass);
				gui.setItem(10, zombie);
				gui.setItem(11, rGlass);
				gui.setItem(12, spider);
				gui.setItem(13, rGlass);
				gui.setItem(14, skeleton);
				gui.setItem(15, rGlass);
				gui.setItem(16, pig);
				gui.setItem(17, rGlass);
				gui.setItem(18, bGlass);
				gui.setItem(19, rGlass);
				gui.setItem(20, bGlass);
				gui.setItem(21, rGlass);
				gui.setItem(22, bGlass);
				gui.setItem(23, rGlass);
				gui.setItem(24, bGlass);
				gui.setItem(25, rGlass);
				gui.setItem(26, back);
				player.openInventory(gui);
			}
			
		}
		
		else if (inventory.getName().equalsIgnoreCase("§cPillage")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.BED) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
				ItemStack pillage = Methods.generateItem(Material.TNT,"§cPillage",null ,1, (short) 0);
				ItemStack agriculture = Methods.generateItem(Material.SEEDS, "§bAgriculture", null, 1, (short) 0);
				ItemStack alchimie = Methods.generateItem(Material.POTION, "§5Alchimie", null, 1, (short) 8229);
				ItemStack minerai = Methods.generateItem(Material.IRON_ORE, "§8Minerai", null, 1, (short) 0);
				ItemStack spawner = Methods.generateItem(Material.MOB_SPAWNER, "§eSpawner", null, 1, (short) 0);
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
			
			else if (item.getType() == Material.TNT) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 7500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 2500, item.getType(), (short) 0, 16);
				}
			}
			
			else if (item.getType() == Material.MONSTER_EGG) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 125000, item.getType(), null, (short) 50, 8);
				
				}
				
			}
			
			else if (item.getType() == Material.SKULL_ITEM) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 200000, item.getType(), null, (short) 1, 3);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 2500, item.getType(), (short) 1, 3);
		
				}
				
			}
		
			else if (item.getType() == Material.SOUL_SAND) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 200, item.getType(), null, (short) 0, 4);
			
				}
			
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 65, item.getType(), (short) 0, 4);
	
				}
			
			}
		
			else if (item.getType() == Material.ENDER_PEARL) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 10000, item.getType(), null, (short) 0, 16);
			
				}
			
				else if (click == ClickType.RIGHT)  {
				
				Methods.sale(player, 3500, item.getType(), (short) 0, 16);
	
				}
			
			}
		
		}
		
		else if (inventory.getName().equalsIgnoreCase("§bAgriculture")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.BED) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
				ItemStack pillage = Methods.generateItem(Material.TNT,"§cPillage",null ,1, (short) 0);
				ItemStack agriculture = Methods.generateItem(Material.SEEDS, "§bAgriculture", null, 1, (short) 0);
				ItemStack alchimie = Methods.generateItem(Material.POTION, "§5Alchimie", null, 1, (short) 8229);
				ItemStack minerai = Methods.generateItem(Material.IRON_ORE, "§8Minerai", null, 1, (short) 0);
				ItemStack spawner = Methods.generateItem(Material.MOB_SPAWNER, "§eSpawner", null, 1, (short) 0);
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
			
			else if (item.getType() == Material.SEEDS) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 150, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 50, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.MELON_SEEDS) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 150, item.getType(), (short) 0, 16);
				}
			
			}
		
			else if (item.getType() == Material.PUMPKIN_SEEDS) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 500, item.getType(), null, (short) 0, 16);
			
				}
			
				else if (click == ClickType.RIGHT)  {
				
					Methods.sale(player, 150, item.getType(), (short) 0, 16);
				}
	
			}
		
			else if (item.getType() == Material.PUMPKIN_SEEDS) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 500, item.getType(), null, (short) 0, 16);
			
				}
			
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 150, item.getType(), (short) 0, 16);
				}
	
			}
		
			else if (item.getType() == Material.WHEAT) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 1500, item.getType(), null, (short) 0, 16);
			
				}
			
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 500, item.getType(), (short) 0, 16);
				}
	
			}	
		
			else if (item.getType() == Material.MELON) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 5000, item.getType(), null, (short) 0, 16);
			
				}
			
				else if (click == ClickType.RIGHT)  {
				
					Methods.sale(player, 1500, item.getType(), (short) 0, 16);
				}
	
			}
		
			else if (item.getType() == Material.PUMPKIN) {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 5000, item.getType(), null, (short) 0, 16);
			
				}
			
				else if (click == ClickType.RIGHT)  {
				
					Methods.sale(player, 1500, item.getType(), (short) 0, 16);
				}
	
			}
			
			else if (item.getType() == Material.CARROT_ITEM) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 150, item.getType(), (short) 0, 16);
				}
		
			}
			
			else if (item.getType() == Material.POTATO_ITEM) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 1250, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 400, item.getType(), (short) 0, 16);
				}
		
			}
			
			else if (item.getType() == Material.CACTUS) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 2000, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 650, item.getType(), (short) 0, 16);
				}
		
			}
	
		}
		
		else if (inventory.getName().equalsIgnoreCase("§5Alchimie")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.BED) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
				ItemStack pillage = Methods.generateItem(Material.TNT,"§cPillage",null ,1, (short) 0);
				ItemStack agriculture = Methods.generateItem(Material.SEEDS, "§bAgriculture", null, 1, (short) 0);
				ItemStack alchimie = Methods.generateItem(Material.POTION, "§5Alchimie", null, 1, (short) 8229);
				ItemStack minerai = Methods.generateItem(Material.IRON_ORE, "§8Minerai", null, 1, (short) 0);
				ItemStack spawner = Methods.generateItem(Material.MOB_SPAWNER, "§eSpawner", null, 1, (short) 0);
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
			
			else if (item.getType() == Material.POTION && item.getItemMeta().getDisplayName() == "§7§lPotion jetable de soin 2") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 5000, item.getType(), null, (short) 16421, 1);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 1500, item.getType(), (short) 16421, 1);
				}
		
			}
		
			else if (item.getType() == Material.POTION && item.getItemMeta().getDisplayName() == "§7§lPotion de vitesse 2") {
			
				if (click == ClickType.LEFT) {
				
					Methods.buy(player, 3500, item.getType(), null, (short) 8226, 1);
			
				}
			
				else if (click == ClickType.RIGHT)  {
				
					Methods.sale(player, 1500, item.getType(), (short) 8226, 1);
				}
	
			}
			
			else if (item.getType() == Material.POTION && item.getItemMeta().getDisplayName() == "§7§lPotion de résistance au feu") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 4000, item.getType(), null, (short) 8259, 1);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 1500, item.getType(), (short) 8259, 1);
				}
		
			}
			
			else if (item.getType() == Material.POTION && item.getItemMeta().getDisplayName() == "§7§lPotion de force 2") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 7000, item.getType(), null, (short) 8233, 1);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 2500, item.getType(), (short) 8233, 1);
				}
		
			}
			
			else if (item.getType() == Material.POTION && item.getItemMeta().getDisplayName() == "§7§lPotion de régénération") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 4500, item.getType(), null, (short) 8225, 1);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 1500, item.getType(), (short) 8225, 1);
				}
		
			}
	
		}
		
		else if (inventory.getName().equalsIgnoreCase("§8Minerai")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.BED) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
				ItemStack pillage = Methods.generateItem(Material.TNT,"§cPillage",null ,1, (short) 0);
				ItemStack agriculture = Methods.generateItem(Material.SEEDS, "§bAgriculture", null, 1, (short) 0);
				ItemStack alchimie = Methods.generateItem(Material.POTION, "§5Alchimie", null, 1, (short) 8229);
				ItemStack minerai = Methods.generateItem(Material.IRON_ORE, "§8Minerai", null, 1, (short) 0);
				ItemStack spawner = Methods.generateItem(Material.MOB_SPAWNER, "§eSpawner", null, 1, (short) 0);
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
			
			else if (item.getType() == Material.DIAMOND) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 75000, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 25000, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.EMERALD) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 200000, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 75000, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.IRON_INGOT) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 17500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 5750, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.GOLD_INGOT) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 32500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 12500, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.COAL) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 6250, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 2075, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.QUARTZ) {
				
				if (click == ClickType.LEFT) {
						
					Methods.buy(player, 22500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 7500, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.GLOWSTONE_DUST) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 12500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 4250, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.REDSTONE) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 7500, item.getType(), null, (short) 0, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 2500, item.getType(), (short) 0, 16);
				}
			
			}
			
			else if (item.getType() == Material.INK_SACK) {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 7500, item.getType(), null, (short) 4, 16);
				
				}
				
				else if (click == ClickType.RIGHT)  {
					
					Methods.sale(player, 2500, item.getType(), (short) 0, 16);
				}
			
			}
	
		}
		
		else if (inventory.getName().equalsIgnoreCase("§eSpawner")) {
			
			event.setCancelled(true);
			if (item.getType() == Material.BED) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eShop");
				ItemStack pillage = Methods.generateItem(Material.TNT,"§cPillage",null ,1, (short) 0);
				ItemStack agriculture = Methods.generateItem(Material.SEEDS, "§bAgriculture", null, 1, (short) 0);
				ItemStack alchimie = Methods.generateItem(Material.POTION, "§5Alchimie", null, 1, (short) 8229);
				ItemStack minerai = Methods.generateItem(Material.IRON_ORE, "§8Minerai", null, 1, (short) 0);
				ItemStack spawner = Methods.generateItem(Material.MOB_SPAWNER, "§eSpawner", null, 1, (short) 0);
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
			
			else if (item.getType() == Material.MOB_SPAWNER && item.getItemMeta().getDisplayName() == "§7§lSpawner à zombies") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 10000000, item.getType(), "§7§lSpawner à zombies", (short) 0, 1);
				
				}
			
			}
			
			else if (item.getType() == Material.MOB_SPAWNER && item.getItemMeta().getDisplayName() == "§7§lSpawner à araignées") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 15000000, item.getType(), "§7§lSpawner à araignées", (short) 0, 1);
				
				}
		
			}
			
			else if (item.getType() == Material.MOB_SPAWNER && item.getItemMeta().getDisplayName() == "§7§lSpawner à squelettes") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 20000000, item.getType(), "§7§lSpawner à squelettes", (short) 0, 1);
			
				}
				
			}
			
			else if (item.getType() == Material.MOB_SPAWNER && item.getItemMeta().getDisplayName() == "§7§lSpawner à cochons") {
				
				if (click == ClickType.LEFT) {
					
					Methods.buy(player, 5000000, item.getType(), "§7§lSpawner à cochons", (short) 0, 1);
				
				}
				
			}
		
		}
		
		else if (inventory.getName().equalsIgnoreCase("§bBoutique")) {
			
			event.setCancelled(true);	
			if (item.getType() == Material.GOLD_BLOCK) {
				
				Inventory gui = Bukkit.createInventory(null, 27, "§eGrades");
				List<String> description = new ArrayList<>();
				description.add("§4Achat : §a75000000$");
				description.add("§4Clique gauche §fpour acheter");
				ItemStack chevalier = Methods.generateItem(Material.IRON_BARDING, "§9Chevalier", null, 1, (short) 0);
				description.remove(0);
				description.add(0,"§4Achat : §a300000000$");
				ItemStack seigneur = Methods.generateItem(Material.GOLD_BARDING, "§aSeigneur", null, 1, (short) 0);
				description.remove(0);
				description.add(0,"§4Achat : §a1800000000$");
				ItemStack empereur = Methods.generateItem(Material.DIAMOND_BARDING, "§6Empereur", null, 1, (short) 0);
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
				gui.setItem(11, chevalier);
				gui.setItem(12, oGlass);
				gui.setItem(13, seigneur);
				gui.setItem(14, oGlass);
				gui.setItem(15, empereur);
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
		
		else if (inventory.getName().equalsIgnoreCase("§eGrades")) {
			
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			event.setCancelled(true);
			
			if (item.getType() == Material.IRON_BARDING) {
				
				PermissionUser user = pexapi.getUser(player);
				if (user.inGroup("default")) {
					
					if (Economy.hasEnough(player.getName(), 75000000)) {
						
						user.addGroup("chevalier");
						Economy.subtract(player.getName(), 75000000);
						player.closeInventory();
						player.sendMessage("§2Vous avez acheté le grade §9Chevalier");
					
					}
					
					else {
						
						player.sendMessage("§cTu n'a pas assez d'argent");
						
					}
				
				}
				
				else {
					
					player.sendMessage("§cTu as déjà un grade supérieur");
					
				}
				
			}
			
			else if (item.getType() == Material.GOLD_BARDING) {
				
				PermissionUser user = pexapi.getUser(player);
				if (user.inGroup("default") || user.inGroup("chevalier")) {
					
					if (Economy.hasEnough(player.getName(), 300000000)) {
						
						user.addGroup("seigneur");
						Economy.subtract(player.getName(), 300000000);
						player.closeInventory();
						player.sendMessage("§2Vous avez acheté le grade §aSeigneur");
						
					}
					
					else {
						
						player.sendMessage("§cTu n'a pas assez d'argent");
						
					}
				
				}
				
				else {
					
					player.sendMessage("§cTu as déjà un grade supérieur");
				
				}
				
			}
			
			else if (item.getType() == Material.DIAMOND_BARDING) {
				
				PermissionUser user = pexapi.getUser(player);
				if (user.inGroup("default") || user.inGroup("chevalier") || user.inGroup("seigneur")) {
					
					if (Economy.hasEnough(player.getName(), 1800000000)) {
						
						user.addGroup("empereur");
						Economy.subtract(player.getName(), 1800000000);
						player.closeInventory();
						player.sendMessage("§2Vous avez acheté le grade §6Empereur");
					
					}
					
					else {
						
						player.sendMessage("§cTu n'a pas assez d'argent");
						
					}
				
				}
				
				else {
					
					player.sendMessage("§cTu as déjà un grade supérieur");
				
				}
				
			}
			
		}
	
	}
	
	@EventHandler
	public void onSpawnerPlace(BlockPlaceEvent e) {
		
		Block block = e.getBlockPlaced();
		ItemStack item = e.getPlayer().getItemInHand();
		if (block != null && item != null) {
			
			if (block.getType() == Material.MOB_SPAWNER && item.getType() == Material.MOB_SPAWNER) {
				
				ItemMeta mItem = item.getItemMeta();
				if (mItem.getDisplayName().equals("§7§lSpawner à zombies")) {
					
					Methods.setSpawner(block, EntityType.ZOMBIE);
				}
				
				else if (mItem.getDisplayName().equals("§7§lSpawner à araignées")) {
					
					Methods.setSpawner(block, EntityType.SPIDER);
				}
				
				else if (mItem.getDisplayName().equals("§7§lSpawner à squelettes")) {
					
					Methods.setSpawner(block, EntityType.SKELETON);
				}
					
			}	
    
		}
	
	}
	
	@EventHandler(priority = EventPriority.HIGH)
	public void OnPlayerJoin(PlayerLoginEvent event) {
		
		if (event.getResult() == Result.KICK_BANNED) {
			
			Player player = event.getPlayer();
			if (Bukkit.getServer().getBanList(BanList.Type.NAME).isBanned(player.getName()) == true) {
				
				String message = Bukkit.getServer().getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getReason();
				if (Bukkit.getServer().getBanList(BanList.Type.NAME).getBanEntry(player.getName()).getExpiration() == null) {
					
					event.setKickMessage(message);
				}
			
			}
		
		}
		
	}
	
}