package com.ninjawarrior1337.dabm.events;

import com.ninjawarrior1337.dabm.helper.MathHelper;
import com.ninjawarrior1337.dabm.helper.Vector3;
import com.ninjawarrior1337.dabm.init.items.RegisterItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

import static com.ninjawarrior1337.dabm.ConfigHandler.chestplateMagnet;

/**
 * Created by ninjawarrior1337 on 12/4/16.
 */
public class ThoriumChestplateMagnet
{
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onThroiumOnPlayerEvent(LivingEvent.LivingUpdateEvent event) {
        event.getEntity();
        if (event.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntity();
            ItemStack heldItem = player.getHeldItemMainhand();
            double x = player.posX;
            double y = player.posY + 0.75;
            double z = player.posZ;
            World world = player.getEntityWorld();
            if (player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == RegisterItems.thoriumchestplate && chestplateMagnet)
            {
                List<EntityItem> items = player.worldObj.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(x - 10, y - 10, z - 10, x + 10, y + 10, z + 10));
                List<EntityXPOrb> xporbs = player.worldObj.getEntitiesWithinAABB(EntityXPOrb.class, new AxisAlignedBB(x - 10, y - 10, z - 10, x + 10, y + 10, z + 10));
                int pulled = 0;
                for(EntityItem item : items) {
                    if (canPullItem(item)) {
                        if (pulled > 200)
                            break;
                        item.setPickupDelay(0);
                        item.motionX = item.motionY = item.motionZ = 0;
                        item.setPosition(player.posX - 0.2 + (world.rand.nextDouble() * 0.4), player.posY - 0.6, player.posZ - 0.2 + (world.rand.nextDouble() * 0.4));
                        //MathHelper.setEntityMotionFromVector(item, new Vector3(x, y, z), 1.5F);
                        pulled++;
                    }
                }
                for(EntityXPOrb xpOrb : xporbs) {
                    if (canPullXP(xpOrb)) {
                        if (pulled > 200)
                            break;

                        MathHelper.setEntityMotionFromVector(xpOrb, new Vector3(x, y, z), 1.5F);
                    }
                }
            }
        }
    }

    private boolean canPullItem(EntityItem item) {
        return true;
    }
    private boolean canPullXP(EntityXPOrb xpOrb)
    {
        return true;
    }
}
