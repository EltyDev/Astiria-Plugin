package fr.venodez.plugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		getCommand("reset").setExecutor(new CommandReset());
		getCommand("shop").setExecutor(new CommandShop());
		getServer().getPluginManager().registerEvents(new EventGui(), this);
	}
	
	@Override
	public void onDisable() {
		
	}
}
		