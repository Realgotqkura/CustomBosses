package com.realgotqkura.CBossUtils;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class RandomUtils {

    public static String color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

/*  Save for next update. Please help.
    public static float RecommendedSpawnTime(int minmobs, int mintime, int currentmobs){
        int avrmintime = 30; //The avarage spawn time. (HardCoded)
        int timedivider = mintime / avrmintime; //Used to divide or multiply by the time so it scales well
        int avrRam = 4; //The avarage gb of ram (hardcoded for now)
        int t = minmobs - currentmobs; //First argument in formula.
        int r1 = (int) (avrRam - (Runtime.getRuntime().totalMemory() / 1048576)); //Second argument in formula
        int r = r1 / 1000;
        System.out.println(r1 + " " + r);
        if(t < 0){
            int e = t + (t * 2);
            t = e / 2;
        }else if(t > 0){
            int e = t - (t * 2);
            t = e + (e / 3);
        }
        System.out.println(mintime);
        System.out.println(t);
        System.out.println(timedivider);
        System.out.println(r);
        return mintime + (t * timedivider) + r;
    }

 */
}
