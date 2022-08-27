package com.realgotqkura.GUIs;

import com.realgotqkura.CBossItemStacks.DropChanceItems;
import com.realgotqkura.CBossUtils.GUISorting;
import com.realgotqkura.CBossUtils.RandomUtils;
import com.realgotqkura.DataManager.CustomConfig_1;
import CBossesMain.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

public class DropChanceGUI implements Listener {

    public Inventory dropChanceInv;
    private CustomConfig_1 data;
    private main plugin;

    public DropChanceGUI(CustomConfig_1 data, main plugin){
        this.data = data;
        this.plugin = plugin;
    }

    public void createdropChanceInv(){
        dropChanceInv = Bukkit.createInventory(null, 9, RandomUtils.color("&9Drop Chance"));
        GUISorting sorting = new GUISorting(plugin);
        sorting.GetInner(dropChanceInv, 9);

        dropChanceInv.setItem(1, DropChanceItems.DPHelmet());
        dropChanceInv.setItem(2, DropChanceItems.DPChestPlate());
        dropChanceInv.setItem(3, DropChanceItems.DPLeggings());
        dropChanceInv.setItem(4, DropChanceItems.DPBoots());
        dropChanceInv.setItem(6, DropChanceItems.DPMain());
        dropChanceInv.setItem(7, DropChanceItems.DPOff());
    }


    @EventHandler
    public void Click(InventoryClickEvent event){
        if(!event.getView().getTitle().equals(RandomUtils.color("&9Drop Chance"))){
            return;
        }

        event.setCancelled(true);
        CustomConfig_1 data = new CustomConfig_1(plugin);
        Player player = (Player) event.getWhoClicked();
        if(event.getSlot() == 1){
            data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
            data.getConfig().set("players." + player.getUniqueId().toString() + ".HelmetDPChat", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSet the drop chance!"));
            new BukkitRunnable() {

                @Override
                public void run() {
                    player.closeInventory();
                    cancel();
                }

            }.runTaskLater(plugin, 1);
        }
        else if(event.getSlot() == 2){
            data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
            data.getConfig().set("players." + player.getUniqueId().toString() + ".ChestPlateDPChat", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSet the drop chance!"));
            new BukkitRunnable() {

                @Override
                public void run() {
                    player.closeInventory();
                    cancel();
                }

            }.runTaskLater(plugin, 1);
            return;
        }
        else if(event.getSlot() == 3){
            data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
            data.getConfig().set("players." + player.getUniqueId().toString() + ".LeggingsDPChat", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSet the drop chance!"));
            new BukkitRunnable() {

                @Override
                public void run() {
                    player.closeInventory();
                    cancel();
                }

            }.runTaskLater(plugin, 1);
            return;
        }
        else if(event.getSlot() == 4){
            data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
            data.getConfig().set("players." + player.getUniqueId().toString() + ".BootsDPChat", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSet the drop chance!"));
            new BukkitRunnable() {

                @Override
                public void run() {
                    player.closeInventory();
                    cancel();
                }

            }.runTaskLater(plugin, 1);
            return;
        }
       else if(event.getSlot() == 6){
            data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
            data.getConfig().set("players." + player.getUniqueId().toString() + ".MainDPChat", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSet the drop chance!"));
            new BukkitRunnable() {

                @Override
                public void run() {
                    player.closeInventory();
                    cancel();
                }

            }.runTaskLater(plugin, 1);
            return;
        }
        else if(event.getSlot() == 7){
            data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
            data.getConfig().set("players." + player.getUniqueId().toString() + ".OffDPChat", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSet the drop chance!"));
            new BukkitRunnable() {

                @Override
                public void run() {
                    player.closeInventory();
                    cancel();
                }

            }.runTaskLater(plugin, 1);
            return;
        }
    }

    @EventHandler
    public void ChatSpeed(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        CustomConfig_1 d = new CustomConfig_1(plugin);
        d.reloadConfig();
        if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".HelmetDPChat")) {
            event.setCancelled(true);
            try {
                double num = Double.parseDouble(event.getMessage());
                player.sendMessage(ChatColor.GREEN + "Successfully added the chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".Helmet_DP", num);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".HelmetDPChat", false);
                d.saveConfig();
                return;

            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".HelmetDPChat", false);
                d.saveConfig();
                return;
            }

        } else if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".ChestPlateDPChat")) {
            event.setCancelled(true);
            try {
                double num = Double.parseDouble(event.getMessage());
                player.sendMessage(ChatColor.GREEN + "Successfully added the chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".ChestPlate_DP", num);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".ChestPlateDPChat", false);
                d.saveConfig();
                return;
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".ChestPlateDPChat", false);
                d.saveConfig();
                return;
            }

        } else if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".LeggingsDPChat")) {
            event.setCancelled(true);
            try {
                double num = Double.parseDouble(event.getMessage());
                player.sendMessage(ChatColor.GREEN + "Successfully added the chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".Leggings_DP", num);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".LeggingsDPChat", false);
                d.saveConfig();
                return;
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Your message contains letters or chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".LeggingsDPChat", false);
                d.saveConfig();
                return;
            }

        } else if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".BootsDPChat")) {
            event.setCancelled(true);
            try {
                double num = Double.parseDouble(event.getMessage());
                player.sendMessage(ChatColor.GREEN + "Successfully added the chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".Boots_DP", num);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".BootsDPChat", false);
                d.saveConfig();
                return;
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".BootsDPChat", false);
                d.saveConfig();
                return;
            }

        } else if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MainDPChat")) {
            event.setCancelled(true);
            try {
                double num = Double.parseDouble(event.getMessage());
                player.sendMessage(ChatColor.GREEN + "Successfully added the chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".Main_DP", num);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MainDPChat", false);
                d.saveConfig();
                return;
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MainDPChat", false);
                d.saveConfig();
                return;
            }

        } else if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".OffDPChat")) {
            event.setCancelled(true);
            try {
                double num = Double.parseDouble(event.getMessage());
                player.sendMessage(ChatColor.GREEN + "Successfully added the chance!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".Off_DP", num);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".OffDPChat", false);
                d.saveConfig();
                return;
            } catch (NumberFormatException e) {
                player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".OffDPChat", false);
                d.saveConfig();
                return;
            }

        }
    }
}
