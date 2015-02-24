/**
 * Copyright (c) Lambda Innovation, 2013-2015
 * 本作品版权由Lambda Innovation所有。
 * http://www.lambdacraft.cn/
 *
 * AcademyCraft is open-source, and it is distributed under 
 * the terms of GNU General Public License. You can modify
 * and distribute freely as long as you follow the license.
 * AcademyCraft是一个开源项目，且遵循GNU通用公共授权协议。
 * 在遵照该协议的情况下，您可以自由传播和修改。
 * http://www.gnu.org/licenses/gpl.html
 */
package cn.academy.core.register;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Recipes and Smeltings Registration Class
 * @author KSkun
 */
public class ACRecipes {

	public static void regRecipe() {
		GameRegistry.addRecipe(new ItemStack(ACItems.coin, 12), "aaa", "bbb", "aaa", 
				'a', ACItems.ingotNi, 'b', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ACItems.bodyDet), "aba", "aca", "ada",
				'a', ACItems.ingotNi, 'b', Blocks.glass_pane, 'c', ACItems.pcb, 'd', ACItems.crystal);
		GameRegistry.addRecipe(new ItemStack(ACItems.ioPort), "aaa", "aba", " a ",
				'a', ACItems.ingotNi, 'b', ACItems.pcb);
		GameRegistry.addRecipe(new ItemStack(ACItems.brainBeta), "aba", "bcb", "dbe",
				'a', Items.repeater, 'b', Items.gold_ingot, 'c', Items.ender_eye, 'd', ACItems.crystal,
				'e', ACItems.ingotNi);
		GameRegistry.addRecipe(new ItemStack(ACBlocks.solarGen), "aaa", "bcb", "ded",
				'a', ACItems.siliconRod, 'b', ACItems.ingotMg, 'c', ACItems.pcb, 'd', ACItems.ingotAl,
				'e', ACItems.ingotNi);
		GameRegistry.addRecipe(new ItemStack(ACItems.alPlate, 3), "aaa", "   ", "   ",
				'a', ACItems.ingotAl);
		GameRegistry.addRecipe(new ItemStack(ACItems.alPlate, 3), "   ", "aaa", "   ",
				'a', ACItems.ingotAl);
		GameRegistry.addRecipe(new ItemStack(ACItems.alPlate, 3), "   ", "   ", "aaa",
				'a', ACItems.ingotAl);
		GameRegistry.addRecipe(new ItemStack(ACItems.mgPlate, 3), "aaa", "   ", "   ",
				'a', ACItems.ingotMg);
		GameRegistry.addRecipe(new ItemStack(ACItems.mgPlate, 3), "   ", "aaa", "   ",
				'a', ACItems.ingotMg);
		GameRegistry.addRecipe(new ItemStack(ACItems.mgPlate, 3), "   ", "   ", "aaa",
				'a', ACItems.ingotMg);	
		GameRegistry.addShapelessRecipe(new ItemStack(ACItems.aplate1, 2), 
				ACItems.alPlate, ACItems.mgPlate);
		GameRegistry.addRecipe(new ItemStack(ACBlocks.node), "aba", "cdc", "aba",
				'a', Blocks.planks, 'b', Items.iron_ingot, 'c', ACItems.energyCrystal, 'd', ACItems.pcb);
		GameRegistry.addRecipe(new ItemStack(ACItems.copperCoil, 6), "aba", "b a", "aba",
				'a', Items.iron_ingot, 'b', ACItems.ingotNi);
		GameRegistry.addRecipe(new ItemStack(ACBlocks.magInducer), " a ", "aba", " a ",
				'a', ACItems.copperCoil, 'b', ACItems.pcb);
		GameRegistry.addRecipe(new ItemStack(ACBlocks.grid), "aba", "cdc", "aba",
				'a', Blocks.glass_pane, 'b', ACItems.pcb, 'c', ACItems.aplate1, 'd', ACItems.energyCrystal);
		GameRegistry.addRecipe(new ItemStack(ACItems.compPlank), "a  ", "a  ", "a  ",
				'a', Blocks.log);
		GameRegistry.addRecipe(new ItemStack(ACItems.compPlank), " a ", " a ", " a ",
				'a', Blocks.log);
		GameRegistry.addRecipe(new ItemStack(ACItems.compPlank), "  a", "  a", "  a",
				'a', Blocks.log);
		GameRegistry.addRecipe(new ItemStack(ACItems.magHook, 2), "aba", "bcb", "dad",
				'a', Items.iron_ingot, 'b', ACItems.compPlank, 'c', Items.gunpowder, 'd', Items.slime_ball);
		GameRegistry.addRecipe(new ItemStack(ACItems.pcb), "aba", "cdc", "aba",
				'a', ACItems.ingotNi, 'b', ACItems.crystal, 'c', Items.redstone, 'd', Items.iron_ingot);
		GameRegistry.addRecipe(new ItemStack(ACBlocks.developer), "aba", "cdc", "efe",
				'a', ACItems.ioPort, 'b', ACItems.bodyDet, 'c', ACItems.brainBeta, 'd', ACItems.pcb,
				'e', ACBlocks.node, 'f', ACItems.aplate1);
		GameRegistry.addRecipe(new ItemStack(ACItems.siliconRod), "aaa", "a a", "aaa",
				'a', ACItems.smallSi);
		GameRegistry.addRecipe(new ItemStack(ACItems.sibarn), "aba", "bab", "aba",
				'a', ACItems.siliconRod, 'b', ACItems.smallSi);
		GameRegistry.addRecipe(new ItemStack(ACItems.freqReg), "abb", "ccd", "abb",
				'a', ACItems.aplate1, 'b', Blocks.glass_pane, 'c', ACItems.pcb, 'd', ACItems.ioPort);
		GameRegistry.addRecipe(new ItemStack(ACItems.needle, 6), " a ", " a ", " a ",
				'a', Items.iron_ingot);
	}
	
	public static void regSmelting() {
		GameRegistry.addSmelting(Blocks.glass , new ItemStack(ACItems.smallSi), 0f);
		//Ore Smelting
		GameRegistry.addSmelting(ACBlocks.oreAl, new ItemStack(ACItems.ingotAl), 0.7f);
		GameRegistry.addSmelting(ACBlocks.oreCopper, new ItemStack(ACItems.ingotCu), 0.7f);
		GameRegistry.addSmelting(ACBlocks.oreMg, new ItemStack(ACItems.ingotMg), 0.8f);
		GameRegistry.addSmelting(ACBlocks.oreNi, new ItemStack(ACItems.ingotNi), 0.8f);
		//TODO: This recipe isn't available in this version.
//		GameRegistry.addSmelting(ACBlocks.oreTin, new ItemStack(ACItems.ingotTin), 0.7f);
		GameRegistry.addSmelting(ACBlocks.oreCrystal, new ItemStack(ACItems.crystal), 1.2f);
		GameRegistry.addSmelting(ACBlocks.oreShadow, new ItemStack(ACItems.ingotShadow), 1.2f);
	}
	
	public static void regChestGen() {
		WeightedRandomChestContent gens[] = {
				new WeightedRandomChestContent(new ItemStack(ACItems.record0), 1, 1, 5),
				new WeightedRandomChestContent(new ItemStack(ACItems.record1), 1, 1, 5),
				new WeightedRandomChestContent(new ItemStack(ACItems.record2), 1, 1, 5),
		};
		for(WeightedRandomChestContent gen : gens) {
			ChestGenHooks.addItem("dungeonChest", gen);
			ChestGenHooks.addItem("villageBlacksmith", gen);
			ChestGenHooks.addItem("pyramidDesertyChest", gen);
			ChestGenHooks.addItem("pyramidJungleChest", gen);
		}
	}
	
}
