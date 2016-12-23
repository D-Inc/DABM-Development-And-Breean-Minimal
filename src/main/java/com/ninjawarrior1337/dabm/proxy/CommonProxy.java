package com.ninjawarrior1337.dabm.proxy;

import com.ninjawarrior1337.dabm.ConfigHandler;
import com.ninjawarrior1337.dabm.events.FastFlyBreak;
import com.ninjawarrior1337.dabm.events.SuperEvent;
import com.ninjawarrior1337.dabm.events.TerrainEvent;
import com.ninjawarrior1337.dabm.events.ThoriumChestplateMagnet;
import com.ninjawarrior1337.dabm.init.items.RegisterItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by ninjawarrior1337 on 11/20/16.
 */
public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent e)
    {
        RegisterItems.init();
        RegisterItems.register();
    }

    public void Init(FMLInitializationEvent e)
    {
        RegisterItems.registerOreDict();
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new FastFlyBreak());
        MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainEvent());
        MinecraftForge.EVENT_BUS.register(new ThoriumChestplateMagnet());
        MinecraftForge.EVENT_BUS.register(new SuperEvent());
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }

    public static final CreativeTabs tabDAB = new CreativeTabs("DAB")
    {
        @Override
        public ItemStack getTabIconItem()
        {
            return new ItemStack(RegisterItems.thoriumhelmet);
        }

        @Override
        public boolean hasSearchBar()
        {
            return true;
        }
    };
}
