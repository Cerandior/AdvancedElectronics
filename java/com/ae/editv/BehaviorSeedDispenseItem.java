package com.ae.editv;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.IBehaviorDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BehaviorSeedDispenseItem implements IBehaviorDispenseItem{

	@Override
	public ItemStack dispense(IBlockSource source, ItemStack stack) {
		   
		    ItemStack itemstack1 = this.dispenseStack(source, stack);
	        this.playDispenseSound(source);
	        this.spawnDispenseParticles(source, BlockDispenser.getFacing(source.getBlockMetadata()));
	        return itemstack1;
	        
	}
	
	 protected ItemStack dispenseStack(IBlockSource source, ItemStack stack)
	    {
	        EnumFacing enumfacing = BlockDispenser.getFacing(source.getBlockMetadata());
	        IPosition iposition = BlockDispenser.getDispensePosition(source);
	        doDispense(source.getWorld(), stack, 6, enumfacing, iposition);
	        return stack;
	    }
	 
	 public static void doDispense(World worldIn, ItemStack stack, int speed, EnumFacing facing, IPosition position)
	    {

	        BlockPos pos = new BlockPos(position.getX(), position.getY(), position.getZ());
	        BlockPos pos0 = new BlockPos(position.getX(), position.getY() - 1, position.getZ());
	        
	        if(worldIn.getBlockState(pos0).getBlock() == Blocks.farmland && worldIn.getBlockState(pos).getBlock() == Blocks.air){
	        	worldIn.setBlockState(pos, Blocks.wheat.getDefaultState());
	        	 ItemStack itemstack1 = stack.splitStack(1);
	        }
	  
	    }
	
	 protected void playDispenseSound(IBlockSource source)
	    {
	        source.getWorld().playAuxSFX(1000, source.getBlockPos(), 0);
	    }

	 
	 protected void spawnDispenseParticles(IBlockSource source, EnumFacing facingIn)
	    {
	        source.getWorld().playAuxSFX(2000, source.getBlockPos(), this.func_82488_a(facingIn));
	    }
	 
	    private int func_82488_a(EnumFacing facingIn)
	    {
	        return facingIn.getFrontOffsetX() + 1 + (facingIn.getFrontOffsetZ() + 1) * 3;
	    }

}
