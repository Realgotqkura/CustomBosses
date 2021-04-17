package GUIs;

import CBossItemStacks.ExternalItems;
import CBossItemStacks.GUI_Items;
import CBossUtils.RandomUtils;
import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SpawnGUI implements Listener {

    CustomConfig_1 data;
    main plugin;
    public SpawnGUI(main plugin, CustomConfig_1 data){
        this.plugin = plugin;
        this.data = data;
    }


    public Inventory inv;

    public void createInv(Player player){
        inv = Bukkit.createInventory(null, 9, RandomUtils.color("&3Spawn your mob: "));
        inv.setItem(1, GUI_Items.GiveStick());
        inv.setItem(3, GUI_Items.NaturallySpawn());

        player.openInventory(inv);
    }


    @EventHandler
    public void Click(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(RandomUtils.color("&3Spawn your mob: "))){
            event.setCancelled(true);
            if(event.getSlot() == 1){
                ExternalItems items = new ExternalItems();
                player.closeInventory();
                player.getInventory().addItem(items.SpawnStick());
                return;
            }
            if(event.getSlot() == 3){
               NaturalSpawnGUI gui = new NaturalSpawnGUI(data, plugin);
               gui.createInv(player);

            }
        }

    }
}
