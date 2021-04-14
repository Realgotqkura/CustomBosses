package CBossItemStacks;

import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;

import java.util.ArrayList;
import java.util.List;

public class PotionGUIItems {

    

    public ItemStack SpeedPotion(){
        ItemStack speed = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta)speed.getItemMeta();
        meta.setColor(Color.AQUA);
        meta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Speed Potion");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Add speed to your mob");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        speed.setItemMeta(meta);
        return speed;
    }

    public ItemStack StrengthPot(){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta)item.getItemMeta();
        meta.setColor(Color.RED);
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Strength Potion");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Add strength to your mob");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack WeaknessPot(){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta)item.getItemMeta();
        meta.setColor(Color.NAVY);
        meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Weakness Potion");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Add weakness to your mob");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }

    public ItemStack SlownessPot(){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta)item.getItemMeta();
        meta.setColor(Color.GRAY);
        meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Slowness Potion");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "Add slowness to your mob");
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
