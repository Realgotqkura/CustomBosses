package GUIs;

import CBossItemStacks.CBPropertiesItems;
import CBossUtils.GUISorting;
import CBossUtils.RandomUtils;
import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Objects;

public class CBPropertiesGUI implements Listener{

	public CustomConfig_1 data;
	private main plugin;
	public CBPropertiesGUI(CustomConfig_1 data, main plugin) {
		this.data = data;
		this.plugin = plugin;
	}
	
	public Inventory prop;
	private final CBPropertiesItems items = new CBPropertiesItems();

	public void createProp() {
		GUISorting sort = new GUISorting(plugin);
		prop = Bukkit.createInventory(null, 27, ChatColor.DARK_PURPLE +"" + ChatColor.BOLD + "Mob properties");
		sort.GetOuter(prop, 27, true);
		sort.GetInner(prop, 27);
		prop.setItem(10, items.Name());
		prop.setItem(11, items.Health());
		prop.setItem(12, items.Baby());
	}	
	
	
	
	@EventHandler
	public void InvClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		if(!event.getView().getTitle().contains("Mob properties")) {
			return;
		}


		event.setCancelled(true);
        if(event.getSlot() == 10 && Objects.equals(event.getInventory().getItem(10), items.Name())) {
			new BukkitRunnable() {
				
				@Override
				public void run() {
					player.closeInventory();
					cancel();
				}
				
			}.runTaskLater(plugin, 1);
			data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTyping", true);
			data.saveConfig();
			player.sendMessage("§aName your mob!");
			return;
		}

        if(event.getSlot() == 11 && Objects.equals(event.getInventory().getItem(11), items.Health())){
			new BukkitRunnable() {

				@Override
				public void run() {
					player.closeInventory();
					cancel();
				}

			}.runTaskLater(plugin, 1);
			data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", true);
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTypingHP", true);
			data.saveConfig();
			player.sendMessage("§aSet the health of your mob!");
			return;
		}

        if(event.getSlot() == 12){
        	try {
				if (data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobBaby")) {
					data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBaby", false);
					data.saveConfig();
					player.sendMessage(RandomUtils.color("&a&lYour mob is not going to be a baby!"));
					return;
				}
				if (!data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobBaby")) {
					data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBaby", true);
					data.saveConfig();
					player.sendMessage(RandomUtils.color("&a&lYour mob is going to be a baby!"));
				}
			}catch(NullPointerException e){
        		data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBaby", true);
				data.saveConfig();
				player.sendMessage(RandomUtils.color("&a&lYour mob is going to be a baby!"));
			}

		}



	}
	
	@EventHandler
	public void TypingName(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if(!this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobTyping"))
			return;
		
		event.setCancelled(true);
		String name = event.getMessage();
		data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
		data.getConfig().set("players." + player.getUniqueId().toString() + ".MobName", name);
		data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTyping", false);
		data.saveConfig();
		player.sendMessage("§aSuccessfully named the mob!");
		
		
	}

	@EventHandler
	public void TypingHP(AsyncPlayerChatEvent event){
	Player player = event.getPlayer();
		if(!this.data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobTypingHP"))
			return;

		event.setCancelled(true);
		try {
			int health = Integer.parseInt(event.getMessage());
			data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobHealth", health);
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTypingHP", false);
			data.saveConfig();
            player.sendMessage("§aSuccessfully changed the health to " + health);
		}catch(Exception e){
			data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
			player.sendMessage("§cYour message contains letters and symbols!");
			data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTypingHP", false);
		}
	}
}
