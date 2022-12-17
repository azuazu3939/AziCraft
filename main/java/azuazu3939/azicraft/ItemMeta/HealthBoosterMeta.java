package azuazu3939.azicraft.ItemMeta;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static azuazu3939.azicraft.Enchants.Custom.EnchantInterface.healthGetter;

public class HealthBoosterMeta {

    public static void HealthSetter(ItemStack item, Enchantment enchantment, int level, Player player) {

        if (item.hasItemMeta() &&  item.getItemMeta().hasEnchants() && enchantment.getKey().getKey().equals("health_booster")) {

            if (item.getItemMeta().hasLore()) {
                ItemMeta meta = item.getItemMeta();
                List<Component> list;
                list = meta.lore();

                if (meta.getPersistentDataContainer().has(NamespacedKey.minecraft("health_booster"), PersistentDataType.INTEGER)) {

                    Integer integer = meta.getPersistentDataContainer().get(enchantment.getKey(), PersistentDataType.INTEGER);
                    if (String.valueOf(integer) != null && integer != null) {
                        int i = Integer.parseInt(String.valueOf(integer));
                        Objects.requireNonNull(list).remove(i - 1);
                        meta.getPersistentDataContainer().remove(enchantment.getKey());
                        meta.lore(list);
                        item.setItemMeta(meta);

                        List<Integer> count = new ArrayList<>();
                        for (AttributeModifier modifier : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                            if (modifier.getName().equals(healthGetter())) {
                                count.add((int) modifier.getAmount());
                                meta.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                                item.setItemMeta(meta);
                            }
                        }
                        int finalAmount = 0;
                        for (int amount : count) {
                            finalAmount = amount + finalAmount;
                        }
                        int finalInteger = (level * 15) + finalAmount;
                        int finalLevel = level + (finalAmount / 15);
                        Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d体力増加&f: " + finalLevel)));
                        meta.lore(list);
                        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), healthGetter(), finalInteger, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                        item.setItemMeta(meta);
                        meta.getPersistentDataContainer().set(NamespacedKey.minecraft("health_booster"), PersistentDataType.INTEGER, list.size());
                        item.setItemMeta(meta);
                        list.clear();
                        count.clear();
                    }
                } else {
                    Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d体力増加&f: " + level)));
                    meta.lore(list);
                    meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), healthGetter(), level * 15, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                    item.setItemMeta(meta);
                    meta.getPersistentDataContainer().set(NamespacedKey.minecraft("health_booster"), PersistentDataType.INTEGER, list.size());
                    item.setItemMeta(meta);
                    list.clear();
                }
            } else {
                ItemMeta meta = item.getItemMeta();
                List<Component> list = new ArrayList<>();
                list.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d体力増加&f: " + level)));
                meta.lore(list);
                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), healthGetter(), level * 15, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                item.setItemMeta(meta);
                meta.getPersistentDataContainer().set(NamespacedKey.minecraft("health_booster"), PersistentDataType.INTEGER, 0);
                item.setItemMeta(meta);
                list.clear();
            }
        }
    }

    public static void healthRemove(@NotNull ItemStack item) {

        if (item.getItemMeta().hasAttributeModifiers() && item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) != null) {

            ItemMeta meta = item.getItemMeta();
            for (AttributeModifier modifier : Objects.requireNonNull(meta.getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {
                if (modifier.getName().equals(healthGetter())) {

                    meta.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                    item.setItemMeta(meta);
                }
            }
        }
    }
}
