package com.ninjawarrior1337.dabm.init.items;

import com.ninjawarrior1337.dabm.proxy.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

import static com.ninjawarrior1337.dabm.ConfigHandler.chestplateMagnet;

/**
 * Created by ninjawarrior1337 on 12/4/16.
 */
public class ThoriumArmor extends ItemArmor
{
    public ThoriumArmor(String unlocalizedname, String registryname, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setUnlocalizedName(unlocalizedname);
        this.setRegistryName(registryname);
        setCreativeTab(CommonProxy.tabDAB);
    }

    @Override
    public boolean hasEffect(ItemStack itemStack)
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced)
    {
        if (stack.getItem() == RegisterItems.thoriumchestplate)
        toolTip.add(TextFormatting.DARK_BLUE + "Magnet Mode = " + chestplateMagnet);
    }


}
