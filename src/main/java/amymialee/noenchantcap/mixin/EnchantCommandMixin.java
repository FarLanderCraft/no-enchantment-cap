package amymialee.noenchantcap.mixin;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.command.EnchantCommand;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Collection;

@Mixin(EnchantCommand.class)
public class EnchantCommandMixin {

    @Redirect(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;getMaximumLevel()I"))
    private static int redirectGetMaxLevel(Enchantment enchantment) {
        return 32766;
    }

    @Redirect(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;isAcceptableItem(Lnet/minecraft/item/ItemStack;)Z"))
    private static boolean redirectIsAcceptableItem(Enchantment enchantment, ItemStack stack) {
        return true;
    }


    /*broken as of now*/
    @Redirect(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;isCompatible(Ljava/util/Collection;Lnet/minecraft/enchantment/Enchantment;)Z"))
    private static boolean redirectIsCompatible(Collection<Enchantment> existing, Enchantment candidate) {
        return true;
    }

    @Redirect(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;addEnchantment(Lnet/minecraft/enchantment/Enchantment;I)V"))
    private static void redirectAddEnchantment(ItemStack itemStack, Enchantment enchantment, int level) {
        itemStack.getOrCreateSubTag("");
        try {
            assert itemStack.getTag() != null;
            if (!itemStack.getTag().contains("Enchantments", 9)) {
                itemStack.getTag().put("Enchantments", new ListTag());
            }
        } catch (Exception ignored) {}

        ListTag listTag = itemStack.getOrCreateSubTag("").getList("Enchantments", 10);
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("id", String.valueOf(Enchantment.REGISTRY.getId(enchantment)));
        compoundTag.putInt("lvl", level);
        listTag.add(compoundTag);
    }
}
