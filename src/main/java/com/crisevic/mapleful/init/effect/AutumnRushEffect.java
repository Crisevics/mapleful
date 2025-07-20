package com.crisevic.mapleful.init.effect;

import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class AutumnRushEffect extends MobEffect {
    public AutumnRushEffect() {
        super(MobEffectCategory.BENEFICIAL, 0xFFA500); // Color naranja otoñal
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amplifier) {
        // Solo aplica si el efecto está activo
        entity.addEffect(new MobEffectInstance(
                MobEffects.MOVEMENT_SPEED,
                40, // 2 segundos (se renovará)
                amplifier,
                false,
                false
        ));
    }

    @Override
    public boolean isDurationEffectTick(int duration, int amplifier) {
        // Ejecutar cada 20 ticks (1 segundo)
        return duration % 20 == 0;
    }
}

