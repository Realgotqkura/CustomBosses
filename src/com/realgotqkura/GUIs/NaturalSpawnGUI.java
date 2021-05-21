package com.realgotqkura.GUIs;


import com.realgotqkura.CBossUtils.RandomUtils;
import com.realgotqkura.CBossItemStacks.GUI_Items;
import com.realgotqkura.DataManager.CustomConfig_1;

import CBossesMain.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;
import java.util.Objects;


public class NaturalSpawnGUI implements Listener {

    private int time;
    public Inventory gui;

    private final CustomConfig_1 data;
    private final main plugin;

    public NaturalSpawnGUI(CustomConfig_1 data, main plugin){
        this.data = data;
        this.plugin = plugin;
    }


    public void createInv(Player player){
        GUI_Items items = new GUI_Items(plugin);
        gui = Bukkit.createInventory(null, 18, "Natural Spawning Settings");
        gui.setItem(1, items.SelectTime(player));
        gui.setItem(3, items.SpawnRate(player));
        gui.setItem(5, items.PlayerMob(player));
        gui.setItem(7, items.WorldPicker());
        gui.setItem(13, items.NaturalSpawnActivation(player));
        gui.setItem(11, items.SafetyMode(player));
        gui.setItem(15, items.DaySpawning(player));
        gui.setItem(17, items.Info());

        player.openInventory(gui);
    }

