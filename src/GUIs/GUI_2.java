package GUIs;

import CBossItemStacks.EquipmentStacks;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import CBossItemStacks.GUI_Items;
import CBossItemStacks.SetBossThingyGUI;
import CBossUtils.GUISorting;
import DataManager.CustomConfig_1;
import Main.main;

import java.util.Objects;

public class GUI_2 implements Listener{

	public CustomConfig_1 data;
	public Inventory makeBoss;
    main plugin;
	public GUI_2(main plugin, CustomConfig_1 data){
		this.plugin = plugin;
		this.data = data;
	} 
	
	private CBPropertiesGUI proper = new CBPropertiesGUI(data, plugin);
	private GUI_Items items = new GUI_Items();
	private GUISorting sort = new GUISorting();
	private PickMobGUI mobgui = new PickMobGUI(plugin, this.data);
	private SetBossThingyGUI setMob = new SetBossThingyGUI();


	public void pick(Player player) {
		switch(Objects.requireNonNull(this.data.getConfig().getString("players." + player.getUniqueId().toString() + ".MobType"))) {
		    case "Zombie":
			    makeBoss.setItem(13, setMob.ZombieBar());
			    break;
			case "Skeleton":
				makeBoss.setItem(13, setMob.SkeletonBar());
				break;
			case "Spider":
				makeBoss.setItem(13, setMob.SpiderBar());
				break;
			case "Pigman":
				makeBoss.setItem(13, setMob.PigmanBar());
				break;
			case "Enderman":
				makeBoss.setItem(13, setMob.EndermanBar());
				break;
			case "WitherSkeleton":
				makeBoss.setItem(13, setMob.WitherSkelBar());
				break;
			case "Witch":
				makeBoss.setItem(13, setMob.WitchBar());
				break;
			case "Blaze":
				makeBoss.setItem(13, setMob.BlazeBar());
				break;
			case "Creeper":
				makeBoss.setItem(13, setMob.CreeperBar());
				break;
			case "Guardian":
				makeBoss.setItem(13, setMob.GuardianBar());
				break;
		    default:
			    makeBoss.setItem(13, setMob.Default());
			    break;
		}
	}
	
	public void createMakeBoss() {
		makeBoss = Bukkit.createInventory(null, 54, "§e§lMake your Boss");
		
		sort.GetInner(makeBoss, 54);
		sort.GetOuter(makeBoss, 54, false);
		makeBoss.setItem(49, items.GUIClose());
		makeBoss.setItem(13, setMob.Default());
		makeBoss.setItem(19, items.Properties());
		makeBoss.setItem(22, items.Potions());
		makeBoss.setItem(25, items.ArmorAndHand());
		makeBoss.setItem(28, items.DropChance());
		
	}	
	
	//Listeners
	@EventHandler
	public void click(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(event.getView().getTitle().equals("§e§lMake your Boss")) {
			event.setCancelled(true);
			if(event.getSlot() == 13) {
				mobgui.createMobGUI();
				player.openInventory(mobgui.MobGUI);

			}else if(event.getSlot() == 49) {
				player.closeInventory();

			}else if(event.getSlot() == 19) {
				proper.createProp();
			    player.openInventory(proper.prop);
				
			}else if(event.getSlot() == 22){
				CBPotionsGUI gui = new CBPotionsGUI(data,plugin);
				gui.createPotInv();
				player.openInventory(gui.potionsInv);
			}else if(event.getSlot() == 25){
				EquipmentStacks stacks = new EquipmentStacks();
				EquipmentGUI gui = new EquipmentGUI(data, plugin);
				gui.createEqInv();
				data.reloadConfig();
				gui.EqInv.setItem(13, this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobHelmet"));
				gui.EqInv.setItem(22, this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobChestplate"));
				gui.EqInv.setItem(23, this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobOffHand"));
				gui.EqInv.setItem(21, this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobMainhand"));
				gui.EqInv.setItem(31, this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobLeggings"));
				gui.EqInv.setItem(40, this.data.getConfig().getItemStack("players." + player.getUniqueId().toString() + ".MobBoots"));
				player.openInventory(gui.EqInv);
			}else if(event.getSlot() == 28){
				DropChanceGUI gui = new DropChanceGUI(data, plugin);
				gui.createdropChanceInv();
				player.openInventory(gui.dropChanceInv);
			}
			
		}
	}
}
