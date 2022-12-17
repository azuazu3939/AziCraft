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

import static azuazu3939.azicraft.Enchants.Custom.EnchantInterface.toughnessGetter;

public class ToughnessMeta {

    public static void toughnessSetter(ItemStack item, Enchantment enchantment, int level, Player player) {

        if (item.hasItemMeta() && enchantment.getKey().getKey().equals("toughness_point")) {

            if (item.getItemMeta().hasLore()) {

                ItemMeta meta = item.getItemMeta();
                List<Component> list;
                list = meta.lore();

                if (meta.getPersistentDataContainer().has(NamespacedKey.minecraft("toughness_point"), PersistentDataType.INTEGER)) {

                    Integer integer = meta.getPersistentDataContainer().get(enchantment.getKey(), PersistentDataType.INTEGER);
                    if (String.valueOf(integer) != null && integer != null) {
                        int i = Integer.parseInt(String.valueOf(integer));
                        Objects.requireNonNull(list).remove(i - 1);
                        meta.getPersistentDataContainer().remove(enchantment.getKey());
                        meta.lore(list);
                        item.setItemMeta(meta);

                        List<Integer> count = new ArrayList<>();
                        for (AttributeModifier modifier : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                            if (modifier.getName().equals(toughnessGetter())) {
                                count.add((int) modifier.getAmount());
                                meta.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);
                                item.setItemMeta(meta);
                            }
                        }
                        int finalAmount = 0;
                        for (int amount : count) {
                            finalAmount = amount + finalAmount;
                        }

                        int finalInteger = level + finalAmount;
                        int finalLevel = level + finalAmount;
                        Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d実数ダメージ軽減&f: " + finalLevel)));
                        meta.lore(list);
                        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), toughnessGetter(), level + finalInteger, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                        item.setItemMeta(meta);
                        meta.getPersistentDataContainer().set(NamespacedKey.minecraft("toughness_point"), PersistentDataType.INTEGER, list.size());
                        item.setItemMeta(meta);
                        list.clear();
                        count.clear();
                    }
                } else {
                    Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d実数ダメージ軽減&f: " + level)));
                    meta.lore(list);
                    meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), toughnessGetter(), level, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                    item.setItemMeta(meta);
                    meta.getPersistentDataContainer().set(NamespacedKey.minecraft("toughness_point"), PersistentDataType.INTEGER, list.size());
                    item.setItemMeta(meta);
                    list.clear();
                }
            } else {
                ItemMeta meta = item.getItemMeta();
                List<Component> list = new ArrayList<>();
                list.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d実数ダメージ軽減&f: " + level)));
                meta.lore(list);
                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), toughnessGetter(), level, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                item.setItemMeta(meta);
                meta.getPersistentDataContainer().set(NamespacedKey.minecraft("toughness_point"), PersistentDataType.INTEGER, 0);
                item.setItemMeta(meta);
                list.clear();
            }
        }
    }

    public static void toughnessRemove(@NotNull ItemStack item) {

        if (item.getItemMeta().hasAttributeModifiers() && item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) != null) {

            ItemMeta meta = item.getItemMeta();
            for (AttributeModifier modifier : Objects.requireNonNull(meta.getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {
                if (modifier.getName().equals(toughnessGetter())) {
                    meta.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);
                    item.setItemMeta(meta);
                }
            }
        }
    }
}
