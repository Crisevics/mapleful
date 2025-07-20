package com.crisevic.mapleful.init;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import java.util.function.Supplier;

public class AutumnityItems {
    // Referencia a la botella de sirope de Autumnity
    public static final Supplier<Item> SYRUP_BOTTLE = () -> ForgeRegistries.ITEMS.getValue(
            new ResourceLocation("autumnity:syrup_bottle")
    );

    public static final Supplier<Item> TURKEY_PIECE = () -> ForgeRegistries.ITEMS.getValue(
            new ResourceLocation("autumnity:turkey_piece")
    );

    public static final Supplier<Item> COOKED_TURKEY_PIECE = () -> ForgeRegistries.ITEMS.getValue(
            new ResourceLocation("autumnity:cooked_turkey_piece")
    );

    public static final Supplier<Item> ICE_CUBES = () -> ForgeRegistries.ITEMS.getValue(
            new ResourceLocation("neapolitan:ice_cubes")
    );

    public static final Supplier<Item> ORANGE_MAPLE_LEAF_PILE = () -> ForgeRegistries.ITEMS.getValue(
            new ResourceLocation("autumnity:orange_maple_leaf_pile")
    );
}