package CBossesMain;

import com.realgotqkura.CBossUtils.DPAdder;
import com.realgotqkura.CBossUtils.RandomUtils;
import com.realgotqkura.DataManager.CustomConfig_1;
import com.realgotqkura.GUIs.GUI_1;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor{


	private final main plugin;
	private final CustomConfig_1 data;
	public Commands(CustomConfig_1 data, main plugin){
		this.data = data;
		this.plugin = plugin;
	} 


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(!(sender instanceof Player)) {
			sender.sendMessage("This command is only for players!");
			return true;
		}

		Player player = (Player) sender;
		if(player.hasPermission("CBossesGUI.use")){
		if(label.equalsIgnoreCase("CBossesGUI")) {
			if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("getmobname")) {
					CustomConfig_1 config = new CustomConfig_1(plugin);
					String name;
					name = config.getConfig().getString("players." + player.getUniqueId().toString() + ".MobName");
					player.sendMessage("§6Your mobs name is: " + name);
					return true;
				}
				if (args[0].equalsIgnoreCase("ismobababy")) {
					CustomConfig_1 config = new CustomConfig_1(plugin);
					boolean baby = config.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobBaby");
					player.sendMessage("§6Is your mob a baby: " + RandomUtils.color("&a" + baby));
					return true;
				}
				if (args[0].equalsIgnoreCase("getmobhealth")) {
					CustomConfig_1 config = new CustomConfig_1(plugin);
					int name;
					name = config.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobHealth");
					player.sendMessage("§6Your mobs health is: " + ChatColor.GREEN + name);
					return true;
				}
				if(args[0].equalsIgnoreCase("getmobpotions")){
					CustomConfig_1 config = new CustomConfig_1(plugin);
					boolean weak = config.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Weakness");
					boolean power = config.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Strength");
					boolean fast = config.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Speed");
					boolean slow = config.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".MobPot_Slowness");
					int weakLvl = config.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat");
					int powerLvl = config.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat");
					int fastLvl = config.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat");
					int slowLvl = config.getConfig().getInt("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat");
					player.sendMessage(ChatColor.GOLD + "Speed: " + ChatColor.GREEN +  fast + ChatColor.GOLD + " | " + "level: " + ChatColor.GREEN + fastLvl);
					player.sendMessage(ChatColor.GOLD + "Strength: " + ChatColor.GREEN +  power + ChatColor.GOLD + " | " + "level: " + ChatColor.GREEN + powerLvl);
					player.sendMessage(ChatColor.GOLD + "Weakness: " + ChatColor.GREEN +  weak + ChatColor.GOLD + " | " + "level: " + ChatColor.GREEN + weakLvl);
					player.sendMessage(ChatColor.GOLD + "Slowness: " + ChatColor.GREEN +  slow + ChatColor.GOLD + " | " + "level: " + ChatColor.GREEN + slowLvl);
					return true;
				}
				if(args[0].equalsIgnoreCase("getmobdropchance")){
					CustomConfig_1 config = new CustomConfig_1(plugin);
					DPAdder adder = new DPAdder(config);
					adder.messageInfo(player, config);
					return true;
				}
				return true;
			}

			CustomConfig_1 config = new CustomConfig_1(plugin);
			if(config.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".TypingGeneral")) {
				player.sendMessage(RandomUtils.color("&cPlease type a value in chat before using this command!"));
				return true;
			}

				GUI_1 gui = new GUI_1(plugin, data);
				gui.createStartInv();
				player.openInventory(gui.startInv);
				return true;
		}
		}
		return false;
	}

}
