package com.ninjawarrior1337.dabm.helper;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

/**
 * Created by ninjawarrior1337 on 12/4/16.
 */
public class FuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        Block blockFuel = Block.getBlockFromItem(fuel.getItem());
        Item itemFuel = fuel.getItem();

        if (itemFuel == null)
        {
            return 2147483647;//replace 0 with the number of ticks you want your Block or Item to burn. There are 20 ticks in a second. It takes 10 seconds to make one item.
        }
        return 0;
    }
}
