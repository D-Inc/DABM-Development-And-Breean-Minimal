package com.ninjawarrior1337.dabm.proxy;

import com.ninjawarrior1337.dabm.ConfigHandler;
import com.ninjawarrior1337.dabm.events.FastFlyBreak;
import com.ninjawarrior1337.dabm.events.TerrainEvent;
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

    }

    public void Init(FMLInitializationEvent e)
    {
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());
        MinecraftForge.EVENT_BUS.register(new FastFlyBreak());
        MinecraftForge.TERRAIN_GEN_BUS.register(new TerrainEvent());
    }

    public void postInit(FMLPostInitializationEvent e)
    {

    }
}
