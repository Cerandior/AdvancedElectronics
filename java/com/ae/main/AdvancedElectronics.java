package com.ae.main;


import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import com.ae.GUI.GuiHandler;
import com.ae.TileEntities.ChargerTE;
import com.ae.TileEntities.BaseClasses.EnergyChargerTE;
import com.ae.blocks.Charger;
import com.ae.client.ItemRenderer;
import com.ae.editv.BehaviorMelonDispenseItem;
import com.ae.editv.BehaviorPumpkinDispenseItem;
import com.ae.editv.BehaviorSeedDispenseItem;
import com.ae.proxies.proxylib;
import com.ae.tools.flintAxe;
import com.ae.tools.flintHoe;
import com.ae.tools.flintPickaxe;
import com.ae.tools.flintShovel;
import com.ae.tools.flintSword;
import com.ae.tools.BaseClasses.BaseTool;
import com.ae.tools.energyTool;

import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = AdvancedElectronics.MODID, name = AdvancedElectronics.NAME, version = AdvancedElectronics.VERSION)

public class AdvancedElectronics {

	public static final String MODID = "ae";
	public static final String NAME = "AdvancedElectronics";
	public static final String VERSION = "1.0";
	
	@Instance
	public static AdvancedElectronics instance;
	
	@SidedProxy(clientSide = proxylib.CLIENTSIDE, serverSide = proxylib.SERVERSIDE)
	
	public static serverProxy proxy;
	
	public static int ChargerGUIID = 0;
	
	//Creative Tab
	public static CreativeTabs aeTab = new aeTab(CreativeTabs.getNextID(), "Advanced Electronics");
	
	//Armor Material
	
	//Tool Material
	public static Item.ToolMaterial flintMat = EnumHelper.addToolMaterial("flintMat", 1, 160, 5.0F, 1.5F, 10);
	
	//Items

	public static Item testItem;
	
	/**
	 * To add:
	 * New tools to help the player have a better beginning of the game (Done !)
	 * New ores, (probably different metals or non-metals (To do)
	 * New redstone machines (To Do)
	 * New energy system (probably a redstone liquid) (To Do)
	 * New power machines (To Do)
	 * New energy tools (To Do)
	 * New energy armor (To Do)
	 * Possibly a book with all the mod contents (To Do)
	 * --------------------------------------------------------- Soon when i get more ideas
	 */
	
	
	//Blocks
	public static Block Charger;

	//Tools
	public static ItemAxe flintAxe;
	public static ItemSword flintSword;
	public static ItemSpade flintShovel;
	public static ItemPickaxe flintPickaxe;
	public static ItemHoe flintHoe;
	
	public static Item energyTool;
	
	
	//Misc
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		//Items
		
		
		//Blocks
		Charger = new Charger();
		
		//Tools
		
		flintAxe = new flintAxe();
		flintSword = new flintSword();
		flintShovel = new flintShovel();
		flintPickaxe = new flintPickaxe();
		flintHoe = new flintHoe();
		
		energyTool = new energyTool();
		
		//Machine
		
		//Misc
		
		//Registering Items
		
		//Registering TE
		GameRegistry.registerTileEntity(EnergyChargerTE.class, "EnergyChargerTE");
		GameRegistry.registerTileEntity(ChargerTE.class, "ChargerTE");

		//Registering Blocks
		GameRegistry.registerBlock(Charger, Charger.getUnlocalizedName().substring(5));		
		
		//Registering Tools
		GameRegistry.registerItem(flintAxe, flintAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flintSword, flintSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flintShovel, flintShovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flintPickaxe, flintPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(flintHoe, flintHoe.getUnlocalizedName().substring(5));
		
		GameRegistry.registerItem(energyTool, energyTool.getUnlocalizedName().substring(5));
		
		
		//Registering Misc
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) {
		
		proxy.registerRenderInfo();
		NetworkRegistry.INSTANCE.registerGuiHandler(this.instance, new GuiHandler());

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		BlockDispenser.dispenseBehaviorRegistry.putObject(Items.wheat_seeds, new BehaviorSeedDispenseItem());
		BlockDispenser.dispenseBehaviorRegistry.putObject(Items.pumpkin_seeds, new BehaviorPumpkinDispenseItem());
		BlockDispenser.dispenseBehaviorRegistry.putObject(Items.melon_seeds, new BehaviorMelonDispenseItem());
	
	}
	
}
