package me.nutowen;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;

import com.sk89q.worldedit.bukkit.selections.CuboidSelection;

public class City {
	private String id;
	private CuboidSelection bounds;
	
	protected City(String id){
		this.id = id;
		
		this.bounds = new CuboidSelection(
				Bukkit.getServer().getWorld(SettingsManager.getCities().<String>get(id + ".world")),
				Main.loadLocation(SettingsManager.getCities().<ConfigurationSection>get(id + ".cornerA")),
				Main.loadLocation(SettingsManager.getCities().<ConfigurationSection>get(id + ".cornerB"))
		);
	}
	
	
	
	
	public String getID() {
		return id;
	}
	
	public CuboidSelection getBounds() {
		return bounds;
	}
}
