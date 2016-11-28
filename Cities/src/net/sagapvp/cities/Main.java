package net.sagapvp.cities;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import net.sagapvp.cities.entities.Boss;

public class Main extends JavaPlugin {

	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(new Boss(), this);
		
		Boss.initBosses();
	}
	
}
