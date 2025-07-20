package com.crisevic.mapleful.init;

import com.crisevic.mapleful.Mapleful;
import com.crisevic.mapleful.init.effect.AutumnRushEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MaplefulEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, Mapleful.MODID);

    public static final RegistryObject<MobEffect> AUTUMN_RUSH = EFFECTS.register(
            "autumn_rush",
            AutumnRushEffect::new
    );
}