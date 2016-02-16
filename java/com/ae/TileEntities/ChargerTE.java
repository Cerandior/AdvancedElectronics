package com.ae.TileEntities;

import com.ae.TileEntities.BaseClasses.EnergyChargerTE;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;

public class ChargerTE extends EnergyChargerTE implements ISidedInventory{

	private ItemStack inv[];
	
	public ChargerTE(){
		this.inv = new ItemStack[this.getSizeInventory()];
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {

        NBTTagList itemList = new NBTTagList();
        for (int i = 0; i < inv.length; i++) {
                ItemStack stack = inv[i];
                if (stack != null) {
                        NBTTagCompound tag = new NBTTagCompound();
                        tag.setByte("Slot", (byte) i);
                        stack.writeToNBT(tag);
                        itemList.appendTag(tag);
                }
        }
        nbt.setTag("Inventory", itemList);
		
		super.writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		
		 NBTTagList tagList = nbt.getTagList("Inventory", 4);
         for (int i = 0; i < tagList.tagCount(); i++) {
                 NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
                 byte slot = tag.getByte("Slot");
                 if (slot >= 0 && slot < inv.length) {
                         inv[slot] = ItemStack.loadItemStackFromNBT(tag);
                 }
         }
		
		super.readFromNBT(nbt);
	}
	
	@Override
	public int getSizeInventory() {
		return 4;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if(index < 0 || index >= this.getSizeInventory()){
			return null;
		}
		return this.inv[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		
		ItemStack stack = getStackInSlot(index);
        if (stack != null) {
                if (stack.stackSize <= count) {
                        setInventorySlotContents(index, null);
                } else {
                        stack = stack.splitStack(count);
                        if (stack.stackSize == 0) {
                                setInventorySlotContents(index, null);
                        }
                }
        }
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		  
		  ItemStack stack = getStackInSlot(index);
          if (stack != null) {
                  setInventorySlotContents(index, null);
          }
          return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		
		if(index < 0 || index >= this.getSizeInventory()){
			return;
		}
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
                stack.stackSize = getInventoryStackLimit();
        }
        this.inv[index] = stack;
        this.markDirty();
        
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory(EntityPlayer player) {
	}

	@Override
	public void closeInventory(EntityPlayer player) {
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int getField(int id) {
		return 0;
	}

	@Override
	public void setField(int id, int value) {		
	}

	@Override
	public int getFieldCount() {
		return 0;
	}

	@Override
	public void clear() {	
		for (int i = 0; i < this.getSizeInventory(); i++)
	        this.setInventorySlotContents(i, null);
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public IChatComponent getDisplayName() {
	    return null;
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction) {
		return true;
	}

	@Override
	public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction) {
		return true;
	}
	
}
