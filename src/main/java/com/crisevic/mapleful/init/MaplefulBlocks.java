package com.crisevic.mapleful.init;

import com.crisevic.mapleful.Mapleful;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MaplefulBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Mapleful.MODID);

    // Registro del bloque de helado de arce
    public static final RegistryObject<Block> MAPLE_ICE_CREAM_BLOCK = BLOCKS.register("maple_ice_cream_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.COLOR_BROWN)
                    .requiresCorrectToolForDrops()
                    .strength(0.2F)
                    .sound(SoundType.SNOW))
    );

    // Registro del ítem para el bloque de helado
    public static final RegistryObject<Item> MAPLE_ICE_CREAM_BLOCK_ITEM = MaplefulItems.ITEMS.register(
            "maple_ice_cream_block",
            () -> new BlockItem(
                    MAPLE_ICE_CREAM_BLOCK.get(),
                    new Item.Properties()
            )
    );

    // Registro del bloque de pastel de arce personalizado
    public static final RegistryObject<Block> MAPLE_CAKE_BLOCK = BLOCKS.register("maple_cake",
            () -> new MapleCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE))
    );

    // Registro del ítem para el bloque de pastel
    public static final RegistryObject<Item> MAPLE_CAKE_BLOCK_ITEM = MaplefulItems.ITEMS.register(
            "maple_cake",
            () -> new BlockItem(
                    MAPLE_CAKE_BLOCK.get(),
                    new Item.Properties()
            )
    );
}