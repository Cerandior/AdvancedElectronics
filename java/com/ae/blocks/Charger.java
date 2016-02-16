package com.ae.blocks;

import com.ae.TileEntities.ChargerTE;
import com.ae.main.AdvancedElectronics;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;

public class Charger extends Block {

	public Charger() {
		super(Material.iron);
		this.setUnlocalizedName("Charger");
		this.setCreativeTab(AdvancedElectronics.aeTab);
	}
	
	@Override
	public boolean hasTileEntity() {
		return true;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		TileEntity TE = worldIn.getTileEntity(pos);
		if(!playerIn.isSneaking()){
			playerIn.openGui(AdvancedElectronics.instance, AdvancedElectronics.ChargerGUIID, worldIn, x, y, z);
		}
		
		
		return super.onBlockActivated(worldIn, pos, state, playerIn, side, hitX, hitY, hitZ);
	}
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new ChargerTE();
	}
	
}
