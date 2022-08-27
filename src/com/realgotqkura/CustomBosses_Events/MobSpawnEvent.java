package com.realgotqkura.CustomBosses_Events;

import com.realgotqkura.CBossItemStacks.ExternalItems;
import com.realgotqkura.CBossItemStacks.EquipmentStacks;
import com.realgotqkura.CBossUtils.DPAdder;
import CBossesMain.main;
import com.realgotqkura.CBossUtils.RandomUtils;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.realgotqkura.DataManager.CustomConfig_1;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MobSpawnEvent implements Listener{

	private String sversion = "N/A";
	public CustomConfig_1 data;
	private main plugin;
	private int max = Integer.MAX_VALUE;
	public MobSpawnEvent(CustomConfig_1 data, main plugin) {
		this.data = data;
		this.plugin = plugin;
	}


	private void getVersion(){
		try {
			sversion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		}catch(ArrayIndexOutOfBoundsException e){
			return;
		}
	}

	public void spawnMethod(CustomConfig_1 data, main plugin, String uuid, String worldname, Location loc) {
		World world = Bukkit.getWorld(worldname);
		loc.setY(loc.getY()+1);
		this.data.reloadConfig();
		switch(Objects.requireNonNull(this.data.getConfig().getString("players." + uuid + ".MobType"))) {
			case "Zombie":
				addMob(EntityType.ZOMBIE,world,loc,uuid);
				break;
			case "Skeleton":
				addMob(EntityType.SKELETON,world,loc,uuid);
				break;
			case "Spider":
				addMob(EntityType.SPIDER,world,loc,uuid);
				break;
			case "Pigman":
				getVersion();
				if(sversion.contains("16")) {
					addMob(EntityType.PIGLIN,world,loc,uuid);
				}else {
					addMob(EntityType.valueOf("PIG_ZOMBIE"),world,loc,uuid);
				}
				break;
			case "Enderman":
				addMob(EntityType.ENDERMAN,world,loc,uuid);
				break;
			case "Wither Skeleton":
				addMob(EntityType.WITHER_SKELETON, world, loc, uuid);
				break;
			case "Witch":
				addMob(EntityType.WITCH, world, loc, uuid);
				break;
			case "Blaze":
				addMob(EntityType.BLAZE,world,loc,uuid);
				break;
			case "Creeper":
				addMob(EntityType.CREEPER,world,loc,uuid);
				break;
			case "Guardian":
				addMob(EntityType.GUARDIAN,world,loc,uuid);
				break;
			default:
				System.out.println("You haven't picked a mob yet");
				break;

		    }
		}

	public void addMob(EntityType type, World world, Location location, String uuid){
		EquipmentStacks stacks = new EquipmentStacks();
		DPAdder adder = new DPAdder(this.data);
		ItemStack helmet = this.data.getConfig().getItemStack("players." + uuid + ".MobHelmet");
		ItemStack chestplate = this.data.getConfig().getItemStack("players." + uuid + ".MobChestplate");
		ItemStack mainhand = this.data.getConfig().getItemStack("players." + uuid + ".MobMainhand");
		ItemStack offhand = this.data.getConfig().getItemStack("players." + uuid + ".MobOffHand");
		ItemStack leggings = this.data.getConfig().getItemStack("players." + uuid + ".MobLeggings");
		ItemStack boots = this.data.getConfig().getItemStack("players." + uuid + ".MobBoots");
		LivingEntity zombie = (LivingEntity) world.spawnEntity(location, type);
		zombie.setCustomName(RandomUtils.color(this.data.getConfig().getString("players." + uuid + ".MobName")));
		zombie.setCustomNameVisible(true);
		zombie.setMaxHealth(this.data.getConfig().getInt("players." + uuid + ".MobHealth"));
		zombie.setHealth(zombie.getMaxHealth());
		if(this.data.getConfig().getBoolean("players." + uuid + ".MobPot_Speed")){
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + uuid + ".MobPot_SpeedChat")));
		}
		if(this.data.getConfig().getBoolean("players." + uuid + ".MobPot_Strength")){
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + uuid + ".MobPot_StrengthChat")));
		}
		if(this.data.getConfig().getBoolean("players." + uuid + ".MobPot_Weakness")){
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + uuid + ".MobPot_WeaknessChat")));
		}
		if(this.data.getConfig().getBoolean("players." + uuid + ".MobPot_Slowness")){
			zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + uuid + ".MobPot_SlownessChat")));
		}
		if(this.data.getConfig().getBoolean("players." + uuid + ".MobBaby")){
			if(type == EntityType.ZOMBIE){
				Zombie zombie1 = (Zombie) zombie;
				zombie1.setBaby();
			}
		}
		if(type != EntityType.CREEPER && type != EntityType.GUARDIAN && type != EntityType.BLAZE && type != EntityType.WITHER && type != EntityType.SPIDER){
			data.reloadConfig();
			if(type != EntityType.ENDERMAN){
				//Set equipment
				zombie.getEquipment().setBoots(boots);
				zombie.getEquipment().setLeggings(leggings);
				zombie.getEquipment().setChestplate(chestplate);
				zombie.getEquipment().setHelmet(helmet);
				zombie.getEquipment().setItemInMainHand(mainhand);
				zombie.getEquipment().setItemInOffHand(offhand);
				adder.DPAdd(zombie, uuid);
				if(offhand.equals(stacks.Offhand())){
					zombie.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
				}
				if(helmet.equals(stacks.Helmet())){
					zombie.getEquipment().setHelmet(new ItemStack(Material.AIR));
				}
			}
			zombie.getEquipment().setItemInMainHand(mainhand);
			if(mainhand.equals(stacks.Mainhand())){
				zombie.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
			}
		}
	}

	@EventHandler
	public void Spawn(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		//Stuff
		ExternalItems items = new ExternalItems();
		if(player.getInventory().getItemInMainHand().isSimilar(items.SpawnStick())) {
			if(event.getHand() == EquipmentSlot.HAND) {
				if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Location loc = Objects.requireNonNull(event.getClickedBlock()).getLocation();
			loc.setY(loc.getY()+1);
			World world = player.getWorld();
			player.sendMessage("§aSuccessfully spawned a boss!");
			this.data.reloadConfig();
		    spawnMethod(data, plugin, player.getUniqueId().toString(), world.getName(), loc);

		    }
		  }
		}

	}
}
