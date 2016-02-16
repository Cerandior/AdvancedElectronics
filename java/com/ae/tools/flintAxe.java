package com.ae.tools;

import com.ae.main.AdvancedElectronics;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class flintAxe extends ItemAxe {

	public flintAxe() {
		super(AdvancedElectronics.flintMat);
		this.setCreativeTab(AdvancedElectronics.aeTab);
		this.setUnlocalizedName("flint_axe");
	}

}
