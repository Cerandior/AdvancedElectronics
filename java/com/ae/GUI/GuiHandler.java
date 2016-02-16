package com.ae.GUI;

import com.ae.TileEntities.ChargerTE;
import com.ae.TileEntities.BaseClasses.EnergyChargerTE;
import com.ae.main.AdvancedElectronics;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
	
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if(ID == AdvancedElectronics.ChargerGUIID){
			return new ContainerCharger(player.inventory, (ChargerTE)te);
		}
		
         return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity te = world.getTileEntity(pos);
		if(ID == AdvancedElectronics.ChargerGUIID){
			return new GuiCharger(player.inventory, (ChargerTE)te);
		}
		
		return null;
	}

}
