package fr.venodez.plugin;

import org.bukkit.plugin.java.JavaPlugin;


public final class Main extends JavaPlugin {
		
	@Override
	public void onEnable() {
		
		getCommand("shop").setExecutor(new CommandShop());
		getCommand("aban").setExecutor(new CommandBan());
		getCommand("boutique").setExecutor(new CommandBoutique());
		getCommand("mod").setExecutor(new CommandMod());
		getServer().getPluginManager().registerEvents(new Event(), this);
	
	}
	
	@Override
	public void onDisable() {
		
	}

}	
		