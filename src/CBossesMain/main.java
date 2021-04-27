package CBossesMain;

import com.realgotqkura.CustomBosses_Events.InvClickEvent;
import com.realgotqkura.CustomBosses_Events.Join_Event;
import com.realgotqkura.CustomBosses_Events.MobSpawnEvent;
import com.realgotqkura.CustomBosses_Events.NaturalSpawning_Event;
import com.realgotqkura.DataManager.CustomConfig_1;
import com.realgotqkura.GUIs.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class main extends JavaPlugin{

	
	private CustomConfig_1 data;


	@Override
	public void onEnable() {

		//Commands
		Objects.requireNonNull(this.getCommand("CBossesGUI")).setExecutor(new Commands(this.data, this));
		Objects.requireNonNull(this.getCommand("CBossesGUI")).setTabCompleter(new CMDCompleter());

		//Objects
		this.data = new CustomConfig_1(this);
		InvClickEvent invclick = new InvClickEvent(this.data,this);
		EquipmentGUI eqgui = new EquipmentGUI(this.data, this);
		CBPotionsGUI potgui = new CBPotionsGUI(this.data,this);
		CBPropertiesGUI prop = new CBPropertiesGUI(this.data ,this);
		GUI_1 gui1 = new GUI_1(this, this.data);
		MobSpawnEvent spawn = new MobSpawnEvent(this.data, this);
		GUI_2 gui2 = new GUI_2(this, this.data);
		PickMobGUI gui3 = new PickMobGUI(this, this.data);
		Join_Event jEvent = new Join_Event(this.data, this);
		DropChanceGUI gui111 = new DropChanceGUI(this.data, this);
		NaturalSpawning_Event spawnevent = new NaturalSpawning_Event(this, this.data);

		//Listeners
		this.getServer().getPluginManager().registerEvents(new SpawnGUI(this, this.data), this);
		this.getServer().getPluginManager().registerEvents(invclick, this);
		this.getServer().getPluginManager().registerEvents(eqgui, this);
		this.getServer().getPluginManager().registerEvents(jEvent,this);
		this.getServer().getPluginManager().registerEvents(potgui, this);
		this.getServer().getPluginManager().registerEvents(prop, this);
		this.getServer().getPluginManager().registerEvents(spawn, this);
		this.getServer().getPluginManager().registerEvents(gui1, this);
		this.getServer().getPluginManager().registerEvents(gui2, this);
		this.getServer().getPluginManager().registerEvents(gui3, this);
		this.getServer().getPluginManager().registerEvents(gui111, this);
		this.getServer().getPluginManager().registerEvents(new NaturalSpawnGUI(this.data,this), this);

		spawnevent.SpawnMobs(data, this);

		
	}
	@Override
	public void onDisable() {
		Bukkit.broadcastMessage(ChatColor.RED + "Disabling CustomBosses");
		
	}
}
