package CBossItemStacks;

import java.util.ArrayList;
import java.util.List;

import CBossUtils.RandomUtils;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;
import org.json.simple.JSONArray;

public class GUI_Items {
	
	
	
	
	
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

	public static ItemStack SelectTime(){
		ItemStack item = new ItemStack(Material.CLOCK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&e&lSpawning Period"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7This setting allows you to set"));
		lore.add(RandomUtils.color("&7The period between mob spawns"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public static ItemStack SpawnRate(){
		ItemStack item = new ItemStack(Material.);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&e&lSpawn Rate"));
		List<String> lore = new ArrayList<>();
		lore.add(RandomUtils.color("&7This setting allows you to set"));
		lore.add(RandomUtils.color("&7The period between mob spawns"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	
	
}
