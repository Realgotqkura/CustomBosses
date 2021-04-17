package CBossUtils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class RandomUtils {

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static boolean compareInventoryContents(Inventory first, Inventory second){
        return Arrays.equals(first.getContents(), second.getContents());
    }

}
