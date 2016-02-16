package com.ae.tools;

import java.util.List;

import com.ae.main.AdvancedElectronics;
import com.ae.tools.BaseClasses.BaseTool;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class energyTool extends BaseTool {

	public energyTool(){
		this.setUnlocalizedName("testTool");
		this.setMaxEnergy(1000000);
		this.setEnergyStored(1000000);
		this.setAttackDamage(50F);
		this.setEfficiency(100F);
		this.setEnergyPerUsage(10);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean advanced) {
		
		if(stack.hasTagCompound()){
		NBTTagCompound nbt = stack.getTagCompound();
		list.add("Current Energy: " + nbt.getInteger("EnergyStored"));
		}
		super.addInformation(stack, player, list, advanced);
	}
	
	@Override
	public float getStrVsBlock(ItemStack stack, Block block) {
		return this.efficiency;
	}
	
	@Override
	public double getDurabilityForDisplay(ItemStack stack) {
		return 1 - (this.getEnergyStored() / this.getMaxEnergy());
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, Block block, BlockPos pos,
			EntityLivingBase player) {
		
		if(EnergyStored >= block.getBlockHardness(world, pos)){
			if(stack.getTagCompound() != null){
				this.EnergyStored = stack.getTagCompound().getFloat("EnergyStored") - this.EnergyPerUsage;
			}
			//this.setEnergyStored((int) (EnergyStored - block.getBlockHardness(world, pos)));
			//stack.damageItem((int) block.getBlockHardness(world, pos), player);
		}else{
			if(!world.isRemote){
			player.addChatMessage(new ChatComponentText("Out of Energy"));
			}
		}
		
		return super.onBlockDestroyed(stack, world, block, pos, player);
	}
	
	@Override
	public boolean canHarvestBlock(Block blockIn) {
		return true;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if(stack.getTagCompound() != null){
			NBTTagCompound nbt = stack.getTagCompound();
			EnergyStored = nbt.getFloat("EnergyStored") + 100000;
		}
		
		return super.onItemRightClick(stack, world, player);
	}
	
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker) {
		
		if(EnergyStored >= attackDamage){
			target.attackEntityFrom(DamageSource.generic, attackDamage);
			if(stack.getTagCompound() != null){
				if(this.EnergyStored <= this.MaxEnergy){
				this.EnergyStored = stack.getTagCompound().getFloat("EnergyStored") - this.EnergyPerUsage;
				}
			}
			//this.setEnergyStored((int) (EnergyStored - attackDamage));
			//stack.damageItem((int) attackDamage, attacker);
		}
		
		return super.hitEntity(stack, target, attacker);
	}

}

