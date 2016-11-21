package com.ninjawarrior1337.dabm.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

import java.util.Set;

/**
 * Created by ninjawarrior1337 on 11/20/16.
 */
public class DABMGuiFactory implements IModGuiFactory
{
        @Override
        public void initialize(Minecraft minecraftInstance) {

    }

        @Override
        public Class<? extends GuiScreen> mainConfigGuiClass() {
        return ConfigGUI.class;
    }

        @Override
        public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

        @Override
        public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) {
        return null;
    }
}


