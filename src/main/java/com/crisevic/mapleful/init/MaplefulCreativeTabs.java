package com.crisevic.mapleful.init;

import com.crisevic.mapleful.Mapleful;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MaplefulCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Mapleful.MODID);

    // Definimos la clave manualmente para evitar problemas con getKey() nulo
    public static final ResourceKey<CreativeModeTab> MAPLEFUL_TAB_KEY =
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, new ResourceLocation(Mapleful.MODID, "mapleful_tab"));

    public static final RegistryObject<CreativeModeTab> MAPLEFUL_TAB = CREATIVE_TABS.register("mapleful_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.mapleful"))
                    .icon(() -> new ItemStack(MaplefulItems.MAPLE_ICE_CREAM.get())) // Asegúrate que AutumnityItems esté cargado
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_TABS.register(modEventBus);
        modEventBus.addListener(MaplefulCreativeTabs::addItemsToTab);
    }

    private static void addItemsToTab(BuildCreativeModeTabContentsEvent event) {
        // Comparamos con la clave manual en vez de getKey() del RegistryObject
        if (event.getTabKey().equals(MAPLEFUL_TAB_KEY)) {
            event.accept(MaplefulItems.MAPLE_ICE_CREAM.get());
            event.accept(MaplefulItems.MAPLE_MILKSHAKE.get());
            event.accept(MaplefulBlocks.MAPLE_ICE_CREAM_BLOCK.get().asItem());
            event.accept(MaplefulItems.MAPLE_CAKE_BLOCK.get());
            event.accept(MaplefulItems.TURKEY_SOUP);
            event.accept(MaplefulItems.TURKEY_SANDWICH);
            event.accept(MaplefulItems.DOUGH);
            event.accept(MaplefulItems.MAPLE_BUN);
            event.accept(MaplefulItems.MAPLE_LEAF);
        }
    }
}
