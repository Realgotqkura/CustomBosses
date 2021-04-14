package CustomBosses_Events;

import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

public class NaturalSpawning_Event implements Listener {

    CustomConfig_1 data;
    main plugin;
    public NaturalSpawning_Event(main plugin, CustomConfig_1 data){
        this.plugin = plugin;
        this.data = data;
    }


    public void SpawnMobs(Player player){

        new BukkitRunnable(){


        }.runTaskTimer(plugin, )


    }
}
