package CBossItemStacks;

import java.util.ArrayList;
import java.util.List;

import CBossUtils.RandomUtils;
import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.json.simple.JSONArray;

public class GUI_Items {
	
	
	private main plugin;
	public GUI_Items(main plugin){
		this.plugin = plugin;
	}
	
	
	public ItemStack GUIglassDark() {
		ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.BLACK + ".");
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack GUIglass() {
		ItemStack glass = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
		ItemMeta meta = glass.getItemMeta();
		meta.setDisplayName(ChatColor.BLACK + ".");
		glass.setItemMeta(meta);
		return glass;
	}
	public ItemStack GUIClose() {
		ItemStack close = new ItemStack(Material.BARRIER);
		ItemMeta meta = close.getItemMeta();
		meta.setDisplayName("§c§lClose Inventory");
		close.setItemMeta(meta);
		return close;
	}
	public ItemStack MakeBoss() {
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§e§lCreate Your Boss");
		meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack GetItem111() {
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§a§lSummon your boss");
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		meta.addEnchant(Enchantment.DURABILITY, 1, true);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack SetMobButton() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§2§lChoose a mob");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "None");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack Properties() {
		ItemStack item = new ItemStack(Material.COMMAND_BLOCK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§b§lMob Properties");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack Potions(){
		ItemStack item = new ItemStack(Material.POTION);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5§lAdd Potion Effects");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Add potion effects to your boss!");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack ArmorAndHand(){
		ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&b&lWeapons and Armour"));
		List<String> lore = new ArrayList<String>();
		lore.add(RandomUtils.color("&7set the equipment of the mobs!"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack PolishedAndCheck(){
		ItemStack item = new ItemStack(Material.POLISHED_DIORITE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&7&lWeapons and Armour"));
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack DropChance(){
		ItemStack item = new ItemStack(Material.REDSTONE_TORCH);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&c&lDrop Chance"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7Change your mobs drop chance"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	//Spawn items GUI

	public static ItemStack GiveStick(){
		ItemStack item = new ItemStack(Material.STICK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&cSpawning tool"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7Spawn your mob using a tool"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack NaturallySpawn(){
		ItemStack item = new ItemStack(Material.GRASS_BLOCK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&a&lNaturally Spawn"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7Spawn your mob naturally"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack SelectTime(Player player){
		CustomConfig_1 data = new CustomConfig_1(plugin);
		ItemStack item = new ItemStack(Material.CLOCK);
		ItemMeta meta = item.getItemMeta();
		assert meta != null;
		meta.setDisplayName(RandomUtils.color("&e&lSpawning Period"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7This setting allows you to set"));
		lore.add(RandomUtils.color("&7The period between mob spawns"));
		try {
			lore.add(RandomUtils.color("&7Current Time: &a" + data.getConfig().getInt("NaturalSpawning.NaturalTime") + "s"));
		}catch(NullPointerException e){
			lore.add(RandomUtils.color("&7Current Time: &a10s"));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack SpawnRate(Player player){
		CustomConfig_1 data = new CustomConfig_1(plugin);
		ItemStack item = new ItemStack(Material.ZOMBIE_SPAWN_EGG);
		ItemMeta meta = item.getItemMeta();
		assert meta != null;
		meta.setDisplayName(RandomUtils.color("&e&lSpawn Rate"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7This setting allows you to set"));
		lore.add(RandomUtils.color("&7The amount of mobs spawn per player."));
		lore.add(RandomUtils.color("&7(More than 3 might be performance heavy"));
		lore.add(RandomUtils.color("&7in a server with alot of players"));
		try {
			lore.add(RandomUtils.color("&7Current Mobs: &a" + data.getConfig().getInt("NaturalSpawning.MobsChunkSpawn")));
		}catch(NullPointerException e){
			lore.add(RandomUtils.color("&7Current Mobs: &a1"));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack PlayerMob(Player player){
		CustomConfig_1 data = new CustomConfig_1(plugin);
		ItemStack item = new ItemStack(Material.PLAYER_HEAD);
		ItemMeta meta = item.getItemMeta();
		assert meta != null;
		meta.setDisplayName(RandomUtils.color("&3&lSet players Mob"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7This setting allows you to set"));
		lore.add(RandomUtils.color("&7What mob spawns. Just put the name"));
		lore.add(RandomUtils.color("&7Of the player you want to use. (Make sure"));
		lore.add(RandomUtils.color("&7you have a player that has a mob or it will not work)"));
		lore.add("");
		lore.add(RandomUtils.color("&c&lDOESNT &7have to be an online player."));
		try {
			lore.add(RandomUtils.color("&7Using &a" + data.getConfig().getString("NaturalSpawning.PlayerMob") + "'s Mob"));
		}catch(NullPointerException e){
			lore.add(RandomUtils.color("&7Using &aNoones &7Mob"));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack NaturalSpawnActivation(Player player){
		CustomConfig_1 data = new CustomConfig_1(plugin);
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		assert meta != null;
		meta.setDisplayName(RandomUtils.color("&5&lActivate Natural Spawning"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7Activate Natural Spawning on your world."));
		try {
			lore.add(RandomUtils.color("&7Activated: &a" + data.getConfig().getBoolean("NaturalSpawning.Spawn_Naturally")));
		}catch(NullPointerException e){
			lore.add(RandomUtils.color("&7Activated: &afalse"));
		}
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack WorldPicker(){
		ItemStack item = new ItemStack(Material.STONE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&a&lPick Your World"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&cNOTE &7Functionality of this feature is limited."));
		lore.add(RandomUtils.color("&for a bit you will only be able to set it for 1 world"));
		lore.add(RandomUtils.color("&7in the next update i will change that."));
		lore.add("");
		lore.add(RandomUtils.color("&7Click to set the world to the current"));
		lore.add(RandomUtils.color("&7world you are in."));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}


	
	
}
