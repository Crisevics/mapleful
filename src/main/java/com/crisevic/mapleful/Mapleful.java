package com.crisevic.mapleful;

import com.crisevic.mapleful.init.MaplefulBlocks;
import com.crisevic.mapleful.init.MaplefulCreativeTabs;
import com.crisevic.mapleful.init.MaplefulEffects;
import com.crisevic.mapleful.init.MaplefulItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("mapleful")
public class Mapleful {
    public static final String MODID = "mapleful";

    public Mapleful() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Llama al metodo register que inicializa y registra los items
        MaplefulItems.register(modEventBus);
        MaplefulBlocks.BLOCKS.register(modEventBus);
        MaplefulEffects.EFFECTS.register(modEventBus);

        // Registra las pestañas creativas y sus listeners
        MaplefulCreativeTabs.register(modEventBus);
    }
}
