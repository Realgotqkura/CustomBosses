package com.realgotqkura.GUIs;

import com.realgotqkura.CBossItemStacks.PotionGUIItems;
import com.realgotqkura.CBossUtils.GUISorting;
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

public class CBPotionsGUI implements Listener {
    public Inventory potionsInv;
    private CustomConfig_1 data;
    main plugin;
    public CBPotionsGUI(CustomConfig_1 data, main plugin){ this.data = data; this.plugin = plugin;}


    private GUISorting sort = new GUISorting(plugin);
    private PotionGUIItems pots = new PotionGUIItems();



    public void createPotInv(){
        potionsInv = Bukkit.createInventory(null, 45, ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "PotionsInventory");
        sort.GetOuter(potionsInv, 45, true);
        potionsInv.setItem(10, pots.SpeedPotion());
        potionsInv.setItem(11, pots.StrengthPot());
        potionsInv.setItem(12, pots.WeaknessPot());
        potionsInv.setItem(13, pots.SlownessPot());
        //slot 10 -starts

    }

    @EventHandler
    public void InvClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        CustomConfig_1 d = new CustomConfig_1(plugin);
        if (!event.getView().getTitle().contains("PotionsInventory")) {
            return;
        }

        event.setCancelled(true);
        //Slots
        if (event.getSlot() == 10) {
            if (!d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")) {
                player.sendMessage(ChatColor.GREEN + "Speed has been enabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Speed", true);
                d.saveConfig();
            } else {
                player.sendMessage(ChatColor.GREEN + "Speed has been disabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Speed", false);
                d.saveConfig();
            }


            if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed")) {
                player.sendMessage(ChatColor.GREEN + "Set a level of speed!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL", true);
                d.saveConfig();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.closeInventory();
                        cancel();
                    }
                }.runTaskLater(plugin, 1);
            }
        }
        if (event.getSlot() == 11) {
            if (!d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")) {
                player.sendMessage(ChatColor.GREEN + "Strength has been enabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Strength", true);
                d.saveConfig();
            } else {
                player.sendMessage(ChatColor.GREEN + "Strength has been disabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Strength", false);
                d.saveConfig();
            }

            if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength")) {
                player.sendMessage(ChatColor.GREEN + "Set a level of strength!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChatLVL", true);
                d.saveConfig();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.closeInventory();
                        cancel();
                    }
                }.runTaskLater(plugin, 1);
            }
        }
        if (event.getSlot() == 12) {
            if (!d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")) {
                player.sendMessage(ChatColor.GREEN + "Weakness has been enabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Weakness", true);
                d.saveConfig();
            } else {
                player.sendMessage(ChatColor.GREEN + "Weakness has been disabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Weakness", false);
                d.saveConfig();
            }

            if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness")) {
                player.sendMessage(ChatColor.GREEN + "Set a level of weakness!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChatLVL", true);
                d.saveConfig();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.closeInventory();
                        cancel();
                    }
                }.runTaskLater(plugin, 1);
            }
        }
        if(event.getSlot() == 13){
            if (!d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")) {
                player.sendMessage(ChatColor.GREEN + "Slowness has been enabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Slowness", true);
                d.saveConfig();
            } else {
                player.sendMessage(ChatColor.GREEN + "Slowness has been disabled!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Slowness", false);
                d.saveConfig();
            }

            if (d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness")) {
                player.sendMessage(ChatColor.GREEN + "Set a level of slowness!");
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChatLVL", true);
                d.saveConfig();
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        player.closeInventory();
                        cancel();
                    }
                }.runTaskLater(plugin, 1);
            }
        }


    }

    @EventHandler
    public void ChatSpeed(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        CustomConfig_1 d = new CustomConfig_1(plugin);
            if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL")){
                event.setCancelled(true);
               try{
                   int num = Integer.parseInt(event.getMessage());
                   player.sendMessage(ChatColor.GREEN + "Successfully added the level!");
                   d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                   d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat", num);
                   d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL", false);
                   d.saveConfig();
                   return;

               }catch(NumberFormatException e){
                   player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                   d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                   d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL", false);
                   d.saveConfig();
                   return;
               }

            }else if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_StrengthChatLVL")){
                event.setCancelled(true);
                try{
                    int num = Integer.parseInt(event.getMessage());
                    player.sendMessage(ChatColor.GREEN + "Successfully added the level!");
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat", num);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChatLVL", false);
                    d.saveConfig();
                    return;
                }catch(NumberFormatException e){
                    player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL", false);
                    d.saveConfig();
                    return;
                }

            }else if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChatLVL")) {
                event.setCancelled(true);
                try {
                    int num = Integer.parseInt(event.getMessage());
                    player.sendMessage(ChatColor.GREEN + "Successfully added the level!");
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat", num);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChatLVL", false);
                    d.saveConfig();
                    return;
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChatLVL", false);
                    d.saveConfig();
                    return;
                }

            }else if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_SlownessChatLVL")) {
                event.setCancelled(true);
                try {
                    int num = Integer.parseInt(event.getMessage());
                    player.sendMessage(ChatColor.GREEN + "Successfully added the level!");
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat", num);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChatLVL", false);
                    d.saveConfig();
                    return;
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Your message contains letters or symbols!");
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChatLVL", false);
                    d.saveConfig();
                    return;
                }

            }
    }

}
