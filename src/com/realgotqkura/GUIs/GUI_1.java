package com.realgotqkura.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.realgotqkura.CBossItemStacks.GUI_Items;
import com.realgotqkura.CBossUtils.GUISorting;
import com.realgotqkura.DataManager.CustomConfig_1;
import CBossesMain.main;

public class GUI_1 implements Listener{

	public CustomConfig_1 data;
	main plugin;
	public GUI_1(main plugin, CustomConfig_1 data){
		this.plugin = plugin;
		this.data = data;
	} 
	
	public Inventory startInv;
	
	//methods
	public void createStartInv() {
		GUISorting sort = new GUISorting(plugin);
		GUI_Items items = new GUI_Items(plugin);
		startInv = Bukkit.createInventory(null, 54, "§a§lCustom Bosses GUI");
		
		
		sort.GetInner(startInv, 54);
		sort.GetOuter(startInv, 54, false);
		//out of for loop 
		startInv.setItem(49, items.GUIClose());
		startInv.setItem(20, items.MakeBoss());
		startInv.setItem(24, items.GetItem111());
	}
	
	//Listeners
	@EventHandler
	public void InvClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(event.getView().getTitle().equals("§a§lCustom Bosses GUI")) {
			event.setCancelled(true);
			if(event.getSlot() == 49) {
				player.closeInventory();
			}
			else if(event.getSlot() == 20) {
			    GUI_2 gui2 = new GUI_2(plugin, data);
				gui2.createMakeBoss();
				try {
				gui2.pick(player);
				}catch(Exception ignored) {
				}
				player.openInventory(gui2.makeBoss);
			}
			else if(event.getSlot() == 24) {
				SpawnGUI gui = new SpawnGUI(plugin, data);
				gui.createInv(player);
			}
		}
		   
	    
		   
	}
	
}
