package CustomBosses_Events;

import CBossItemStacks.EquipmentStacks;
import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scheduler.BukkitRunnable;



public class InvClickEvent implements Listener {

    private EquipmentStacks stacks = new EquipmentStacks();
    private CustomConfig_1 data;
    private main plugin;

    public InvClickEvent(CustomConfig_1 data, main plugin){
      this.data = data;
      this.plugin = plugin;
    }

    @EventHandler
    public void Click(InventoryClickEvent event){
        CustomConfig_1 d = new CustomConfig_1(plugin);
        Player player = (Player)event.getWhoClicked();
        if(!event.getInventory().equals(player.getInventory())){
            return;
        }

        if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPickHelmet")){


            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickHelmet", false);
                }
            }.runTaskLater(plugin, 15*20);
            try{
                int i = event.getSlot();
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobHelmet", event.getInventory().getItem(i));
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickHelmet", false);
            }catch(Exception exception){
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobHelmet", stacks.Helmet());
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickHelmet", false);
            }
            d.saveConfig();
            player.closeInventory();
            return;
        }
        if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPickChestPlate")){

            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickChestPlate", false);
                }
            }.runTaskLater(plugin, 15*20);
            try{
                int i = event.getSlot();
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobChestplate", event.getInventory().getItem(i));
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickChestPlate", false);
            }catch(Exception exception){
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobChestplate", stacks.Helmet());
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickChestPlate", false);
            }
            d.saveConfig();
            player.closeInventory();
            return;
        }
        if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPickMainHand")){

            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickMainHand", false);
                }
            }.runTaskLater(plugin, 15*20);
            try{
                int i = event.getSlot();
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobMainhand", event.getInventory().getItem(i));
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickMainHand", false);
            }catch(Exception exception){
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobMainhand", stacks.Helmet());
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickMainHand", false);
            }
            d.saveConfig();
            player.closeInventory();
            return;
        }
        if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPickOffhand")){
            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickOffhand", false);
                }
            }.runTaskLater(plugin, 15*20);
            try{
                int i = event.getSlot();
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobOffHand", event.getInventory().getItem(i));
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickOffhand", false);
            }catch(Exception exception){
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobOffHand", stacks.Helmet());
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickOffhand", false);
            }
            d.saveConfig();
            player.closeInventory();
            return;
        }
        if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPickLeggings")){
            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickLeggings", false);
                }
            }.runTaskLater(plugin, 15*20);
            try{
                int i = event.getSlot();
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobLeggings", event.getInventory().getItem(i));
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickLeggings", false);
            }catch(Exception exception){
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobLeggings", stacks.Helmet());
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickLeggings", false);
            }
            d.saveConfig();
            player.closeInventory();
            return;
        }
        if(d.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPickBoots")){
            event.setCancelled(true);
            new BukkitRunnable(){
                @Override
                public void run() {
                    d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickBoots", false);
                }
            }.runTaskLater(plugin, 15*20);
            try{
                int i = event.getSlot();
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobBoots", event.getInventory().getItem(i));
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickBoots", false);
            }catch(Exception exception){
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobBoots", stacks.Helmet());
                d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickBoots", false);
            }
            d.saveConfig();
            player.closeInventory();
            return;
        }
    }

}
