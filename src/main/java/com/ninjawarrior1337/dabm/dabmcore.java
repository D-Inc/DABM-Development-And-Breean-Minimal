package com.ninjawarrior1337.dabm;

import com.ninjawarrior1337.dabm.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.io.File;

/**
 * Created by ninjawarrior1337 on 11/20/16.
 */
@Mod(modid = Reference.modid, version = Reference.VERSION, name = Reference.MODNAME, guiFactory = "com.ninjawarrior1337.dabm.gui.DABMGuiFactory")
public class dabmcore
{
    @SidedProxy(clientSide="com.ninjawarrior1337.dabm.proxy.ClientProxy", serverSide="com.ninjawarrior1337.dabm.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static File configDir;

    public static File getConfigDir()
    {
        return configDir;
    }

    @Mod.Instance("dabm")
    public static dabmcore instance;


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit(e);
        //Config
        configDir = new File(e.getModConfigurationDirectory() + "/" + Reference.modid);
        configDir.mkdirs();
        ConfigHandler.init(new File(configDir.getPath(), Reference.modid + ".cfg"));
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent e)
    {
        proxy.Init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit(e);
    }
}
