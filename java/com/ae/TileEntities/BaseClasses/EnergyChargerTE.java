package com.ae.TileEntities.BaseClasses;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.gui.IUpdatePlayerListBox;
import net.minecraft.tileentity.TileEntity;

public class EnergyChargerTE extends TileEntity implements IUpdatePlayerListBox{

	public float EnergyStored;
	public float MaxEnergy;
	public float Extract;
	
	public float getEnergyStored(){
		return EnergyStored;
	}
	
	public void setEnergyStored(float Value){
		EnergyStored = Value;
	}
	
	public float getMaxEnergy(){
		return MaxEnergy;
	}
	
	public void setMaxEnergy(float Value){
		MaxEnergy = Value;
	}
	
	public float getExtract(){
		return Extract;
	}
	
	public void setExtract(float Value){
		Extract = Value;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setFloat("EnergyStored", EnergyStored);
		nbt.setFloat("MaxEnergy", MaxEnergy);
		nbt.setFloat("Extract", Extract);
		super.writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		nbt.getFloat("EnergyStored");
		nbt.getFloat("MaxEnergy");
		nbt.getFloat("Extract");
		super.readFromNBT(nbt);
	}
	
	@Override
	public void update() {
		
	}

}
