package shukaro.warptheory.handlers.warpevents;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import shukaro.warptheory.handlers.IWarpEvent;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WarpInventoryScramble extends IWarpEvent {
    public WarpInventoryScramble(int minWarp) {
        super("inventoryscramble", minWarp);
    }

    @Override
    public boolean doEvent(World world, EntityPlayer player) {
        if (world.isRemote)
            return true;

        List<ItemStack> inventoryContents = Lists.newArrayList(player.inventory.mainInventory);
        // We won't move the player's currently selected item.
        inventoryContents.remove(player.inventory.currentItem);

        if (inventoryContents.stream().allMatch(Objects::isNull)) {
            // Nothing to scramble.
            return true;
        }

        Collections.shuffle(inventoryContents);
        for (int i = 0; i < inventoryContents.size(); i++) {
            // Skip over the currently selected index.
            player.inventory.mainInventory[i >= player.inventory.currentItem ? i + 1 : i] =
                    inventoryContents.get(i);
        }

        player.inventory.inventoryChanged = true;
        world.playSoundAtEntity(player, "random.pop", 1.0F, 1.0F);
        // No message for this one.

        return true;
    }
}
