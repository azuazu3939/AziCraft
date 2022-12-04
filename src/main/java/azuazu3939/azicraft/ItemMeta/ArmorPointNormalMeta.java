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

import static azuazu3939.azicraft.Enchants.EnchantInterface.armorNormalGetter;

public class ArmorPointNormalMeta {
    public static void armorPointNSetter(ItemStack item, Enchantment enchantment) {

        if (!item.getItemMeta().hasEnchant(enchantment)) {return;}

        if (item.getItemMeta().hasAttributeModifiers()) {
            if (!(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR) == null)) {

                if (item.getItemMeta().getAttributeModifiers() == null) {return;}

                for (AttributeModifier attr : Objects.requireNonNull(item.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR))) {

                    if (attr.getName().equals(armorNormalGetter())) {item.getItemMeta().removeAttributeModifier(Attribute.GENERIC_ARMOR, attr);}
                }
                ItemMeta meta = item.getItemMeta();
                List<Component> list;
                list = meta.lore();
                Objects.requireNonNull(list).add(Component.text(ChatColor.GRAY + "通常防御Lv" + item.getEnchantmentLevel(enchantment)));
                meta.lore(list);
                meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier(UUID.randomUUID(), armorNormalGetter(), item.getEnchantmentLevel(enchantment) * 2, AttributeModifier.Operation.ADD_NUMBER, item.getType().getEquipmentSlot()));
                item.setItemMeta(meta);
                list.clear();
            }
        }
    }

    public static void armorPointNRemover(ItemStack itemStack) {

        if (itemStack.getItemMeta().hasAttributeModifiers()) {
            if (itemStack.getItemMeta().getAttributeModifiers() == null) {
                return;
            }
            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR) == null) {
                return;
            }

            for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR))) {

                if (modifier.getName().equals(armorNormalGetter())) {
                    ItemMeta meta = itemStack.getItemMeta();
                    meta.removeAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
                    itemStack.setItemMeta(meta);
                }
            }
        }
    }
}
