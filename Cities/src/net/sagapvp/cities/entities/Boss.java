package net.sagapvp.cities.entities;

import static net.md_5.bungee.api.ChatColor.BOLD;
import static net.md_5.bungee.api.ChatColor.RED;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_10_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_10_R1.inventory.CraftItemStack;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.minecraft.server.v1_10_R1.EntityZombie;
import net.minecraft.server.v1_10_R1.EnumItemSlot;
import net.minecraft.server.v1_10_R1.NBTTagCompound;
import net.minecraft.server.v1_10_R1.NBTTagList;

public class Boss implements Listener {

	public static ItemStack megaBoss;
	
	public static void initBosses() {
		NMSUtil nmsu = new NMSUtil();
		
		nmsu.registerEntity("Mega Boss", 54, EntityZombie.class, CustomEntityZombie.class);
		
		megaBoss = new ItemStack(Material.MONSTER_EGG, 1, (short) 54);
		ItemMeta megaBossMeta = megaBoss.getItemMeta();
		megaBossMeta.setDisplayName(RED + "" + BOLD + "MegaBoss");
		megaBoss.setItemMeta(megaBossMeta);
		megaBoss = addGlow(megaBoss);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerSpawnBoss(PlayerInteractEvent e) {
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
			if(e.getPlayer().getItemInHand().equals(megaBoss) && e.getPlayer().getItemInHand().getItemMeta().equals(megaBoss.getItemMeta())) {
				
			}
		}
	}
	
	@EventHandler
	public void zombieDeath(EntityDeathEvent e) {
		if(e.getEntity() instanceof Zombie) {
			if(e.getEntity().getCustomName().equals(null)) {
				return;
			}
			if(e.getEntity().getCustomName().equals(megaBoss.getItemMeta().getDisplayName())) {
				for(int d = 0; d < 64; d++) {
					Item diamond = e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 1));
				}
			}
		}
	}
	
	@EventHandler
	public void bossSpawn(EntitySpawnEvent e) {
		if(e.getEntity().getCustomName() == null) {
			return;
		}
		if(e.getEntity().getCustomName().equalsIgnoreCase("MegaBoss")) {
			ItemStack megaBossHelmet = new ItemStack(Material.DIAMOND_HELMET);
			megaBossHelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			ItemStack megaBossChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
			megaBossChestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			ItemStack megaBossLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
			megaBossLeggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			ItemStack megaBossBoots = new ItemStack(Material.DIAMOND_BOOTS);
			megaBossBoots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
			
			net.minecraft.server.v1_10_R1.ItemStack nmsHelmet = CraftItemStack.asNMSCopy(megaBossHelmet);
			net.minecraft.server.v1_10_R1.ItemStack nmsChestplate = CraftItemStack.asNMSCopy(megaBossChestplate);
			net.minecraft.server.v1_10_R1.ItemStack nmsLeggings = CraftItemStack.asNMSCopy(megaBossLeggings);
			net.minecraft.server.v1_10_R1.ItemStack nmsBoots = CraftItemStack.asNMSCopy(megaBossBoots);
			
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.HEAD, nmsHelmet);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.CHEST, nmsChestplate);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.LEGS, nmsLeggings);
			((CraftLivingEntity) e.getEntity()).getHandle().setEquipment(EnumItemSlot.FEET, nmsBoots);
			
			Bukkit.getServer().getWorld(e.getEntity().getWorld().getName()).strikeLightning(e.getEntity().getLocation());
		}
	}
	
	public static ItemStack addGlow(ItemStack item) {
		net.minecraft.server.v1_10_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
		NBTTagCompound tag = null;
		
		if(nmsStack.hasTag()) {
			tag = new NBTTagCompound();
			nmsStack.setTag(tag);
		}
		
		if(tag == null) {
			tag = nmsStack.getTag();
		}
		
		NBTTagList enchantment = new NBTTagList();
		tag.set("enth", enchantment);
		nmsStack.setTag(tag);
		return CraftItemStack.asCraftMirror(nmsStack);
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		e.getPlayer().getInventory().addItem(megaBoss);
	}
	
}
