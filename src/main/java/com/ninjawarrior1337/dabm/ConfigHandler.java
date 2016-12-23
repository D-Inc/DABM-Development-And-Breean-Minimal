package com.ninjawarrior1337.dabm;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

import static net.minecraftforge.common.config.Configuration.CATEGORY_GENERAL;

/**
 * Created by ninjawarrior1337 on 11/20/16.
 */
public class ConfigHandler
{
    public static Configuration config;

    public static boolean chestplateMagnet;
    public static int treeSpawnPercentage;
    public static int flowerSpawnPercentage;
    public static int grassSpawnPercentage;
    public static float thoriumleggingstepassist;

    public static void init(File file)
    {
        if(config == null)
        {
            config = new Configuration(file);
            syncConfig();
        }
    }

    public static void syncConfig()
    {
        treeSpawnPercentage = config.getInt("Tree Spawn Percentage", CATEGORY_GENERAL, 100, 0, 100, null);
        flowerSpawnPercentage = config.getInt("Flower Spawn Percentage", CATEGORY_GENERAL, 100, 0, 100, null);
        grassSpawnPercentage = config.getInt("Grass Spawn Percentage", CATEGORY_GENERAL, 100, 0, 100, null);
        chestplateMagnet = config.getBoolean("Enable Thorium Chestplate Magnet", CATEGORY_GENERAL, true, null);
        thoriumleggingstepassist = config.getFloat("Thorium Legging Step Assist Height", CATEGORY_GENERAL, 1,0, 2147483647, null);

        if(config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.getModID().equalsIgnoreCase(Reference.modid))
        {
            syncConfig();
        }

    }
}
