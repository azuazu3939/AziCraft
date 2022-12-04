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

import static azuazu3939.azicraft.Enchants.EnchantInterface.healthGetter;

public class HealthBoosterMeta {

    public static void HealthSetter(ItemStack item, Enchantment enchantment) {

        if (!item.getItemMeta().hasEnchant(enchantment)) {return;}

        if (item.getItemMeta().hasAttributeModifiers()) {
            if (!(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) == null)) {

                if (item.getItemMeta().getAttributeModifiers() == null) {return;}

                for (AttributeModifier attr : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                    if (attr.getName().equals(healthGetter())) {item.getItemMeta().removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH, attr);}
                }
                ItemMeta meta = item.getItemMeta();
                List<Component> list;
                list = meta.lore();
                Objects.requireNonNull(list).add(Component.text(ChatColor.GRAY + "体力増加Lv" + item.getEnchantmentLevel(enchantment)));
                meta.lore(list);
                meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier(UUID.randomUUID(), healthGetter(), item.getEnchantmentLevel(enchantment) * 15, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                item.setItemMeta(meta);
                list.clear();
            }
        }
    }

    public static void HealthRemover(ItemStack itemStack) {

        if (itemStack.getItemMeta().hasAttributeModifiers()) {
            if (itemStack.getItemMeta().getAttributeModifiers() == null) {
                return;
            }
            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) == null) {
                return;
            }

            for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                if (modifier.getName().equals(healthGetter())) {
                    ItemMeta meta = itemStack.getItemMeta();
                    meta.removeAttributeModifier(Attribute.GENERIC_MAX_HEALTH, modifier);
                    itemStack.setItemMeta(meta);
                }
            }
        }
    }
}
