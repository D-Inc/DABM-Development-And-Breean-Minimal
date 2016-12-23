package com.ninjawarrior1337.dabm.init.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by ninjawarrior1337 on 12/4/16.
 */
public class RegisterItems
{
    //Items
    //Armor
    public static Item thoriumhelmet;
    public static Item thoriumchestplate;
    public static Item thoriumleggings;
    public static Item thoriumboots;

    //Armor Materials
    public static ItemArmor.ArmorMaterial ThoriumArmor = EnumHelper.addArmorMaterial("ThoriumArmor", "dabm:thorium", -1, new int[] {7, 7, 7, 7}, 2147483647, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, Float.intBitsToFloat(0x7f800000));


    public static void init()
    {
        thoriumhelmet = new ThoriumArmor("thorium_helmet", "thorium_helmet", ThoriumArmor, 1, EntityEquipmentSlot.HEAD);
        thoriumchestplate = new ThoriumArmor("thorium_chestplate", "thorium_chestplate", ThoriumArmor, 1, EntityEquipmentSlot.CHEST);
        thoriumleggings = new ThoriumArmor("thorium_legs", "thorium_legs", ThoriumArmor, 2, EntityEquipmentSlot.LEGS);
        thoriumboots = new ThoriumArmor("thorium_boots", "thorium_boots", ThoriumArmor, 1, EntityEquipmentSlot.FEET);
    }

    public static void register()
    {
        GameRegistry.register(thoriumhelmet);
        GameRegistry.register(thoriumchestplate);
        GameRegistry.register(thoriumleggings);
        GameRegistry.register(thoriumboots);
    }

    public static void registerRenders()
    {
        registerRender(thoriumhelmet);
        registerRender(thoriumchestplate);
        registerRender(thoriumleggings);
        registerRender(thoriumboots);
    }


    private static void  registerRender(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void registerOreDict()
    {

    }
}
