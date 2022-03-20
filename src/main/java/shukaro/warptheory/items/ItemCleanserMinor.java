package shukaro.warptheory.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import shukaro.warptheory.handlers.WarpHandler;
import shukaro.warptheory.util.ChatHelper;
import shukaro.warptheory.util.Constants;
import thaumcraft.common.Thaumcraft;
import thaumcraft.common.lib.research.PlayerKnowledge;

import java.util.Locale;

public class ItemCleanserMinor extends ItemCleanser {
    public static final PlayerKnowledge Knowledge = Thaumcraft.proxy.getPlayerKnowledge();
    private IIcon icon;

    public ItemCleanserMinor() {
        super();
        this.setUnlocalizedName(Constants.ITEM_WARPCLEANSERMINOR);
    }

    @Override
    protected void purgeWarp(EntityPlayer player) {
        String name = player.getDisplayName();
        int wp = Knowledge.getWarpPerm(name);
        
        if (wp < 100) {
            ChatHelper.sendToPlayer(player, StatCollector.translateToLocal("chat.warptheory.purgefail"));
        }else {
            WarpHandler.purgeWarpMinor(player);
        }
    }

    @Override
    protected String getIcon() {
        return "itemCleanserMinor";
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg) {
        this.icon = reg.registerIcon(Constants.modID.toLowerCase(Locale.ENGLISH) + ":itemCleanserMinor");
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
        return icon;
    }

    @Override
    protected String getToolTip() {
        return "tooltip.warptheory.cleanserminor";
    }
}
