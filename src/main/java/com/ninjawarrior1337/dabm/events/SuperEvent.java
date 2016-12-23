package com.ninjawarrior1337.dabm.events;

import com.ninjawarrior1337.dabm.init.items.RegisterItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.ninjawarrior1337.dabm.ConfigHandler.thoriumleggingstepassist;

/**
 * Created by ninjawarrior1337 on 12/4/16.
 */
public class SuperEvent

{
    static EntityPlayer player;
    static boolean hasLessFlight;
    static boolean hasGreatFlight;
    static boolean hasEnderFlight;
    static boolean hasThoriumFlight;
    static boolean isCreativeMode;
    static boolean isSpectatorMode;
    static boolean isThoriumFlight;
    static World worldIn;

    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onDABLivingEvent(LivingEvent.LivingUpdateEvent event)
    {
        event.getEntity();
        if (event.getEntity() instanceof EntityPlayer) {
            player = (EntityPlayer) event.getEntity();
            isCreativeMode = player.capabilities.isCreativeMode;
            isSpectatorMode = player.isSpectator();
            ItemStack heldItem = player.getHeldItemMainhand();

            //Define Player Location Values
            int posx = (int) player.posX;
            int posy = (int) player.posY;
            int posz = (int) player.posZ;
            BlockPos pos = player.getPosition();

            //Get Block Under Player
            Block getBlockUnderPlayer = player.worldObj.getBlockState(new BlockPos(posx, posy-1, posz)).getBlock();

            // LessFlightEvent
//            if (heldItem != null && heldItem.getItem() == RegisterItems.LessFlight) {
//                player.capabilities.allowFlying = true;
//                hasLessFlight = true;
//            } else {
//                hasLessFlight = false;
//            }

            // GreaterFlightEvent
//            if (getGreatRing(player) != null | player.inventory.hasItemStack(new ItemStack(RegisterItems.GreatFlight))) {
//                player.capabilities.allowFlying = true;
//                hasGreatFlight = true;
//            } else {
//                hasGreatFlight = false;
//            }
            // EnderFlightEvent
//            if (player.getInventoryEnderChest().getStackInSlot(0) != null && player.getInventoryEnderChest().getStackInSlot(0).getItem() == RegisterItems.EnderFlight)
//            {
//                player.capabilities.allowFlying = true;
//                hasEnderFlight = true;
//            }
//            else
//            {
//                hasEnderFlight = false;
//            }
            if (player.getEquipmentAndArmor().toString().contains("1xitem.thorium_boots@0, 1xitem.thorium_legs@0, 1xitem.thorium_chestplate@0, 1xitem.thorium_helmet@0"))
            {
                player.capabilities.allowFlying = true;
                player.capabilities.setFlySpeed(0.2F);
                player.capabilities.setPlayerWalkSpeed(0.3F);
                hasThoriumFlight = true;
                if(player.capabilities.isFlying)
                {
                    isThoriumFlight = true;
                }
                else
                {
                    isThoriumFlight = false;
                }
            }
            else
            {
                hasThoriumFlight = false;
            }
            if(player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == RegisterItems.thoriumhelmet)
            {
                player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("night_vision"), 20, 20, false, false));
                player.addPotionEffect(new PotionEffect(Potion.getPotionById(23), 20, 0, false, false));
            }

            if(player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == RegisterItems.thoriumleggings)
            {

                player.stepHeight = thoriumleggingstepassist;
            }
            else
            {
                player.stepHeight = 0.5F;
            }
            // Disable flight if they don't have Greater or Lesser Flight or EnderFlight ring and if they aren't in creative or spectator mode.
            if (!hasThoriumFlight & !isCreativeMode & !isSpectatorMode)
            {
                player.capabilities.isFlying = false;
                player.capabilities.allowFlying = false;
            }
            if (!hasThoriumFlight & !isSpectatorMode)
            {
                player.capabilities.setFlySpeed(0.1F);
                player.capabilities.setPlayerWalkSpeed(0.1F);
            }
            if (!hasThoriumFlight & !isSpectatorMode & !isThoriumFlight);
            {
                
            }
        }
    }
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEntityGetHurt(LivingHurtEvent e)
    {
        if (e.getEntity() instanceof EntityPlayer)
        {
            player = (EntityPlayer) e.getEntity();
            isCreativeMode = player.capabilities.isCreativeMode;
            isSpectatorMode = player.isSpectator();
            ItemStack heldItem = player.getHeldItemMainhand();

            if (player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == RegisterItems.thoriumhelmet && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == RegisterItems.thoriumchestplate && player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == RegisterItems.thoriumleggings && player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == RegisterItems.thoriumboots) {
                if (e.getEntity() instanceof EntityPlayer) {
                    e.setCanceled(true);
                }
            }
        }
    }
//    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
//    public void onPlayerPickupXP(PlayerPickupXpEvent xpEvent) {
//        if (xpEvent.getEntity() instanceof EntityPlayer) {
//            player = (EntityPlayer) xpEvent.getEntity();
//            isCreativeMode = player.capabilities.isCreativeMode;
//            isSpectatorMode = player.isSpectator();
//            ItemStack heldItem = player.getHeldItemMainhand();
//
//            if (heldItem != null && heldItem.getItem() == RegisterItems.thoriumsword | heldItem.getItem() == RegisterItems.multitool) {
//                xpEvent.getOrb().xpValue *= swordxpmultiplier;
//            }
//        }
//    }
}
