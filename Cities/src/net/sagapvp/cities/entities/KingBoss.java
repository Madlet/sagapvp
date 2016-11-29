package net.sagapvp.cities.entities;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_10_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.entity.Giant;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.EntityGiantZombie;
import net.minecraft.server.v1_10_R1.GenericAttributes;
import net.minecraft.server.v1_10_R1.World;

public class KingBoss extends EntityGiantZombie {
	
	public KingBoss(World world) {
		super(world);
	}

	protected void initAttributes() {
		super.initAttributes();
		
		this.getAttributeInstance(GenericAttributes.ATTACK_DAMAGE).setValue(50.00);
		this.getAttributeInstance(GenericAttributes.maxHealth).setValue(250.00);
		this.setCustomName(ChatColor.RED + "" + ChatColor.BOLD + "King Boss");
		this.setCustomNameVisible(true);
		this.getAttributeInstance(GenericAttributes.MOVEMENT_SPEED).setValue(1.00);
		this.getAttributeInstance(GenericAttributes.FOLLOW_RANGE).setValue(20.00);
	}
	
	public static Giant spawn(Location loc) {
		World mcWorld = (World) ((CraftWorld) loc.getWorld()).getHandle();
		final MegaBoss customEntity = new MegaBoss(mcWorld);
		
		customEntity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		((CraftLivingEntity) customEntity.getBukkitEntity()).setRemoveWhenFarAway(false);
		mcWorld.addEntity(customEntity, SpawnReason.CUSTOM);
		return (Giant) customEntity.getBukkitEntity();
	}
}
