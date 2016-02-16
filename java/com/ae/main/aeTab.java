package com.ae.main;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class aeTab extends CreativeTabs {

	public aeTab(int index, String label) {
		super(index, label);
	}

	@Override
	public Item getTabIconItem() {
		return AdvancedElectronics.flintPickaxe;
	}

}
