package fr.venodez.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
	
	public List<String> list = CommandReset.getFrozen();
	
	@Override
	public void onEnable() {
		getCommand("reset").setExecutor(new CommandReset());
		getCommand("shop").setExecutor(new CommandShop());
		getServer().getPluginManager().registerEvents(new Event(), this);
		List<String> list = getConfig().getStringList("Cleared Player");
	}
	
	@Override
	public void onDisable() {
		
		getConfig().set("Cleared Player", list);
		saveConfig();
	}
}	
		