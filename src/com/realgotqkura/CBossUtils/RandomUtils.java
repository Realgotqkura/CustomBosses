package com.realgotqkura.CBossUtils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class RandomUtils {

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }


    public static int RecommendedSpawnRate(int time, int minTime, int mobs){
        if(time > minTime){
            return (time / 10) + mobs;
        }
        return time / 5;
    }

}
