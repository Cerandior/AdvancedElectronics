package com.ae.tools;

import com.ae.main.AdvancedElectronics;

import net.minecraft.item.ItemPickaxe;

public class flintPickaxe extends ItemPickaxe {

	public flintPickaxe() {
		super(AdvancedElectronics.flintMat);
		this.setCreativeTab(AdvancedElectronics.aeTab);
		this.setUnlocalizedName("flint_pickaxe");
	}

}
