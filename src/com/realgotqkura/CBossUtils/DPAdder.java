package com.realgotqkura.CBossUtils;

import com.realgotqkura.CBossItemStacks.EquipmentStacks;
import com.realgotqkura.DataManager.CustomConfig_1;
import org.bukkit.Bukkit;
import org.bukkit.entity.*;

import java.util.Objects;

public class DPAdder {

    private CustomConfig_1 data;

    public DPAdder(CustomConfig_1 data){
        this.data = data;
    }


    private EquipmentStacks stacks = new EquipmentStacks();

    public void messageInfo(Player player, CustomConfig_1 config){
        try{
            player.sendMessage(RandomUtils.color("&6Current Helmet Drop Chance: &a" + config.getConfig().getDouble("players." + player.getUniqueId().toString() + ".Helmet_DP") + "%"));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current Helmet Drop Chance: &a0%"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current ChestPlate Drop Chance: &a" + config.getConfig().getDouble("players." + player.getUniqueId().toString() + ".ChestPlate_DP") + "%"));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current ChestPlate Drop Chance: &a0%"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current Leggings Drop Chance: &a" + config.getConfig().getDouble("players." + player.getUniqueId().toString() + ".Leggings_DP") + "%"));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current Leggings Drop Chance: &a0%"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current Boots Drop Chance: &a" + config.getConfig().getDouble("players." + player.getUniqueId().toString() + ".Boots_DP") + "%"));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current Boots Drop Chance: &a0%"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current MainHand Drop Chance: &a" + config.getConfig().getDouble("players." + player.getUniqueId().toString() + ".Main_DP") + "%"));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current MainHand Drop Chance: &a0%"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current OffHand Drop Chance: &a" + config.getConfig().getDouble("players." + player.getUniqueId().toString() + ".Off_DP") + "%"));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current OffHand Drop Chance: &a0%"));
        }

    }


    public void DPAdd(LivingEntity obj, String uuid){
        data.reloadConfig();

        try{
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance((float) (data.getConfig().getDouble("players." + uuid + ".Helmet_DP")/100d));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance((float) (data.getConfig().getDouble("players." + uuid + ".ChestPlate_DP")/100d));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance((float) (data.getConfig().getDouble("players." + uuid + ".Leggings_DP")/100d));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance((float) (data.getConfig().getDouble("players." + uuid + ".Boots_DP")/100d));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance((float) (data.getConfig().getDouble("players." + uuid + ".Main_DP")/100d));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance((float) (data.getConfig().getDouble("players." + uuid + ".Off_DP")/100d));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance(0);
        }

        if(obj.getEquipment().getHelmet().equals(stacks.Helmet())){
            obj.getEquipment().setHelmetDropChance(0);
        }
        if(obj.getEquipment().getChestplate().equals(stacks.ChestPlate())){
            obj.getEquipment().setChestplateDropChance(0);
        }
        if(obj.getEquipment().getLeggings().equals(stacks.Leggings())){
            obj.getEquipment().setLeggingsDropChance(0);
        }
        if(obj.getEquipment().getBoots().equals(stacks.Boots())){
            obj.getEquipment().setBootsDropChance(0);
        }
        if(obj.getEquipment().getItemInMainHand().equals(stacks.Mainhand())){
            obj.getEquipment().setItemInMainHandDropChance(0);
        }
        if(obj.getEquipment().getItemInOffHand().equals(stacks.Offhand())){
            obj.getEquipment().setItemInOffHandDropChance(0);
        }
    }
}
