package fr.venodez.plugin;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
	
	public static List<String> list = new ArrayList<String>();
	public static List<String> getFrozen() {
		
		return list;
	}
	
	@Override
	public void onEnable() {
		getCommand("shop").setExecutor(new CommandShop());
		getServer().getPluginManager().registerEvents(new Event(), this);
		list = getConfig().getStringList("Cleared Player");
	}
	
	@Override
	public void onDisable() {
		
		getConfig().set("Cleared Player", list);
		saveConfig();
	}
}	
		