package azuazu3939.azicraft.Enchants;

import azuazu3939.azicraft.ItemMeta.HealthBoosterMeta;
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

public class EnchantmentHealthBooster extends Enchantments implements EnchantInterface {

    public EnchantmentHealthBooster(String key) {
        super(NamespacedKey.minecraft(key));
    }

    public static final Enchantment HEALTH_BOOSTER = new EnchantmentHealthBooster(EnchantInterface.healthGetter());

    public static void HealthSetter(ItemStack itemStack) {HealthBoosterMeta.HealthSetter(itemStack, HEALTH_BOOSTER);}

    @Override
    public @NotNull String getName() {
        return ChatColor.GRAY + "体力";
    }

    @Override
    public int getMaxLevel() {
        return 10;
    }

    @Override
    public int getStartLevel() {
        return 1;
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
        return Component.text(ChatColor.GRAY + "体力");
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
        return ChatColor.GRAY + "Health_Booster";
    }
}
