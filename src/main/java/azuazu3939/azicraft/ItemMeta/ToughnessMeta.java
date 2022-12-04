package azuazu3939.azicraft.ItemMeta;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static azuazu3939.azicraft.Enchants.EnchantInterface.toughnessGetter;

public class ToughnessMeta {

    public static void toughnessSetter(ItemStack item, Enchantment enchantment) {

        if (!item.getItemMeta().hasEnchant(enchantment)) {return;}

        if (item.getItemMeta().hasAttributeModifiers()) {
            if (!(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) == null)) {

                if (item.getItemMeta().getAttributeModifiers() == null) {return;}

                for (AttributeModifier attr : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                    if (attr.getName().equals(toughnessGetter())) {item.getItemMeta().removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, attr);}
                }
                ItemMeta meta = item.getItemMeta();
                List<Component> list;
                list = meta.lore();
                Objects.requireNonNull(list).add(Component.text(ChatColor.GRAY + "実数ダメージ軽減Lv" + item.getEnchantmentLevel(enchantment)));
                meta.lore(list);
                meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier(UUID.randomUUID(), toughnessGetter(), item.getEnchantmentLevel(enchantment), AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                item.setItemMeta(meta);
                list.clear();
            }
        }
    }

    public static void toughnessRemover(ItemStack itemStack) {

        if (itemStack.getItemMeta().hasAttributeModifiers()) {
            if (itemStack.getItemMeta().getAttributeModifiers() == null) {
                return;
            }
            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) == null) {
                return;
            }

            for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                if (modifier.getName().equals(toughnessGetter())) {
                    ItemMeta meta = itemStack.getItemMeta();
                    meta.removeAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifier);
                    itemStack.setItemMeta(meta);
                }
            }
        }
    }
}
