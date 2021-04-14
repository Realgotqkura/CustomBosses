package CBossUtils;

import CBossItemStacks.EquipmentStacks;
import DataManager.CustomConfig_1;
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
            player.sendMessage(RandomUtils.color("&6Current Helmet Drop Chance: &a" + config.getConfig().getInt("players." + player.getUniqueId().toString() + ".Helmet_DP")));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current Helmet Drop Chance: &a0"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current ChestPlate Drop Chance: &a" + config.getConfig().getInt("players." + player.getUniqueId().toString() + ".ChestPlate_DP")));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current ChestPlate Drop Chance: &a0"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current Leggings Drop Chance: &a" + config.getConfig().getInt("players." + player.getUniqueId().toString() + ".Leggings_DP")));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current Leggings Drop Chance: &a0"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current Boots Drop Chance: &a" + config.getConfig().getInt("players." + player.getUniqueId().toString() + ".Boots_DP")));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current Boots Drop Chance: &a0"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current MainHand Drop Chance: &a" + config.getConfig().getInt("players." + player.getUniqueId().toString() + ".Main_DP")));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current MainHand Drop Chance: &a0"));
        }
        try{
            player.sendMessage(RandomUtils.color("&6Current OffHand Drop Chance: &a" + config.getConfig().getInt("players." + player.getUniqueId().toString() + ".Off_DP")));
        }catch (NullPointerException e){
            player.sendMessage(RandomUtils.color("&6Current OffHand Drop Chance: &a0"));
        }

    }


    public void ZombieAdd(Zombie obj, Player player){
        data.reloadConfig();

        try{
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Helmet_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".ChestPlate_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Leggings_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Boots_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Main_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Off_DP"));
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

    public void SkeletonAdd(Skeleton obj, Player player){
        data.reloadConfig();

        try{
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Helmet_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".ChestPlate_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Leggings_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Boots_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Main_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Off_DP"));
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


    public void PigmanAdd(PigZombie obj, Player player){
        data.reloadConfig();

        try{
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Helmet_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".ChestPlate_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Leggings_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Boots_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Main_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Off_DP"));
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

    public void PiglinAdd(Piglin obj, Player player){
        data.reloadConfig();

        try{
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Helmet_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".ChestPlate_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Leggings_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Boots_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Main_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Off_DP"));
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

    public void WitherSkeletonAdd(WitherSkeleton obj, Player player){
        data.reloadConfig();

        try{
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Helmet_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setHelmetDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".ChestPlate_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setChestplateDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Leggings_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setLeggingsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Boots_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setBootsDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Main_DP"));
        }catch(NullPointerException e){
            Objects.requireNonNull(obj.getEquipment()).setItemInMainHandDropChance(0);
        }
        try{
            Objects.requireNonNull(obj.getEquipment()).setItemInOffHandDropChance(data.getConfig().getInt("players." + player.getUniqueId().toString() + ".Off_DP"));
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