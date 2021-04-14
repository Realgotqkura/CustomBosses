package CustomBosses_Events;

import CBossItemStacks.EquipmentStacks;
import DataManager.CustomConfig_1;
import Main.main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Join_Event implements Listener {

    private CustomConfig_1 data;
    private EquipmentStacks stacks = new EquipmentStacks();
    private main plugin;
    public Join_Event(CustomConfig_1 data, main plugin){
      this.plugin = plugin;
      this.data = data;
    }


    @EventHandler
    public void Join(PlayerJoinEvent event){
        Player player = event.getPlayer();

        if(player.hasPermission("CBossesGUI.use")){ //permission check
            try{
                if(!data.getConfig().getBoolean("players." + player.getUniqueId().toString() + ".joined")){
                    //if false
                    //Stuff
                    ArrayList<String> configArgs = new ArrayList<>(
                      Arrays.asList(".TypingGeneral", ".joined", ".MobTyping", ".MobType", ".MobName", ".MobTypingHP"
                      , ".MobHealth", ".MobBaby", ".MobPickHelmet", ".MobPickChestPlate", ".MobPickLeggings", "")
                    );



                    data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".joined", true);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTyping", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", "Zombie");
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobName", "Default Name");
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTypingHP", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobHealth", 20);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBaby", false);

                    //Equipment
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickHelmet", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickChestPlate", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickLeggings", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickBoots", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickMainHand", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickOffhand", false);

                    //Potions
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Speed", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat", 1);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Strength", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat", 1);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChatLVL", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Weakness", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat", 1);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChatLVL", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Slowness", false);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat", 1);
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChatLVL", false);

                    //Equipment
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobChestplate", stacks.ChestPlate());
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobLeggings", stacks.Leggings());
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBoots", stacks.Boots());
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobHelmet", stacks.Helmet());
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobMainhand", stacks.Mainhand());
                    data.getConfig().set("players." + player.getUniqueId().toString() + ".MobOffHand", stacks.Offhand());
                    data.saveConfig();
                }
            }catch(Exception e){
                //will run only once per player
                //Stuff
                data.getConfig().set("players." + player.getUniqueId().toString() + ".TypingGeneral", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".joined", true);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTyping", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobType", "Zombie");
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobName", "Default Name");
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobTypingHP", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobHealth", 20);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBaby", false);

                //Equipment
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickHelmet", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickChestPlate", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickLeggings", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickBoots", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickMainHand", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPickOffhand", false);

                //Potions
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Speed", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChat", 1);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SpeedChatLVL", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Strength", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChat", 1);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_StrengthChatLVL", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Weakness", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChat", 1);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_WeaknessChatLVL", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_Slowness", false);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChat", 1);
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobPot_SlownessChatLVL", false);

                //Equipment
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobChestplate", stacks.ChestPlate());
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobLeggings", stacks.Leggings());
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobBoots", stacks.Boots());
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobHelmet", stacks.Helmet());
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobMainhand", stacks.Mainhand());
                data.getConfig().set("players." + player.getUniqueId().toString() + ".MobOffHand", stacks.Offhand());
                data.saveConfig();



            }

        }
    }
}
