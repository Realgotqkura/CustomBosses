package GUIs;


import CBossItemStacks.GUI_Items;
import CBossUtils.RandomUtils;
import DataManager.CustomConfig_1;

import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;


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

        player.openInventory(gui);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event){
        if(!event.getView().getTitle().equals("Natural Spawning Settings") && !RandomUtils.compareInventoryContents(
                event.getInventory(), gui
        )){
            System.out.println("EE");
            return;
        }
        System.out.println("E");

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
            player.sendMessage(RandomUtils.color("&aChoose the amount of mobs per chunk!"));
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
            }else{
                data.getConfig().set("NaturalSpawning.Spawn_Naturally", true);
            }
            data.saveConfig();
            player.sendMessage(RandomUtils.color("&aNatural Spawning is now activated!"));
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
           player.sendMessage(RandomUtils.color("&cIt must be a number >:(, set it to the default value (10)."));
           name = 10;
        }
        data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
        data.getConfig().set("NaturalSpawning.NaturalTime", name);
        data.getConfig().set("NaturalSpawning.NaturalTyping", false);
        data.saveConfig();
        player.sendMessage(RandomUtils.color("&aSuccessfully changed the amount of mobs!"));
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
        data.getConfig().set("players."+ player.getUniqueId().toString() +".TypingGeneral", false);
        data.getConfig().set("NaturalSpawning.MobsChunkSpawn", name);
        data.getConfig().set("NaturalSpawning.MobsChunkSpawnTyping", false);
        data.saveConfig();
        player.sendMessage(RandomUtils.color("&aSuccessfully changed the timer!"));

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
