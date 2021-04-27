package com.realgotqkura.CBossUtils;

import CBossesMain.main;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.realgotqkura.CBossItemStacks.GUI_Items;



public class GUISorting {

	private main plugin;
	public GUISorting(main plugin){
		this.plugin = plugin;
	}

	private GUI_Items items = new GUI_Items(plugin);
	public void GetInner(Inventory inv, int size) {

		if(size == 36) {
			for(int i = 0; i < size; i++) {
				  if(i > 9 && i < 17 || i > 18 && i < 26) {
					  if(inv.getItem(i) == null) {
					  inv.setItem(i, items.GUIglass());
					  }
				  }
				}
			return;
		}
		for(int i = 0; i < size; i++) {
		  if(i > 9 && i < 17 || i > 18 && i < 26 || i > 27 && i < 35 || i > 36 && i < 44) {
			  if(inv.getItem(i) == null) {
			  inv.setItem(i, items.GUIglass());
			  }
		  }
		}
	}
	
	private void RemoveInner(Inventory inv, int size) {
		for(int i = 0; i < size; i++) {
			  if(i > 9 && i < 17 || i > 18 && i < 26 || i > 27 && i < 35 || i > 36 && i < 44) {
				  if(inv.getItem(i) == null) {
				  inv.setItem(i, new ItemStack(Material.AIR));
				  }
			  }
			}
	}
	
	public void GetOuter(Inventory inv, int size, boolean removein) {
		GetInner(inv,size);
		for(int i = 0; i < size; i++) {
			if(inv.getItem(i) == null) {
				inv.setItem(i, items.GUIglassDark());
			}
		}
		if(removein) {
			RemoveInner(inv,size);
		}
	}

	public void Corners(Inventory inv, int size, ItemStack itemStack){
		inv.setItem(0, itemStack);
		inv.setItem(8, itemStack);
		inv.setItem(size - 1, itemStack);
		inv.setItem(size - 9, itemStack);
	}
}
