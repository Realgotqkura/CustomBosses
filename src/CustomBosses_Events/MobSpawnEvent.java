package CustomBosses_Events;

import CBossItemStacks.EquipmentStacks;
import CBossUtils.DPAdder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import CBossItemStacks.ExternalItems;
import DataManager.CustomConfig_1;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Objects;

public class MobSpawnEvent implements Listener{

	private String sversion = "N/A";
	public CustomConfig_1 data;
	private int max = Integer.MAX_VALUE;
	public MobSpawnEvent(CustomConfig_1 data) {
		this.data = data;
	}


	private void getVersion(){
		try {
			sversion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
		}catch(ArrayIndexOutOfBoundsException e){
			return;
		}
	}
	@EventHandler
	public void Spawn(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		//ItemStacks
		ItemStack helmet = this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobHelmet");
		ItemStack chestplate = this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobChestplate");
		ItemStack mainhand = this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobMainhand");
		ItemStack offhand = this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobOffHand");
		ItemStack leggings = this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobLeggings");
		ItemStack boots = this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobBoots");
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
			EquipmentStacks stacks = new EquipmentStacks();
					DPAdder adder = new DPAdder(this.data);
			switch(Objects.requireNonNull(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobType"))) {
			case "Zombie":
                Zombie zombie = (Zombie) world.spawnEntity(loc, EntityType.ZOMBIE);
                zombie.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
                zombie.setCustomNameVisible(true);
                zombie.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
                zombie.setHealth(zombie.getMaxHealth());
                if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
                	zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
				}
                if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
					zombie.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
				}
				if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
					zombie.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
				}
				if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
					zombie.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
				}
				if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobBaby")){
					zombie.setBaby();
				}
				//Set equipment
				data.reloadConfig();
				zombie.getEquipment().setBoots(boots);
				zombie.getEquipment().setLeggings(leggings);
				zombie.getEquipment().setChestplate(chestplate);
				zombie.getEquipment().setHelmet(helmet);
				zombie.getEquipment().setItemInMainHand(mainhand);
				zombie.getEquipment().setItemInOffHand(offhand);
				adder.ZombieAdd(zombie, player);
				if(mainhand.equals(stacks.Mainhand())){
					zombie.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
				}
				if(offhand.equals(stacks.Offhand())){
					zombie.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
				}
				if(helmet.equals(stacks.Helmet())){
					zombie.getEquipment().setHelmet(new ItemStack(Material.AIR));
				}
				break;
				case "Skeleton":
					Skeleton skeleton = (Skeleton) world.spawnEntity(loc, EntityType.SKELETON);
					skeleton.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					skeleton.setCustomNameVisible(true);
					skeleton.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					skeleton.setHealth(skeleton.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						skeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						skeleton.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						skeleton.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					//Set equipment
					data.reloadConfig();
					skeleton.getEquipment().setBoots(boots);
					skeleton.getEquipment().setLeggings(leggings);
					skeleton.getEquipment().setChestplate(chestplate);
					skeleton.getEquipment().setHelmet(helmet);
					skeleton.getEquipment().setItemInMainHand(mainhand);
					skeleton.getEquipment().setItemInOffHand(offhand);
					adder.SkeletonAdd(skeleton, player);
					if(mainhand.equals(stacks.Mainhand())){
						skeleton.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
					}
					if(offhand.equals(stacks.Offhand())){
						skeleton.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
					}
					if(helmet.equals(stacks.Helmet())){
						skeleton.getEquipment().setHelmet(new ItemStack(Material.AIR));
					}
					break;
				case "Spider":
					Spider spider = (Spider) world.spawnEntity(loc, EntityType.SPIDER);
					spider.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					spider.setCustomNameVisible(true);
					spider.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					spider.setHealth(spider.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						spider.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						spider.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						spider.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						spider.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					//Set equipment
					spider.getEquipment().setBoots(boots);
					spider.getEquipment().setLeggings(leggings);
					spider.getEquipment().setChestplate(chestplate);
					spider.getEquipment().setHelmet(helmet);
					spider.getEquipment().setItemInMainHand(mainhand);
					spider.getEquipment().setItemInOffHand(offhand);
					break;
				case "Pigman":
					getVersion();
					if(sversion.contains("16")) {
						Piglin pigman = (Piglin) world.spawnEntity(loc, EntityType.PIGLIN);
						pigman.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
						pigman.setCustomNameVisible(true);
						pigman.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
						pigman.setHealth(pigman.getMaxHealth());
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
						}
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
						}
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
						}
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
						}
						if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobBaby")){
							pigman.setBaby();
						}
						//Set equipment
						data.reloadConfig();
						pigman.getEquipment().setBoots(boots);
						pigman.getEquipment().setLeggings(leggings);
						pigman.getEquipment().setChestplate(chestplate);
						pigman.getEquipment().setHelmet(helmet);
						pigman.getEquipment().setItemInMainHand(mainhand);
						pigman.getEquipment().setItemInOffHand(offhand);
						adder.PiglinAdd(pigman, player);
						if(mainhand.equals(stacks.Mainhand())){
							pigman.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
						}
						if(offhand.equals(stacks.Offhand())){
							pigman.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
						}
						if(helmet.equals(stacks.Helmet())){
							pigman.getEquipment().setHelmet(new ItemStack(Material.AIR));
						}
					}else{
						PigZombie pigman = (PigZombie) world.spawnEntity(loc, EntityType.valueOf("PIG_ZOMBIE"));
						pigman.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
						pigman.setCustomNameVisible(true);
						pigman.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
						pigman.setHealth(pigman.getMaxHealth());
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
						}
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
						}
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
						}
						if (this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")) {
							pigman.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
						}
						if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobBaby")){
							pigman.setBaby();
						}
						//Set equipment
						data.reloadConfig();
						pigman.getEquipment().setBoots(boots);
						pigman.getEquipment().setLeggings(leggings);
						pigman.getEquipment().setChestplate(chestplate);
						pigman.getEquipment().setHelmet(helmet);
						pigman.getEquipment().setItemInMainHand(mainhand);
						pigman.getEquipment().setItemInOffHand(offhand);
						adder.PigmanAdd(pigman, player);
						if(mainhand.equals(stacks.Mainhand())){
							pigman.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
						}
						if(offhand.equals(stacks.Offhand())){
							pigman.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
						}
						if(helmet.equals(stacks.Helmet())){
							pigman.getEquipment().setHelmet(new ItemStack(Material.AIR));
						}
					}
					break;
				case "Enderman":
					Enderman enderman = (Enderman) world.spawnEntity(loc, EntityType.ENDERMAN);
					enderman.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					enderman.setCustomNameVisible(true);
					enderman.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					enderman.setHealth(enderman.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						enderman.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						enderman.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						enderman.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						enderman.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					//Set equipment
					enderman.getEquipment().setItemInMainHand(mainhand);
					break;
				case "Wither Skeleton":
					WitherSkeleton Wskeleton = (WitherSkeleton) world.spawnEntity(loc, EntityType.WITHER_SKELETON);
					Wskeleton.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					Wskeleton.setCustomNameVisible(true);
					Wskeleton.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					Wskeleton.setHealth(Wskeleton.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						Wskeleton.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						Wskeleton.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						Wskeleton.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						Wskeleton.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					//Set equipment
					data.reloadConfig();
					Wskeleton.getEquipment().setBoots(boots);
					Wskeleton.getEquipment().setLeggings(leggings);
					Wskeleton.getEquipment().setChestplate(chestplate);
					Wskeleton.getEquipment().setHelmet(helmet);
					Wskeleton.getEquipment().setItemInMainHand(mainhand);
					Wskeleton.getEquipment().setItemInOffHand(offhand);
					adder.WitherSkeletonAdd(Wskeleton, player);
					if(mainhand.equals(stacks.Mainhand())){
						Wskeleton.getEquipment().setItemInMainHand(new ItemStack(Material.AIR));
					}
					if(offhand.equals(stacks.Offhand())){
						Wskeleton.getEquipment().setItemInOffHand(new ItemStack(Material.AIR));
					}
					if(helmet.equals(stacks.Helmet())){
					    Wskeleton.getEquipment().setHelmet(new ItemStack(Material.AIR));
				    }

					break;
				case "Witch":
					Witch witch = (Witch) world.spawnEntity(loc, EntityType.WITCH);
					witch.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					witch.setCustomNameVisible(true);
					witch.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					witch.setHealth(witch.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						witch.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						witch.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						witch.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						witch.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					break;
				case "Blaze":
					Blaze blaze = (Blaze) world.spawnEntity(loc, EntityType.BLAZE);
					blaze.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					blaze.setCustomNameVisible(true);
					blaze.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					blaze.setHealth(blaze.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						blaze.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						blaze.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						blaze.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						blaze.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					break;
				case "Creeper":
					Creeper creeper = (Creeper) world.spawnEntity(loc, EntityType.CREEPER);
					creeper.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					creeper.setCustomNameVisible(true);
					creeper.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					creeper.setHealth(creeper.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						creeper.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						creeper.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						creeper.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						creeper.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					break;
				case "Guardian":
					Guardian guardian = (Guardian) world.spawnEntity(loc, EntityType.GUARDIAN);
					guardian.setCustomName(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName"));
					guardian.setCustomNameVisible(true);
					guardian.setMaxHealth(this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth"));
					guardian.setHealth(guardian.getMaxHealth());
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")){
						guardian.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")){
						guardian.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")){
						guardian.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat")));
					}
					if(this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")){
						guardian.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, max, this.data.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat")));
					}
					break;
				default:
					player.sendMessage("§cYou haven't picked a mob yet!");
					break;

			}
		}	
		}
		}

	}
}
