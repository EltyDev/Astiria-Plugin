package fr.venodez.plugin;

import org.bukkit.BanList.Type;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandBan implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("aban"))  {
		
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (args.length == 0) {
					
					player.sendMessage("§cIl faut donner un joueur");
				}
				
				else if (args.length == 1) {
					
					player.sendMessage("§cIl faut donner une raison");
				}
				
				else if (args.length == 2) {
					
					target.getWorld().strikeLightning(target.getLocation());
					Bukkit.getBanList(Type.NAME).addBan(args[0], args[1], null, null);
					String message = "§e§l[Modération] §r§c" + args[0] + " §6s'est fait ban par §5§l" + player.getName() + " §r§6pour §c" + args[1];
					Bukkit.broadcastMessage(String.format(message));
					
				}
				
				else {
					
					player.sendMessage("§cVous avez trop donnés d'arguments");
				}
			}
			
			else {
				
				
			}
		
		}
		
		return false;
	}

}
