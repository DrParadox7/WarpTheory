package shukaro.warptheory.recipe;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import shukaro.warptheory.handlers.ConfigHandler;
import shukaro.warptheory.items.WarpItems;
import shukaro.warptheory.research.WarpResearch;
import shukaro.warptheory.util.Constants;
import thaumcraft.api.ItemApi;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
import cpw.mods.fml.common.Loader;

import java.util.ArrayList;

public class WarpRecipes {
    public static ArrayList<ItemStack> meats = new ArrayList<ItemStack>();

    private static void initMeats() {
        meats.add(new ItemStack(Items.chicken));
        meats.add(new ItemStack(Items.beef));
        meats.add(new ItemStack(Items.porkchop));
        meats.add(new ItemStack(Items.fish));
    }
    public static void init() {
        initMeats();
     if (!ConfigHandler.wussMode) {
           WarpResearch.recipes.put("PureTearMinor", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_WARPCLEANSERMINOR, new ItemStack(WarpItems.itemCleanserMinor), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(Items.ghast_tear), new ItemStack[]{new ItemStack(Items.nether_star), ItemApi.getItem("itemResource", 12), ItemApi.getItem("itemResource", 11), ItemApi.getItem("itemResource", 17), ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 17), ItemApi.getItem("itemResource", 11), ItemApi.getItem("itemResource", 12)}));
           WarpResearch.recipes.put("PureAmulet", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_PURE_TALISMAN, new ItemStack(WarpItems.itemAmulet), 10, new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 64), ItemApi.getItem("itemBaubleBlanks", 0), new ItemStack[]{ItemApi.getItem("itemResource", 15), new ItemStack(WarpItems.itemCleanser), ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 15), ItemApi.getItem("itemResource", 14), new ItemStack(WarpItems.itemCleanser)}));

           for (ItemStack meat : meats)
            WarpResearch.recipes.put("WarpChunk" + meat, ThaumcraftApi.addCrucibleRecipe(Constants.ITEM_SOMETHING, new ItemStack(WarpItems.itemSomething), meat, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 8)));
            ThaumcraftApi.addWarpToItem(new ItemStack(WarpItems.itemSomething), 1);

           WarpResearch.recipes.put("Litmus", ThaumcraftApi.addShapelessArcaneCraftingRecipe(Constants.ITEM_LITMUS, new ItemStack(WarpItems.itemPaper), new AspectList().add(Aspect.WATER, 8), ItemApi.getItem("itemResource", 14), new ItemStack(Items.paper), ItemApi.getItem("itemResource", 14)));
            
            if (!Loader.isModLoaded("WitchingGadgets")) {
                WarpResearch.recipes.put("PureTear", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_WARPCLEANSER, new ItemStack(WarpItems.itemCleanser), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(WarpItems.itemCleanserMinor), new ItemStack[]{ItemApi.getBlock("blockCustomPlant", 4), new ItemStack(Items.nether_star), ItemApi.getItem("itemResource", 14), new ItemStack(Items.nether_star), ItemApi.getItem("itemResource", 14), new ItemStack(Items.nether_star),}));
               } else {
                WarpResearch.recipes.put("PureTear", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_WARPCLEANSER, new ItemStack(WarpItems.itemCleanser), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(WarpItems.itemCleanserMinor), new ItemStack[]{ItemApi.getBlock("blockCustomPlant", 4), ItemApi.getItem("itemEldritchObject", 3), ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemEldritchObject", 3), ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemEldritchObject", 3)}));
            }
        } else {
             WarpResearch.recipes.put("PureTearMinor", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_WARPCLEANSERMINOR, new ItemStack(WarpItems.itemCleanserMinor), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(Items.ghast_tear), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 14), new ItemStack(Items.quartz), new ItemStack(Items.quartz)}));

             WarpResearch.recipes.put("PureTear", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_WARPCLEANSER, new ItemStack(WarpItems.itemCleanser), 5, new AspectList().add(Aspect.ELDRITCH, 16).add(Aspect.EXCHANGE, 16), new ItemStack(Items.ghast_tear), new ItemStack[]{ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 14), new ItemStack(Items.quartz), new ItemStack(Items.quartz)}));

             WarpResearch.recipes.put("PureAmulet", ThaumcraftApi.addInfusionCraftingRecipe(Constants.ITEM_PURE_TALISMAN, new ItemStack(WarpItems.itemAmulet), 10, new AspectList().add(Aspect.ELDRITCH, 32).add(Aspect.EXCHANGE, 32).add(Aspect.MAGIC, 64), ItemApi.getItem("itemBaubleBlanks", 0), new ItemStack[]{ItemApi.getItem("itemResource", 15), new ItemStack(WarpItems.itemCleanser), ItemApi.getItem("itemResource", 14), ItemApi.getItem("itemResource", 15), ItemApi.getItem("itemResource", 14), new ItemStack(WarpItems.itemCleanser)}));

             for (ItemStack meat : meats)
               WarpResearch.recipes.put("WarpChunk" + meat, ThaumcraftApi.addCrucibleRecipe(Constants.ITEM_SOMETHING, new ItemStack(WarpItems.itemSomething), meat, new AspectList().add(Aspect.ELDRITCH, 8)));
             ThaumcraftApi.addWarpToItem(new ItemStack(WarpItems.itemSomething), 1);

            WarpResearch.recipes.put("Litmus", ThaumcraftApi.addShapelessArcaneCraftingRecipe(Constants.ITEM_LITMUS, new ItemStack(WarpItems.itemPaper), new AspectList().add(Aspect.WATER, 4), new ItemStack(Items.paper), ItemApi.getItem("itemResource", 14)));
        }
    }
}
