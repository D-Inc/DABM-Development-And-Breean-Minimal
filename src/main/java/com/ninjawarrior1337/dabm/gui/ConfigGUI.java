package com.ninjawarrior1337.dabm.gui;

import com.ninjawarrior1337.dabm.ConfigHandler;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import java.util.List;

/**
 * Created by ninjawarrior1337 on 11/20/16.
 */
public class ConfigGUI extends GuiConfig
{
    public ConfigGUI(GuiScreen parentScreen)
    {
        super(parentScreen, new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), "dabm", false, false, "DABM configs man...TOO POWERFULL", GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
}
