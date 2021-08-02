package amymialee.noenchantcap.mixin;

import amymialee.noenchantcap.NoEnchantCap;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin extends Enchantment {
    public InfinityEnchantmentMixin(Enchantment.Weight weight, EquipmentSlot... slotTypes) {super(weight, EnchantmentTarget.BOW, slotTypes);}

    /**@mojang*/
    @Overwrite
    public boolean differs(Enchantment other) {
        if (NoEnchantCap.config.allowAllEnchantmentCombinations) {return true;} else {
            return other instanceof MendingEnchantment ? false : super.differs(other);
        }
    }
}
