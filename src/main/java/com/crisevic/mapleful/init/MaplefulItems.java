package com.crisevic.mapleful.init;

import com.crisevic.mapleful.Mapleful;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class MaplefulItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Mapleful.MODID);

    public static RegistryObject<Item> MAPLE_ICE_CREAM;
    public static RegistryObject<Item> MAPLE_MILKSHAKE;
    public static RegistryObject<Item> MAPLE_ICE_CREAM_BLOCK;
    public static RegistryObject<Item> MAPLE_CAKE_BLOCK;
    public static RegistryObject<Item> TURKEY_SOUP;
    public static RegistryObject<Item> TURKEY_SANDWICH;
    public static RegistryObject<Item> DOUGH;
    public static RegistryObject<Item> MAPLE_BUN;
    public static RegistryObject<Item> MAPLE_LEAF;

    public static void register(IEventBus eventBus) {
        MAPLE_ICE_CREAM = registerFoodItem("maple_ice_cream", 6, 0.8f,
                () -> new MobEffectInstance(MaplefulEffects.AUTUMN_RUSH.get(), 600, 1)
        );

        MAPLE_MILKSHAKE = registerDrinkItem("maple_milkshake", 8, 1.0f,
                () -> new MobEffectInstance(MaplefulEffects.AUTUMN_RUSH.get(), 600, 1)
        );

        MAPLE_ICE_CREAM_BLOCK = MaplefulBlocks.MAPLE_ICE_CREAM_BLOCK_ITEM;
        MAPLE_CAKE_BLOCK = MaplefulBlocks.MAPLE_CAKE_BLOCK_ITEM;

        TURKEY_SOUP = registerFoodItem("turkey_soup", 12, 1.0f, null);
        TURKEY_SANDWICH = registerFoodItem("turkey_sandwich", 7, 0.8f, null);
        DOUGH = registerSimpleItem("dough");
        MAPLE_BUN = registerFoodItem("maple_bun", 6, 0.8f, null);
        MAPLE_LEAF = registerSimpleItem("maple_leaf");

        ITEMS.register(eventBus);
    }

    private static RegistryObject<Item> registerSimpleItem(String name) {
        return ITEMS.register(name, () -> new Item(new Item.Properties()));
    }

    private static RegistryObject<Item> registerFoodItem(String name, int nutrition, float saturation) {
        return registerFoodItem(name, nutrition, saturation, null);
    }

    private static RegistryObject<Item> registerFoodItem(String name, int nutrition, float saturation,
                                                         @Nullable Supplier<MobEffectInstance> effectSupplier) {
        return ITEMS.register(name, () -> new Item(new Item.Properties().food(
                createFoodProperties(nutrition, saturation, effectSupplier)
        )));
    }

    private static RegistryObject<Item> registerDrinkItem(String name, int nutrition, float saturation) {
        return registerDrinkItem(name, nutrition, saturation, null);
    }

    private static RegistryObject<Item> registerDrinkItem(String name, int nutrition, float saturation,
                                                          @Nullable Supplier<MobEffectInstance> effectSupplier) {
        return ITEMS.register(name, () -> new DrinkItem(new Item.Properties().food(
                createFoodProperties(nutrition, saturation, effectSupplier)
        )));
    }

    private static FoodProperties createFoodProperties(int nutrition, float saturation,
                                                       @Nullable Supplier<MobEffectInstance> effectSupplier) {
        FoodProperties.Builder builder = new FoodProperties.Builder()
                .nutrition(nutrition)
                .saturationMod(saturation);

        if (effectSupplier != null) {
            builder.effect(effectSupplier, 1.0F);
        }

        return builder.build();
    }
}
