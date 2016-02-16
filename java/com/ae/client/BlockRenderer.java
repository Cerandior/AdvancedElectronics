package com.ae.client;

import com.ae.main.AdvancedElectronics;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderer {

	public static void registerBlockRender(){

	}
	
	public static void registerBlockRenderer(Block block){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(AdvancedElectronics.MODID + ":" + block.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
}
