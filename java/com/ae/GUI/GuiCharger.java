package com.ae.GUI;

import com.ae.TileEntities.ChargerTE;
import com.ae.TileEntities.BaseClasses.EnergyChargerTE;
import com.ae.main.AdvancedElectronics;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiCharger extends GuiContainer{

	private IInventory playerInv;
	private EnergyChargerTE te;
	private ResourceLocation texture = new ResourceLocation(AdvancedElectronics.MODID + ":textures/gui/charger.png");
	
	public GuiCharger(InventoryPlayer inventory, ChargerTE te) {
		super(new ContainerCharger(inventory, te));
		
	    this.playerInv = inventory;
	    this.te = te;

	    this.xSize = 176;
	    this.ySize = 166;
		
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
	}

}
