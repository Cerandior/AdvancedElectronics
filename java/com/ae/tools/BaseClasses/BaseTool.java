package com.ae.tools.BaseClasses;

import java.util.Set;

import com.ae.main.AdvancedElectronics;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class BaseTool extends Item{

	public float EnergyStored;
	public float MaxEnergy;
	public float EnergyPerUsage;
	public float attackDamage;
	public float efficiency;
	
	public BaseTool(){
		this.setMaxDamage((int) MaxEnergy);
		this.setMaxStackSize(1);
		this.setHarvestLevel("pickaxe", 100);
		this.setCreativeTab(AdvancedElectronics.aeTab);
	}
	
	public void setEnergyPerUsage(int Value){
		EnergyPerUsage = Value;
	}
	
	public float getEnergyPerUsage(){
		return EnergyPerUsage;
	}
	
	@Override
	public boolean showDurabilityBar(ItemStack stack) {
		return !(getEnergyStored() == getMaxEnergy());
	}
	
	public void setMaxEnergy(float Value){
		MaxEnergy = Value;
	}
	
	public float getMaxEnergy(){
		return MaxEnergy;
	}
	
	public void setEfficiency(float Value){
		efficiency = Value;
	}
	
	public float getEfficiency(){
		return efficiency;
	}
	
	public void setAttackDamage(float Value){
		attackDamage = Value;
	}
	
	public float getAttackDamage(){
		return attackDamage;
	}
	
	public float getEnergyStored(){
		return EnergyStored;
	}
	
	public void setEnergyStored(float Value){
		EnergyStored = Value;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		
		if(!stack.hasTagCompound()){
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setFloat("EnergyStored", EnergyStored);
			nbt.setFloat("MaxEnergy", MaxEnergy);
			nbt.setFloat("EnergyPerUsage", EnergyPerUsage);
			nbt.setFloat("attackDamage", attackDamage);
			nbt.setFloat("efficiency", efficiency);
		}else{
			NBTTagCompound nbt = stack.getTagCompound();
			nbt.setFloat("EnergyStored", EnergyStored);
			nbt.setFloat("MaxEnergy", MaxEnergy);
			nbt.setFloat("EnergyPerUsage", EnergyPerUsage);
			nbt.setFloat("attackDamage", attackDamage);
			nbt.setFloat("efficiency", efficiency);
		}
		
		if(EnergyStored > MaxEnergy){
			EnergyStored = MaxEnergy;
			}
		
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
	}

	/**
	 * 	
	 * 	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
		return efficiency;
	}
	 * 
	 * 	@Override
	public boolean canHarvestBlock(Block par1Block, ItemStack itemStack) {
		return true;
	}
	 * 
	 * @Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos,
			EntityLivingBase player) {
		
		if(EnergyStored >= block.getBlockHardness(world, pos)){
			this.setEnergyStored(EnergyStored - block.getBlockHardness(world, pos));
			stack.setItemDamage(EnergyStored);
		}
		
		return super.onBlockDestroyed(stack, world, block, pos, player);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		if(EnergyStored >= attackDamage){
			target.attackEntityFrom(DamageSource.generic, attackDamage);
			this.setEnergyStored(EnergyStored - attackDamage);
			stack.setItemDamage(EnergyStored);
		}
		
		return super.hitEntity(stack, target, attacker);
	}
	
	 */
	
}
