package net.sagapvp.cities.entities;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Giant;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_10_R1.EntityGiantZombie;
import net.minecraft.server.v1_10_R1.EntitySkeleton;
import net.minecraft.server.v1_10_R1.EntityZombie;
import net.minecraft.server.v1_10_R1.EnumItemSlot;

public class Boss implements Listener {
	
	public static void initBosses() {
		NMSUtil nmsu = new NMSUtil();
		
		nmsu.registerEntity("Mega Boss", 54, EntityZombie.class, MegaBoss.class);
		nmsu.registerEntity("Legendary Boss", 51, EntitySkeleton.class, LegendaryBoss.class);
		nmsu.registerEntity("King Boss", 53, EntityGiantZombie.class, KingBoss.class);
		
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerSpawnBoss(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().getType().equals(Material.MONSTER_EGG)) {
				MegaBoss.spawn(e.getClickedBlock().getLocation());
			}
		}
	}
	
	@EventHandler
	public void mobDeath(EntityDeathEvent e) {
		//Checking for MegaBoss
		if(e.getEntity() instanceof Zombie) {
			if(e.getEntity().getCustomName().equals(null)) {
				return;
			}
			if(e.getEntity().getCustomName().equals(ChatColor.BLUE + "" + ChatColor.BOLD + "Mega Boss")) {
				
			}
		}
		//Checking for LegendaryBoss
		if(e.getEntity() instanceof Skeleton) {
			if(e.getEntity().getCustomName().equals(null)) {
				return;
			}
			if(e.getEntity().getCustomName().equals(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Legendary Boss")) {
				
			}
		}
		//Checking for KingBoss
		if(e.getEntity() instanceof Giant) {
			if(e.getEntity().getCustomName().equals(null)) {
				return;
			}
			if(e.getEntity().getCustomName().equals(ChatColor.RED + "" + ChatColor.BOLD + "King Boss")) {
				
			}
		}
	}
	
	@EventHandler
	public void bossSpawn(EntitySpawnEvent e) {
		if(e.getEntity().getCustomName() == null) {
			return;
		}
		//Mega Boss Equipment
		if(e.getEntity().getCustomName().equalsIgnoreCase(ChatColor.BLUE + "" + ChatColor.BOLD + "Mega Boss")) {
			ItemStack megaBossAxe = new ItemStack(Material.IRON_AXE, 1);
			megaBossAxe.addEnchantment(Enchantment.DAMAGE_ALL, 5);
			megaBossAxe.addEnchantment(Enchantment.DURABILITY, 5);
			megaBossAxe.addEnchantment(Enchantment.FIRE_ASPECT, 5);
			
			ItemStack megaBossHelmet = new ItemStack(Material.CHAINMAIL_BOOTS,1 );
			megaBossHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			
			ItemStack megaBossChestplate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
			megaBossChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			
			ItemStack megaBossLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
			megaBossLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			
			ItemStack megaBossBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
			megaBossBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
			
			net.minecraft.server.v1_10_R1.ItemStack nmsAxe = CraftItemStack.asNMSCopy(megaBossAxe);
			net.minecraft.server.v1_10_R1.ItemStack nmsHelmet = CraftItemStack.asNMSCopy(megaBossHelmet);
			net.minecraft.server.v1_10_R1.ItemStack nmsChestplate = CraftItemStack.asNMSCopy(megaBossChestplate);
			net.minecraft.server.v1_10_R1.ItemStack nmsLeggings = CraftItemStack.asNMSCopy(megaBossLeggings);
			net.minecraft.server.v1_10_R1.ItemStack nmsBoots = CraftItemStack.asNMSCopy(megaBossBoots);
			
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.MAINHAND, nmsAxe);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.HEAD, nmsHelmet);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.CHEST, nmsChestplate);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.LEGS, nmsLeggings);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.FEET, nmsBoots);
		}
		//Legendary Boss Equipment
		if(e.getEntity().getCustomName().equalsIgnoreCase(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Legendary Boss")) {
			ItemStack legendaryBossSword = new ItemStack(Material.DIAMOND_SWORD, 1);
			legendaryBossSword.addEnchantment(Enchantment.DAMAGE_ALL, 10);
			legendaryBossSword.addEnchantment(Enchantment.DURABILITY, 10);
			legendaryBossSword.addEnchantment(Enchantment.FIRE_ASPECT, 10);
			
			ItemStack legendaryBossHelmet = new ItemStack(Material.DIAMOND_HELMET,1 );
			legendaryBossHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
			
			ItemStack legendaryBossChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
			legendaryBossChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
			
			ItemStack legendaryBossLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
			legendaryBossLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
			
			ItemStack legendaryBossBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);
			legendaryBossBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
			
			net.minecraft.server.v1_10_R1.ItemStack nmsSword = CraftItemStack.asNMSCopy(legendaryBossSword);
			net.minecraft.server.v1_10_R1.ItemStack nmsHelmet = CraftItemStack.asNMSCopy(legendaryBossHelmet);
			net.minecraft.server.v1_10_R1.ItemStack nmsChestplate = CraftItemStack.asNMSCopy(legendaryBossChestplate);
			net.minecraft.server.v1_10_R1.ItemStack nmsLeggings = CraftItemStack.asNMSCopy(legendaryBossLeggings);
			net.minecraft.server.v1_10_R1.ItemStack nmsBoots = CraftItemStack.asNMSCopy(legendaryBossBoots);
			
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.MAINHAND, nmsSword);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.HEAD, nmsHelmet);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.CHEST, nmsChestplate);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.LEGS, nmsLeggings);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.FEET, nmsBoots);
		}
		//King Boss Equipment
		if(e.getEntity().getCustomName().equalsIgnoreCase(ChatColor.RED + "" + ChatColor.BOLD + "King Boss")) {
			ItemStack kingBossSword = new ItemStack(Material.WOOD_SWORD, 1);
			kingBossSword.addEnchantment(Enchantment.DAMAGE_ALL, 25);
			kingBossSword.addEnchantment(Enchantment.DURABILITY, 1000);
			kingBossSword.addEnchantment(Enchantment.FIRE_ASPECT, 25);
			kingBossSword.addEnchantment(Enchantment.KNOCKBACK, 5);
			
			ItemStack kingBossHelmet = new ItemStack(Material.GOLD_HELMET,1 );
			kingBossHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 25);
			
			ItemStack kingBossChestplate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
			kingBossChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 25);
			
			ItemStack kingBossLeggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
			kingBossLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 25);
			
			ItemStack kingBossBoots = new ItemStack(Material.GOLD_BOOTS, 1);
			kingBossBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 25);
			
			net.minecraft.server.v1_10_R1.ItemStack nmsSword = CraftItemStack.asNMSCopy(kingBossSword);
			net.minecraft.server.v1_10_R1.ItemStack nmsHelmet = CraftItemStack.asNMSCopy(kingBossHelmet);
			net.minecraft.server.v1_10_R1.ItemStack nmsChestplate = CraftItemStack.asNMSCopy(kingBossChestplate);
			net.minecraft.server.v1_10_R1.ItemStack nmsLeggings = CraftItemStack.asNMSCopy(kingBossLeggings);
			net.minecraft.server.v1_10_R1.ItemStack nmsBoots = CraftItemStack.asNMSCopy(kingBossBoots);
			
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.MAINHAND, nmsSword);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.HEAD, nmsHelmet);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.CHEST, nmsChestplate);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.LEGS, nmsLeggings);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.FEET, nmsBoots);
		}
	}
}
