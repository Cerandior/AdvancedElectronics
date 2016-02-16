package com.ae.client;

import com.ae.main.AdvancedElectronics;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderer {

	public static void registerItemRender(){
		registerItemRenderer(AdvancedElectronics.flintAxe);
		registerItemRenderer(AdvancedElectronics.flintSword);
		registerItemRenderer(AdvancedElectronics.flintPickaxe);
		registerItemRenderer(AdvancedElectronics.flintHoe);
		registerItemRenderer(AdvancedElectronics.flintShovel);
		registerItemRenderer(AdvancedElectronics.energyTool);
	}
	
	public static void registerItemRenderer(Item item){
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(AdvancedElectronics.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
		
	}
	
}
