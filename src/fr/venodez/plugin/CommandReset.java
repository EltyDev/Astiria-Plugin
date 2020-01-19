package fr.venodez.plugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.FactionColl;
import com.massivecraft.factions.entity.MPlayer;



public class CommandReset implements CommandExecutor {
	
	public static ArrayList<String> list = new ArrayList<String>();
	public static List<String> getFrozen() {
		
		return list;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("reset")) {
			
			list.clear();
			for (Faction faction : FactionColl.get().getAll()) {
				
				if (faction.getName() != "WarZone" || faction.getName() != "SafeZone") {
					
					faction.detach();
				}
			}
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				
				player.getInventory().clear();
				player.updateInventory();
				list.add(player.getName());
			
			}
		}
		
		return false;
	}

}
