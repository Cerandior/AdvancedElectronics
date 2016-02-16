package com.ae.main;

import java.awt.image.BufferedImage;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Color;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import com.ae.client.BlockRenderer;
import com.ae.client.ItemRenderer;

import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class clientProxy extends serverProxy{

	
	@Override
	public void registerRenderInfo(){
		ItemRenderer.registerItemRender();
		BlockRenderer.registerBlockRender();
	}
	
	
}
