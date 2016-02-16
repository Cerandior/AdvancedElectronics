package com.ae.tools;

import com.ae.main.AdvancedElectronics;

import net.minecraft.item.ItemHoe;

public class flintHoe extends ItemHoe {

	public flintHoe() {
		super(AdvancedElectronics.flintMat);
		this.setCreativeTab(AdvancedElectronics.aeTab);
		this.setUnlocalizedName("flint_hoe");
	}

}
