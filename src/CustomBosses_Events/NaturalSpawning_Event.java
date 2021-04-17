package CustomBosses_Events;

import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
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


    public void SpawnMobs(CustomConfig_1 data, main plugin) {
        OfflinePlayer player;
        World world;
        try {
            player = Bukkit.getOfflinePlayer(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.PlayerMob")));
        } catch (NullPointerException e) {
            System.out.println("You wont be able to spawn a mob if the player hasn't joined or doesn't exist.");
            return;
        }
        try {
            world = Bukkit.getWorld(Objects.requireNonNull(data.getConfig().getString("NaturalSpawning.NaturalSpawnWorld")));
        } catch (NullPointerException e) {
            System.out.println("No such world exists");
            return;
        }
        if (data.getConfig().getInt("NaturalSpawning.NaturalTime") == 0) {
            System.out.println("0 second delay is not allowed");
            return;
        }
        assert world != null;
        List<Chunk> chunks = Arrays.asList(world.getLoadedChunks());
        new BukkitRunnable() {

            @Override
            public void run() {
                if (data.getConfig().getBoolean("NaturalSpawning.Spawn_Naturally")) {
                    if (data.getConfig().getInt("NaturalSpawning.MobsChunkSpawn") > 0) {
                        data.reloadConfig();
                        System.out.println("E");
                        for(Player player : Bukkit.getOnlinePlayers()){
                            Location ploc = player.getLocation();
                            for(int i = 0; i <= data.getConfig().getInt("NaturalSpawning.MobsChunkSpawn"); i++){
                                int randomx = ThreadLocalRandom.current().nextInt(-200,200 + 1);
                                int randomz = ThreadLocalRandom.current().nextInt(-200,200 + 1);
                                Location loc = new Location(world, ploc.getX() + randomx, ploc.getY(), ploc.getZ() + randomz);
                                Location spawnloc = new Location(world, Math.round(ploc.getX() + randomx), world.getHighestBlockYAt(loc) + 2, Math.round(ploc.getZ() + randomz));
                                MobSpawnEvent spawn = new MobSpawnEvent(data, plugin);
                                spawn.spawnMethod(data, plugin, player.getUniqueId().toString(), world.getName(), spawnloc);
                                System.out.println(spawnloc.getX() + " " + spawnloc.getY() + " " + spawnloc.getZ());
                            }
                        }
                    }
                }
            }

        }.runTaskTimer(plugin, 1, 20 * data.getConfig().getInt("NaturalSpawning.NaturalTime"));


    }
}
