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
    private int redirectGetMaximumLevel(Enchantment enchantment) {
        return 32766;
    }

    @Redirect(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/Enchantment;isAcceptableItem(Lnet/minecraft/item/ItemStack;)Z"))
    private boolean redirectIsAcceptableItem(Enchantment enchantment, ItemStack stack) {
        return true;
    }

    @Redirect(method = "execute", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;addEnchantment(Lnet/minecraft/enchantment/Enchantment;I)V"))
    private void redirectAddEnchantment(ItemStack itemStack, Enchantment enchantment, int level) {
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
