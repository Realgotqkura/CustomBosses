package GUIs;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import CBossItemStacks.MobItemsGUI;
import CBossUtils.GUISorting;
import DataManager.CustomConfig_1;
import Main.main;

public class PickMobGUI implements Listener{

	public CustomConfig_1 data;
	public Inventory MobGUI;
	main plugin;
	
	public PickMobGUI(main plugin, CustomConfig_1 data){
		this.plugin = plugin;
		this.data = data;
	}
	

	private GUISorting sort = new GUISorting();
	private MobItemsGUI Mobs = new MobItemsGUI();
	
	public void createMobGUI() {
		MobGUI = Bukkit.createInventory(null, 36, "§2§lPick Your Mob Type");
		
		sort.GetInner(MobGUI, 36);
		sort.GetOuter(MobGUI, 36, false);
	    MobGUI.setItem(10, Mobs.ZombieItem());
	    MobGUI.setItem(11, Mobs.SkeletonItem());
	    MobGUI.setItem(12, Mobs.SpiderItem());
	    MobGUI.setItem(13, Mobs.PigmanItem());
	    MobGUI.setItem(14, Mobs.EndermanItem());
	    MobGUI.setItem(15, Mobs.WitherSkItem());
	    MobGUI.setItem(16, Mobs.WitchItem());
	    //next row
	    MobGUI.setItem(19, Mobs.BlazeItem());
	    MobGUI.setItem(20, Mobs.CreeperItem());
	    MobGUI.setItem(21, Mobs.GuardianItem());
	}
	
	@EventHandler
	public void Click(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		if(!event.getView().getTitle().equals("§2§lPick Your Mob Type"))
            return;

			event.setCancelled(true);
		if(event.getSlot() == 10) {
			String zombie = "Zombie";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
		    player.updateInventory();
		}
		else if(event.getSlot() == 11){
			String zombie = "Skeleton";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 12){
			String zombie = "Spider";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 13){
			String zombie = "Pigman";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 14){
			String zombie = "Enderman";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 15){
			String zombie = "Wither Skeleton";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 16){
			String zombie = "Witch";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 19){
			String zombie = "Blaze";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 20){
			String zombie = "Creeper";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		else if(event.getSlot() == 21){
			String zombie = "Guardian";
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", zombie);
			data.saveConfig();
			GUI_2 gui = new GUI_2(plugin,data);
			gui.createMakeBoss();
			gui.pick(player);
			player.openInventory(gui.makeBoss);
			player.updateInventory();
		}
		
		
	}
}
