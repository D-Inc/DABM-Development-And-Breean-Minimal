package com.ninjawarrior1337.dabm.events;

import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by ninjawarrior1337 on 11/21/16.
 */
public class FastFlyBreak
{
    @SubscribeEvent
    public void blockBreakSpeed(PlayerEvent.BreakSpeed event)
    {
        if(!event.getEntityPlayer().onGround && event.getEntityPlayer().capabilities.isFlying)
        {
            float newSpeed = event.getOriginalSpeed() * 5;
            event.setNewSpeed(newSpeed);
        }
    }
}