    @EventHandler()
    public void onClick(InventoryClickEvent event){
        GUI_Items items = new GUI_Items(plugin);
        if(!event.getView().getTitle().equals("Natural Spawning Settings") && !Objects.equals(event.getView().getItem(7), items.WorldPicker())){
            return;
        }

        Player player = (Player) event.getWhoClicked();
        event.setCancelled(true);
        if(event.getSlot() == 1){
            data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", true);
            data.getConfig().set("NaturalSpawning.NaturalTyping", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aChoose a period between spawns (in seconds)!"));
            player.closeInventory();

        }else if(event.getSlot() == 3){
            data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", true);
            data.getConfig().set("NaturalSpawning.MobsChunkSpawnTyping", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aChoose the amount of mobs to spawn!"));
            player.closeInventory();
        }else if(event.getSlot() == 5){
            data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", true);
            data.getConfig().set("NaturalSpawning.PlayerMobTyping", true);
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aChoose the player you want to use!"));
            player.closeInventory();
        }else if(event.getSlot() == 7){
            data.getConfig().set("NaturalSpawning.NaturalSpawnWorld", player.getWorld().getName());
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aSuccessfully added the world!"));
        }else if(event.getSlot() == 13){
            if(data.getConfig().getBoolean("NaturalSpawning.Spawn_Naturally")){
                data.getConfig().set("NaturalSpawning.Spawn_Naturally", false);
                player.sendMessage(RandomUtils.color("&aNatural Spawning has been deactivated!"));
            }else{
                data.getConfig().set("NaturalSpawning.Spawn_Naturally", true);
                player.sendMessage(RandomUtils.color("&aNatural Spawning is now activated!"));
            }
            data.saveConfig();
            player.closeInventory();
        }else if(event.getSlot() == 11){
            if(data.getConfig().getBoolean("NaturalSpawning.SafetyMode")){
                data.getConfig().set("NaturalSpawning.SafetyMode", false);
                player.sendMessage(RandomUtils.color("&aSafety Mode has been deactivated!"));
            }else{
                data.getConfig().set("NaturalSpawning.SafetyMode", true);
                player.sendMessage(RandomUtils.color("&aSafety Mode is now activated!"));
            }
            data.saveConfig();
            player.closeInventory();
        }else if(event.getSlot() == 15){
            if(data.getConfig().getBoolean("NaturalSpawning.DaySpawn")){
                data.getConfig().set("NaturalSpawning.DaySpawn", false);
                player.sendMessage(RandomUtils.color("&aDay Spawning has been deactivated!"));
            }else{
                data.getConfig().set("NaturalSpawning.DaySpawn", true);
                player.sendMessage(RandomUtils.color("&aDay Spawning is now activated!"));
            }
            data.saveConfig();
            player.closeInventory();
        }
    }

    @EventHandler
    public void onChatTimer(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(!this.data.getConfig().getBoolean("NaturalSpawning.NaturalTyping"))
            return;

        event.setCancelled(true);

        int name;
        try {
            name = Integer.parseInt(event.getMessage());
        }catch(NumberFormatException e){
           player.sendMessage(RandomUtils.color("&cIt must be a number >:(, set it to the default value (30)."));
           name = 30;
        }
        if(name < 30){
            if(data.getConfig().getBoolean("NaturalSpawning.SafetyMode")) {
                player.sendMessage(RandomUtils.color("&4&lSAFETY MODE: &cThis is way bellow the minimum delay. Setting"));
                player.sendMessage(RandomUtils.color("&cit to the minimum value(30)"));
                player.sendMessage(RandomUtils.color("&cIf you want to disable this feature go to the Natural spawn GUI"));
                name = 30;
                data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
                data.getConfig().set("NaturalSpawning.NaturalTime", name);
                data.getConfig().set("NaturalSpawning.NaturalTyping", false);
                data.saveConfig();
                return;
            }
        }
        data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
        data.getConfig().set("NaturalSpawning.NaturalTime", name);
        data.getConfig().set("NaturalSpawning.NaturalTyping", false);
        data.saveConfig();
        player.sendMessage(RandomUtils.color("&aSuccessfully changed the spawn delay!"));
    }

    @EventHandler
    public void onChatMobs(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(!this.data.getConfig().getBoolean("NaturalSpawning.MobsChunkSpawnTyping"))
            return;

        event.setCancelled(true);

        int name;
        try {
            name = Integer.parseInt(event.getMessage());
        }catch(NumberFormatException e){
            player.sendMessage(RandomUtils.color("&cIt must be a number >:(, set it to the default value (1)."));
            name = 1;
        }
        if(name > 30){
            if(!data.getConfig().getBoolean("NaturalSpawning.SafetyMode")) {
                data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
                data.getConfig().set("NaturalSpawning.MobsChunkSpawn", name);
                data.getConfig().set("NaturalSpawning.MobsChunkSpawnTyping", false);
                data.saveConfig();
                player.sendMessage(RandomUtils.color("&aSuccessfully changed the amount of mobs!"));
                return;
            }
            player.sendMessage(RandomUtils.color("&4&lSAFETY MODE: &cThis is way above the maximum amount. Setting"));
            player.sendMessage(RandomUtils.color("&cit to the minimum value(30)"));
            player.sendMessage(RandomUtils.color("&cIf you want to disable this feature go to the Natural spawn GUI"));
            name = 30;
            data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
            data.getConfig().set("NaturalSpawning.MobsChunkSpawn", name);
            data.getConfig().set("NaturalSpawning.MobsChunkSpawnTyping", false);
            data.saveConfig();
            return;
        }
        data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
        data.getConfig().set("NaturalSpawning.MobsChunkSpawn", name);
        data.getConfig().set("NaturalSpawning.MobsChunkSpawnTyping", false);
        data.saveConfig();
        player.sendMessage(RandomUtils.color("&aSuccessfully changed the amount of mobs!"));

    }

    @EventHandler
    public void onChatPlayer(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(!this.data.getConfig().getBoolean("NaturalSpawning.PlayerMobTyping"))
            return;

        event.setCancelled(true);

        String name = event.getMessage();
        data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
        data.getConfig().set("NaturalSpawning.PlayerMob", name);
        data.getConfig().set("NaturalSpawning.PlayerMobTyping", false);
        data.saveConfig();
        player.sendMessage(RandomUtils.color("&aSuccessfully changed the player!"));

    }
}
