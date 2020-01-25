package fr.venodez.plugin;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.earth2me.essentials.api.Economy;
import com.earth2me.essentials.api.NoLoanPermittedException;
import com.earth2me.essentials.api.UserDoesNotExistException;

public class Methods {
	
	public static ItemStack generateItem(Material objet, String nom, List<String> description, int nombre , short metadata) {
		
		ItemStack item = new ItemStack(objet,nombre,metadata);
		ItemMeta mItem = item.getItemMeta();
		mItem.setDisplayName(nom);
		mItem.setLore(description);
		item.setItemMeta(mItem);
		return item;
	}
	
    public static void setSpawner(Block block, EntityType entity) {
        
    	BlockState blockState = block.getState();
        CreatureSpawner spawner = ((CreatureSpawner) blockState);
        spawner.setSpawnedType(entity);
        blockState.update();
    }
    
	@SuppressWarnings("deprecation")
	public static void buy(Player player, double prix, Material item, String nom, short metadata, int nombre) throws NoLoanPermittedException, IllegalArgumentException, UserDoesNotExistException {
    	
    	Inventory pInventory = player.getInventory();
    	ItemStack pItem = new ItemStack(item, nombre, metadata);
    	ItemMeta mItem = pItem.getItemMeta();
    	mItem.setDisplayName(nom);
    	pItem.setItemMeta(mItem);
		if (Economy.hasEnough(player.getName(), prix)) {
			
			String message = "§2Vous avez acheté ";
			String message2 = " ";
			String sItem = item.name();
			String sNombre = String.valueOf(nombre);
			String fMessage = message + sNombre + message2 + sItem;
			Economy.subtract(player.getName(), prix);
			pInventory.addItem(pItem);
			player.sendMessage(String.format(fMessage));
		}
		
		else {
			
			player.sendMessage("§cVous n'avez pas assez d'argent");
		}
    }
	
	@SuppressWarnings("deprecation")
	public static void sale(Player player, double prix, Material item, short metadata, int nombre) throws NoLoanPermittedException, UserDoesNotExistException {
		
		Inventory pInventory = player.getInventory();
		ItemStack pItem = new ItemStack(item, nombre, metadata);
		if (pInventory.contains(item, nombre)) {
			
			String message = "§2Vous avez vendu ";
			String message2 = " ";
			String sItem = item.name();
			String sNombre = String.valueOf(nombre);
			String fMessage = message + sNombre + message2 + sItem;
			Economy.add(player.getName(), prix);
			pInventory.removeItem(pItem);
			player.sendMessage(String.format(fMessage));
			
		}
		
		else {
			
			String message = "§2Vous n'avez pas assez de ";
			String sItem = item.name();
			String fMessage = message + sItem;
			player.sendMessage(String.format(fMessage));
		}
	}
}
