package fr.venodez.plugin;

import java.util.ArrayList;
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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("reset")) {
			
			for (Faction faction : FactionColl.get().getAll()) {
				
				if (faction.getName() != "WarZone" || faction.getName() != "SafeZone") {
					
					faction.detach();
				}
			}
			
		}
		
		return false;
	}

}
