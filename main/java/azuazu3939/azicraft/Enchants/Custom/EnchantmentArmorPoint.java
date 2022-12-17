package azuazu3939.azicraft.Enchants.Custom;

import io.papermc.paper.enchantments.EnchantmentRarity;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityCategory;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static azuazu3939.azicraft.Enchants.Custom.EnchantInterface.armorNormalGetter;

public class EnchantmentArmorPoint extends UWPEnchantment {

    public EnchantmentArmorPoint(@NotNull String key) {
        super(NamespacedKey.minecraft(key));
    }

    public static final Enchantment ARMOR_POINT = new EnchantmentArmorPoint(armorNormalGetter());

    @Override
    public @NotNull String getName() {
        return ChatColor.WHITE + "通常防御";
    }

    @Override
    public int getMaxLevel() {
        return 0;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public @NotNull EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(@NotNull Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(@NotNull ItemStack item) {
        return false;
    }

    @Override
    public @NotNull Component displayName(int level) {
        return Component.text(ChatColor.WHITE + "通常防御");
    }

    @Override
    public boolean isTradeable() {
        return false;
    }

    @Override
    public boolean isDiscoverable() {
        return false;
    }

    @Override
    public @NotNull EnchantmentRarity getRarity() {
        return EnchantmentRarity.UNCOMMON;
    }

    @Override
    public float getDamageIncrease(int level, @NotNull EntityCategory entityCategory) {
        return 0;
    }

    @Override
    public @NotNull Set<EquipmentSlot> getActiveSlots() {
        return PROTECTION_ENVIRONMENTAL.getActiveSlots();
    }

    @Override
    public @NotNull String translationKey() {
        return ChatColor.WHITE + "Normal_Armor_Point";
    }

}
