package ru.college.i923v.fierysword;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class FierySwordItem extends SwordItem {

    public FierySwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Поджог на 3 секунды (урон огнём ≈ 2 в секунду)
        target.setRemainingFireTicks(60);
        return super.hurtEnemy(stack, target, attacker);
    }

}