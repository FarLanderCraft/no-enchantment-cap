package amymialee.noenchantcap.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Redirect;

import static amymialee.noenchantcap.NoEnchantCap.config;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
    @Redirect(method = "updateResult", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;getMaximumLevel()I"))
    private int redirectGetMaxLevel(Enchantment enchantment) {
        if (enchantment.getMaximumLevel() == 1) {
            return 1;
        } else {
            if (config.useGlobalEnchantCap) {
                return config.globalEnchantCap;
            } else {
                switch (enchantment.getTranslationKey()) {
                    case "enchantment.minecraft.sharpness":
                        return config.sharpnessCap;
                    case "enchantment.minecraft.smite":
                        return config.smiteCap;
                    case "enchantment.minecraft.bane_of_arthropods":
                        return config.baneOfArthropodsCap;
                    case "enchantment.minecraft.knockback":
                        return config.knockbackCap;
                    case "enchantment.minecraft.fire_aspect":
                        return config.fireAspectCap;
                    case "enchantment.minecraft.protection":
                        return config.protectionCap;
                    case "enchantment.minecraft.fire_protection":
                        return config.protectionFireCap;
                    case "enchantment.minecraft.feather_falling":
                        return config.featherFallingCap;
                    case "enchantment.minecraft.blast_protection":
                        return config.protectionBlastCap;
                    case "enchantment.minecraft.projectile_protection":
                        return config.protectionProjectileCap;
                    case "enchantment.minecraft.respiration":
                        return config.respirationCap;
                    case "enchantment.minecraft.depth_strider":
                        return config.depthStriderCap;
                    case "enchantment.minecraft.efficiency":
                        return config.efficiencyCap;
                    case "enchantment.minecraft.unbreaking":
                        return config.unbreakingCap;
                    case "enchantment.minecraft.looting":
                        return config.lootingCap;
                    case "enchantment.minecraft.fortune":
                        return config.fortuneCap;
                    case "enchantment.minecraft.luck_of_the_sea":
                        return config.luckOfTheSeaCap;
                    case "enchantment.minecraft.lure":
                        return config.lureCap;
                    case "enchantment.minecraft.power":
                        return config.powerCap;
                    case "enchantment.minecraft.punch":
                        return config.punchCap;
                    case "enchantment.minecraft.thorns":
                        return config.thornsCap;
                    default:
                        return config.globalEnchantCap;
                }
            }
        }
    }

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40, ordinal = 1))
    private int modifyMaxCost(int original) {
        if (config.removeAnvilLimit) {
            return 50000;
        } else {
            return original;
        }
    }
}
