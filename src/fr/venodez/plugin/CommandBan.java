package fr.venodez.plugin;

import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandBan implements CommandExecutor {
	
	public String raison;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("aban"))  {
		
			if (sender instanceof Player) {
				
				Player player = (Player) sender;
				if (args.length == 0) {
					
					player.sendMessage("§cIl faut donner un joueur");
				}
				
				else if (args.length == 1) {
					
					player.sendMessage("§cIl faut donner une raison");
				}
				
				else if (args.length >= 2) {	

					Player target = Bukkit.getServer().getPlayer(args[0]);
					target.getWorld().strikeLightning(target.getLocation());
					for (int i = 1; i == args.length; i++) {
						
						raison += args[i];
							
					}
					
					
					String pMessage = "§cVous avez été bannis du serveur" + "\n" + "§7Raison : §f" + raison + "\n" + "§7Par : §f" + player.getName();
					Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(args[0], raison, null, null);
					target.kickPlayer(pMessage);
					String bMessage = "§e§l[Modération] §r§c" + args[0] + " §6s'est fait ban par §5§l" + player.getName() + " §r§6pour §c" + raison;
					Bukkit.broadcastMessage(String.format(bMessage));
					
				} 
			}
			
			else {
				
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				if (args.length == 0) {
					
					console.sendMessage("§cIl faut donner un joueur");
				}
				
				else if (args.length == 1) {
					
					console.sendMessage("§cIl faut donner une raison");
				}
				
				else if (args.length >= 2) {	
					
					Player target = Bukkit.getServer().getPlayer(args[0]);
					target.getWorld().strikeLightning(target.getLocation());
					for (int i = 1; i == args.length; i++) {
						
						raison += args[i];
							
					}
					
					String pMessage = "§cVous avez été bannis du serveur" + "\n" + "§7Raison : §f" + raison + "\n" + "§7Par :§f Console";
					Bukkit.getServer().getBanList(BanList.Type.NAME).addBan(args[0], raison, null, null);
					target.kickPlayer(pMessage);
					String message = "§e§l[Modération] §r§c" + args[0] + " §6s'est fait ban par la §5§lconsole §r§6pour §c" + raison;
					Bukkit.broadcastMessage(String.format(message));

				}
			
			}
		
		}
		
		return false;
	}

}
