package com.realgotqkura.CustomBosses_Events;

import com.realgotqkura.DataManager.CustomConfig_1;
import CBossesMain.main;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class NaturalSpawning_Event implements Listener {

    CustomConfig_1 data;
    main plugin;

    public NaturalSpawning_Event(main plugin, CustomConfig_1 data) {
        this.plugin = plugin;
        this.data = data;
    }

    public boolean day(World world) {
        long time = world.getTime();
        return time < 12300 || time > 23850;
    }

    public void SpawnMobs(CustomConfig_1 data, main plugin) {
        OfflinePlayer player1;
        try {
            player1 = Bukkit.getOfflinePlayer(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.PlayerMob")));
        } catch (NullPointerException e) {
            System.out.println("You wont be able to spawn a mob if the player hasn't joined or doesn't exist.");
            return;
        }
        if (data.getConfig().getInt("NaturalSpawning.NaturalTime") == 0) {
            System.out.println("0 second delay is not allowed");
            return;
        }
        new BukkitRunnable() {

            OfflinePlayer player1;
            @Override
            public void run() {
                try {
                    player1 = Bukkit.getOfflinePlayer(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.PlayerMob")));
                } catch (NullPointerException e) {
                    System.out.println("You wont be able to spawn a mob if the player hasn't joined or doesn't exist.");
                    return;
                }
                if (data.getConfig().getBoolean("NaturalSpawning.Spawn_Naturally")) {
                    if (data.getConfig().getInt("NaturalSpawning.MobsChunkSpawn") > 0) {
                       if(day(Objects.requireNonNull(Bukkit.getWorld(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.NaturalSpawnWorld")))))){
                           if(data.getConfig().getBoolean("NaturalSpawning.DaySpawn")){
                               data.reloadConfig();
                               for(Player player : Bukkit.getOnlinePlayers()){
                                   Location ploc = player.getLocation();
                                   for(int i = 0; i <= data.getConfig().getInt("NaturalSpawning.MobsChunkSpawn"); i++){
                                       int randomx = ThreadLocalRandom.current().nextInt(-200,200 + 1);
                                       int randomz = ThreadLocalRandom.current().nextInt(-200,200 + 1);
                                       Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.NaturalSpawnWorld"))), ploc.getX() + randomx, ploc.getY(), ploc.getZ() + randomz);
                                       Location spawnloc = new Location(loc.getWorld(), Math.round(ploc.getX() + randomx), loc.getWorld().getHighestBlockYAt(loc) + 2, Math.round(ploc.getZ() + randomz));
                                       MobSpawnEvent spawn = new MobSpawnEvent(data, plugin);
                                       try {
                                           spawn.spawnMethod(data, plugin, player1.getUniqueId().toString(), data.getConfig().getString("NaturalSpawning.NaturalSpawnWorld"), spawnloc);
                                       }catch(Exception ignored){

                                       }
                                       //System.out.println(spawnloc.getX() + " " + spawnloc.getY() + " " + spawnloc.getZ() + " world: " + spawnloc.getWorld().getName());

                                   }
                               }
                           }
                       }else{
                           data.reloadConfig();
                           for(Player player : Bukkit.getOnlinePlayers()){
                               Location ploc = player.getLocation();
                               for(int i = 0; i <= data.getConfig().getInt("NaturalSpawning.MobsChunkSpawn"); i++){
                                   int randomx = ThreadLocalRandom.current().nextInt(-200,200 + 1);
                                   int randomz = ThreadLocalRandom.current().nextInt(-200,200 + 1);
                                   Location loc = new Location(Bukkit.getWorld(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.NaturalSpawnWorld"))), ploc.getX() + randomx, ploc.getY(), ploc.getZ() + randomz);
                                   Location spawnloc = new Location(loc.getWorld(), Math.round(ploc.getX() + randomx), loc.getWorld().getHighestBlockYAt(loc) + 2, Math.round(ploc.getZ() + randomz));
                                   MobSpawnEvent spawn = new MobSpawnEvent(data, plugin);
                                   spawn.spawnMethod(data, plugin, player1.getUniqueId().toString(), data.getConfig().getString("NaturalSpawning.NaturalSpawnWorld"), spawnloc);
                                   //System.out.println(spawnloc.getX() + " " + spawnloc.getY() + " " + spawnloc.getZ() + " world: " + spawnloc.getWorld().getName());

                               }
                           }
                       }
                    }
                }
            }

        }.runTaskTimer(plugin, 1, 20 * data.getConfig().getInt("NaturalSpawning.NaturalTime"));


    }
}
