package azuazu3939.azicraft.ItemMeta;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static azuazu3939.azicraft.Enchants.EnchantInterface.healthGetter;

public class HealthBoosterMeta {

    public static void HealthSetter(ItemStack item, Enchantment enchantment, int level) {

        if (item.hasItemMeta() &&  item.getItemMeta().hasEnchants() &&
                item.getItemMeta().hasAttributeModifiers() &&
                item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) != null &&
                item.getItemMeta().getAttributeModifiers() != null &&
                enchantment.getKey().getNamespace().equals("health_booster")) {

            for (AttributeModifier attr : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                if (attr.getName().equals(healthGetter())) {
                    item.getItemMeta().removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH, attr);
                }
            }
            ItemMeta meta = item.getItemMeta();
            List<Component> list;
            list = meta.lore();

            Objects.requireNonNull(list).add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d体力増加&f: " + level)));
            meta.lore(list);
            meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), healthGetter(), level * 15, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(NamespacedKey.minecraft("health_booster"), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list.clear();
        }
    }

    public static void HealthRemover(ItemStack itemStack, Enchantment enchantment) {

        if (itemStack.getItemMeta().hasAttributeModifiers() &&
                itemStack.getItemMeta().getAttributeModifiers() != null &&
                itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) != null) {

            for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                if (modifier.getName().equals(healthGetter())) {
                    ItemMeta meta = itemStack.getItemMeta();
                    meta.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                    itemStack.setItemMeta(meta);
                }
            }
        }

        if (!itemStack.getItemMeta().hasLore()) return;

        ItemMeta meta = itemStack.getItemMeta();
        List<Component> list = meta.lore();

        Integer integer = meta.getPersistentDataContainer().get(enchantment.getKey(), PersistentDataType.INTEGER);
        if (String.valueOf(integer) != null && integer != null) {

            int i = Integer.parseInt(String.valueOf(integer));
            if (Objects.requireNonNull(list).size() - 1 < i) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i);
        }
        itemStack.getItemMeta().getPersistentDataContainer().remove(enchantment.getKey());

        meta.lore(list);
        itemStack.setItemMeta(meta);
    }
}