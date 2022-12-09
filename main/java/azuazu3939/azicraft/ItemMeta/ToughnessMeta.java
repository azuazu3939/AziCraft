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

import static azuazu3939.azicraft.Enchants.EnchantInterface.toughnessGetter;

public class ToughnessMeta {

    public static void toughnessSetter(ItemStack item, Enchantment enchantment, int level) {

        if (item.hasItemMeta() &&
                item.getItemMeta().hasAttributeModifiers() &&
                item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) != null &&
                item.getItemMeta().getAttributeModifiers() != null &&
                enchantment.getKey().getNamespace().equals("toughness_point")) {

            for (AttributeModifier attr : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                if (attr.getName().equals(toughnessGetter())) {
                    item.getItemMeta().removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, attr);
                }
            }
            ItemMeta meta = item.getItemMeta();
            List<Component> list;
            list = meta.lore();

            Objects.requireNonNull(list).add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d実数ダメージ軽減&f: " + level)));
            meta.lore(list);
            meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), toughnessGetter(), level, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(NamespacedKey.minecraft("toughness_point"), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list.clear();
        }
    }

    public static void toughnessRemover(ItemStack itemStack, Enchantment enchantment) {

        if (itemStack.getItemMeta().hasAttributeModifiers() &&
                itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) != null &&
                itemStack.getItemMeta().getAttributeModifiers() != null) {

            for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                if (modifier.getName().equals(toughnessGetter())) {
                    ItemMeta meta = itemStack.getItemMeta();
                    meta.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);
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
