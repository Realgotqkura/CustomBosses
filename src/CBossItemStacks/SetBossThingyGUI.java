package CBossItemStacks;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetBossThingyGUI {

	public ItemStack Default() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cNone");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack ZombieBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cZombie");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack SkeletonBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cSkeleton");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;	
	}
	public ItemStack SpiderBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cSpider");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack PigmanBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cPigman");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack EndermanBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cEnderman");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack WitherSkelBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cWither Skeleton");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack WitchBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cWitch");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack BlazeBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cBlaze");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack CreeperBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cCreeper");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack GuardianBar() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		List<String> lore = new ArrayList<String>();
		lore.add("§7Currently Selected:§c " + "§cGuardian");
		meta.setDisplayName("§2§lChoose a mob");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
}
