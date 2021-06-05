package CBossesMain;

import com.realgotqkura.CustomBosses_Events.InvClickEvent;
import com.realgotqkura.CustomBosses_Events.Join_Event;
import com.realgotqkura.CustomBosses_Events.MobSpawnEvent;
import com.realgotqkura.CustomBosses_Events.NaturalSpawning_Event;
import com.realgotqkura.DataManager.CustomConfig_1;
import com.realgotqkura.GUIs.*;
import com.realgotqkura.Metric;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class main extends JavaPlugin{

	private CustomConfig_1 data;

	@Override
	public void onEnable() {


		int pluginID = 11591;
		Metric metric = new Metric(this, pluginID);

		//Commands
		Objects.requireNonNull(this.getCommand("CBossesGUI")).setExecutor(new Commands(this.data, this));
		Objects.requireNonNull(this.getCommand("CBossesGUI")).setTabCompleter(new CMDCompleter());

		//Objects
		this.data = new CustomConfig_1(this);
		NaturalSpawning_Event spawnevent = new NaturalSpawning_Event(this, this.data);

		//Listeners
		this.getServer().getPluginManager().registerEvents(new SpawnGUI(this, this.data), this);
		this.getServer().getPluginManager().registerEvents(new InvClickEvent(this.data, this), this);
		this.getServer().getPluginManager().registerEvents(new EquipmentGUI(this.data, this), this);
		this.getServer().getPluginManager().registerEvents(new Join_Event(this.data, this),this);
		this.getServer().getPluginManager().registerEvents(new CBPotionsGUI(this.data, this), this);
		this.getServer().getPluginManager().registerEvents(new CBPropertiesGUI(this.data,this), this);
		this.getServer().getPluginManager().registerEvents(new MobSpawnEvent(this.data, this), this);
		this.getServer().getPluginManager().registerEvents(new GUI_1(this, this.data), this);
		this.getServer().getPluginManager().registerEvents(new GUI_2(this, this.data), this);
		this.getServer().getPluginManager().registerEvents(new PickMobGUI(this,this.data), this);
		this.getServer().getPluginManager().registerEvents(new DropChanceGUI(this.data, this), this);
		this.getServer().getPluginManager().registerEvents(new NaturalSpawnGUI(this.data,this), this);

		spawnevent.SpawnMobs(data, this);

		
	}
	@Override
	public void onDisable() {
		Bukkit.broadcastMessage(ChatColor.RED + "Disabling CustomBosses");
		
	}
}
