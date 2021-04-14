package CBossItemStacks;



import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MobItemsGUI {

	private MobItemsGUIskulls MobSkulls = new MobItemsGUIskulls();
	
	public ItemStack ZombieItem() {
		ItemStack item = new ItemStack(Material.ZOMBIE_HEAD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§2Zombie Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack SkeletonItem() {
		ItemStack item = new ItemStack(Material.SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§7Skeleton Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack SpiderItem() {
		ItemStack item = MobSkulls.SpiderSkull();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§8Spider Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack PigmanItem() {
		ItemStack item = MobSkulls.PigmanSkull();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§dPigman Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack EndermanItem() {
		ItemStack item = MobSkulls.EndermanSkull();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§5Enderman Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack WitherSkItem() {
		ItemStack item = new ItemStack(Material.WITHER_SKELETON_SKULL);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§8Wither Skeleton Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack WitchItem() {
		ItemStack item = MobSkulls.WitchSkull();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§9Witch Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack BlazeItem() {
		ItemStack item = MobSkulls.BlazeSkull();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§6Blaze Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack CreeperItem() {
		ItemStack item = new ItemStack(Material.CREEPER_HEAD);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§aCreeper Mob");
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack GuardianItem() {
		ItemStack item = MobSkulls.GuardianSkull();
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§bGuardian Mob");
		item.setItemMeta(meta);
		return item;
	}
}
