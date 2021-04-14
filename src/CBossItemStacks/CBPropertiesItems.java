package CBossItemStacks;

import CBossUtils.RandomUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CBPropertiesItems {

	
	public ItemStack Name() {
		ItemStack item = new ItemStack(Material.ITEM_FRAME);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§9§lMob Name");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Select your mobs name");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack Health(){
		ItemStack item = new ItemStack(Material.APPLE);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName("§c§lMob Health");
		List<String> lore = new ArrayList<String>();
		lore.add("§7Select your mobs health");
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}

	public ItemStack Baby(){
		ItemStack item = new ItemStack(Material.CLOCK);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(RandomUtils.color("&e&lSet Baby"));
		List<String> lore = new ArrayList<String>();
		lore.add(RandomUtils.color("&7Set your mob to a baby"));
		meta.setLore(lore);
		item.setItemMeta(meta);
		return item;
	}
}
