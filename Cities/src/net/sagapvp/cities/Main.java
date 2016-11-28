package net.sagapvp.cities;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import net.sagapvp.cities.entities.Boss;

public class Main extends JavaPlugin {
	
	public static Plugin plugin;

	public void onEnable() {
		plugin = this;
		
		Bukkit.getPluginManager().registerEvents(new Boss(), this);
		
		Boss.initBosses();
	}
	
	public void onDisable() {
		plugin = null;
	}

	public static Location loadLocation(ConfigurationSection configurationSection) {
		return null;
	}

	public static Plugin getPlugin() {
		return plugin;
	}
	
}
