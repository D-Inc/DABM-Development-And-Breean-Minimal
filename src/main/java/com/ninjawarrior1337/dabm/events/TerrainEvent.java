package com.ninjawarrior1337.dabm.events;

import com.ninjawarrior1337.dabm.ConfigHandler;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by ninjawarrior1337 on 11/20/16.
 */
public class TerrainEvent
{
    public static boolean getRandomTreeBoolean()
    {
        return Math.random() < ConfigHandler.treeSpawnPercentage/100;
    }

    public static boolean getRandomFlowerBoolean()
    {
        return Math.random() < ConfigHandler.flowerSpawnPercentage/100;
    }

    public static boolean getRandomGrassBoolean()
    {
        return Math.random() < ConfigHandler.grassSpawnPercentage/100;
    }

    @SubscribeEvent(receiveCanceled = true)
    public void onDecorateEvent(DecorateBiomeEvent.Decorate event)
    {
        if(event.getType() == DecorateBiomeEvent.Decorate.EventType.GRASS && !getRandomGrassBoolean())
        {
            event.setResult(Event.Result.DENY);
        }
        if(event.getType() == DecorateBiomeEvent.Decorate.EventType.FLOWERS && !getRandomFlowerBoolean())
        {
            event.setResult(Event.Result.DENY);
        }
        if (event.getType() == DecorateBiomeEvent.Decorate.EventType.TREE && !getRandomTreeBoolean())
        {
            event.setResult(Event.Result.DENY);
        }
    }
}
