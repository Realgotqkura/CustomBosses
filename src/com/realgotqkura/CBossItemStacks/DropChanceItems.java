package com.realgotqkura.CBossItemStacks;

import com.realgotqkura.CBossUtils.RandomUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class DropChanceItems {

    public static ItemStack DPChestPlate(){
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(RandomUtils.color("&b&lChestPlate Drop Chance"));
        List<String> lore = new ArrayList<>();
        lore.add(RandomUtils.color("&7Set the drop chance of the ChestPlate"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack DPLeggings() {
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(RandomUtils.color("&b&lLeggings Drop Chance"));
        List<String> lore = new ArrayList<>();
        lore.add(RandomUtils.color("&7Set the drop chance of the Leggings"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack DPBoots(){
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(RandomUtils.color("&b&lBoots Drop Chance"));
        List<String> lore = new ArrayList<>();
        lore.add(RandomUtils.color("&7Set the drop chance of the Boots"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack DPHelmet(){
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(RandomUtils.color("&b&lHelmet Drop Chance"));
        List<String> lore = new ArrayList<>();
        lore.add(RandomUtils.color("&7Set the drop chance of the Helmet"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack DPMain(){
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(RandomUtils.color("&b&lMain Hand Drop Chance"));
        List<String> lore = new ArrayList<>();
        lore.add(RandomUtils.color("&7Set the drop chance of the Main hand"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }

    public static ItemStack DPOff(){
        ItemStack item = new ItemStack(Material.DIAMOND_AXE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(RandomUtils.color("&b&lOff hand Drop Chance"));
        List<String> lore = new ArrayList<>();
        lore.add(RandomUtils.color("&7Set the drop chance of the Off hand"));
        meta.setLore(lore);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        return item;
    }


}
