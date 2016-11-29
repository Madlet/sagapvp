package net.sagapvp.cities.entities;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.EntityZombie;
import net.minecraft.server.v1_10_R1.GenericAttributes;
import net.minecraft.server.v1_10_R1.World;

public class MegaBoss extends EntityZombie {
	
	public MegaBoss(World world) {
		super(world);
	}

	protected void initAttributes() {
		super.initAttributes();
		
		this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(10.00);
		this.getAttributeInstance(GenericAttributes.maxHealth).setValue(100.00);
		this.setCustomName(ChatColor.BLUE + "" + ChatColor.BOLD + "Mega Boss");
		this.setCustomNameVisible(true);
		this.setBaby(false);
		this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(0.5);
	}
	
	public static Zombie spawn(Location loc) {
		World mcWorld = (World) ((CraftWorld) loc.getWorld()).getHandle();
		final MegaBoss customEntity = new MegaBoss(mcWorld);
		
		customEntity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
		mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
		return (Zombie) customEntity.getBukkitEntity();
	}
	
}
