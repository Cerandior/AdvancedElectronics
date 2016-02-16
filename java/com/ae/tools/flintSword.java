package com.ae.tools;

import com.ae.main.AdvancedElectronics;

import net.minecraft.item.ItemSword;

public class flintSword extends ItemSword {

	public flintSword() {
		super(AdvancedElectronics.flintMat);
		this.setCreativeTab(AdvancedElectronics.aeTab);
		this.setUnlocalizedName("flint_sword");
	}

}
