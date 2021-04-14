package GUIs;

import CBossItemStacks.EquipmentStacks;
import CBossItemStacks.GUI_Items;
import CBossUtils.GUISorting;
import CBossUtils.RandomUtils;
import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class EquipmentGUI implements Listener {

    public Inventory EqInv;
    private GUISorting sort = new GUISorting();
    private EquipmentStacks stacks = new EquipmentStacks();
    private GUI_Items items = new GUI_Items();
    private CustomConfig_1 data;
    private main plugin;
    public EquipmentGUI(CustomConfig_1 data, main plugin){
        this.data = data;
        this.plugin = plugin;
    }

    public void createEqInv(){
        EqInv = Bukkit.createInventory(null, 54, RandomUtils.color("&c&lEquipment GUI"));
        sort.GetInner(EqInv, 54);
        sort.GetOuter(EqInv, 54, false);
        sort.Corners(EqInv, 54, items.PolishedAndCheck());
        //Stacks *Temporary*
        //Add another way of adding.
        //EqInv.setItem(13, stacks.Helmet());
        //EqInv.setItem(22, stacks.ChestPlate());
        //EqInv.setItem(23, stacks.Offhand());
        //EqInv.setItem(21, stacks.Mainhand());
        //EqInv.setItem(31, stacks.Leggings());
        //EqInv.setItem(40, stacks.Boots());
    }

    @EventHandler
    public void InvClick(InventoryClickEvent event){
        CustomConfig_1 d = new CustomConfig_1(plugin);
        Player player = (Player)event.getWhoClicked();
        if(!event.getView().getTitle().contains("Equipment GUI")) {
            return;
        }

        event.setCancelled(true);
        if(event.getSlot() == 13){
            d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickHelmet", true);
            d.saveConfig();
            player.openInventory(player.getInventory());
            player.sendMessage(RandomUtils.color("&aPick an item from your inventory!"));
            return;
        }
        if(event.getSlot() == 22){
            d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickChestPlate", true);
            d.saveConfig();
            player.openInventory(player.getInventory());
            player.sendMessage(RandomUtils.color("&aPick an item from your inventory!"));
            return;
        }
        if(event.getSlot() == 21){
            d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickMainHand", true);
            d.saveConfig();
            player.openInventory(player.getInventory());
            player.sendMessage(RandomUtils.color("&aPick an item from your inventory!"));
            return;
        }
        if(event.getSlot() == 23){
            d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickOffhand", true);
            d.saveConfig();
            player.openInventory(player.getInventory());
            player.sendMessage(RandomUtils.color("&aPick an item from your inventory!"));
            return;
        }
        if(event.getSlot() == 31){
            d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickLeggings", true);
            d.saveConfig();
            player.openInventory(player.getInventory());
            player.sendMessage(RandomUtils.color("&aPick an item from your inventory!"));
            return;
        }
        if(event.getSlot() == 40){
            d.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickBoots", true);
            d.saveConfig();
            player.openInventory(player.getInventory());
            player.sendMessage(RandomUtils.color("&aPick an item from your inventory!"));
        }




    }
}
