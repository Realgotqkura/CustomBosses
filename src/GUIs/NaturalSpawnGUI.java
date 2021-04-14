package GUIs;


import CBossItemStacks.GUI_Items;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;


public class NaturalSpawnGUI {

    public Inventory gui;

    public void createInv(Player player){
        gui = Bukkit.createInventory(null, 9, "Natural Spawning Settings");
        gui.setItem(1, GUI_Items.SelectTime());
        gui.setItem(3, GUI_Items.SpawnRate());

        player.openInventory(gui);
    }
}
