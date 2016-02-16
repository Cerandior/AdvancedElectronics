package com.ae.tools;

import com.ae.main.AdvancedElectronics;

import net.minecraft.item.ItemSpade;

public class flintShovel extends ItemSpade {

	public flintShovel() {
		super(AdvancedElectronics.flintMat);
		this.setCreativeTab(AdvancedElectronics.aeTab);
		this.setUnlocalizedName("flint_shovel");
	}

}
