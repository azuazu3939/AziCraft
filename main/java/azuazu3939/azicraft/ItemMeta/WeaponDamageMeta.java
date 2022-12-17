package azuazu3939.azicraft.ItemMeta;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.bukkit.enchantments.Enchantment.*;

public class WeaponDamageMeta {

    public static void weaponDamage(ItemStack item, Enchantment enchantment, int level, Player player) {

        List<Component> list2 = new ArrayList<>();

        if (enchantment.equals(DAMAGE_ALL) && item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            List<Component> list = meta.lore();
            if (meta.getPersistentDataContainer().has(enchantment.getKey(), PersistentDataType.INTEGER)) {

                Integer integer = meta.getPersistentDataContainer().get(enchantment.getKey(), PersistentDataType.INTEGER);
                if (String.valueOf(integer) != null && integer != null) {
                    int i = Integer.parseInt(String.valueOf(integer));
                    Objects.requireNonNull(list).remove(i - 1);
                    meta.lore(list);
                    meta.getPersistentDataContainer().remove(enchantment.getKey());
                    item.setItemMeta(meta);
                    int count = item.getEnchantmentLevel(enchantment);
                    item.removeEnchantment(enchantment);

                    item.addUnsafeEnchantment(enchantment, count + level);
                    int end = level + count;
                    Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dダメージ増加&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dダメージ増加&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            Objects.requireNonNull(list).clear();
        } else if (enchantment.equals(DAMAGE_ALL) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dダメージ増加&f: " + level)));
            meta.lore(list2);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
        }
        if (enchantment.equals(DAMAGE_UNDEAD) && item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            List<Component> list = meta.lore();
            if (meta.getPersistentDataContainer().has(enchantment.getKey(), PersistentDataType.INTEGER)) {

                Integer integer = meta.getPersistentDataContainer().get(enchantment.getKey(), PersistentDataType.INTEGER);
                if (String.valueOf(integer) != null && integer != null) {
                    int i = Integer.parseInt(String.valueOf(integer));
                    Objects.requireNonNull(list).remove(i - 1);
                    meta.lore(list);
                    meta.getPersistentDataContainer().remove(enchantment.getKey());
                    item.setItemMeta(meta);
                    int count = item.getEnchantmentLevel(enchantment);
                    item.removeEnchantment(enchantment);

                    item.addUnsafeEnchantment(enchantment, count + level);
                    int end = level + count;
                    Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dアンデット特攻&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dアンデット特攻&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            Objects.requireNonNull(list).clear();
        } else if (enchantment.equals(DAMAGE_UNDEAD) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dアンデット特攻&f: " + level)));
            meta.lore(list2);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
        }
        if (enchantment.equals(DAMAGE_ARTHROPODS) && item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            List<Component> list = meta.lore();
            if (meta.getPersistentDataContainer().has(enchantment.getKey(), PersistentDataType.INTEGER)) {

                Integer integer = meta.getPersistentDataContainer().get(enchantment.getKey(), PersistentDataType.INTEGER);
                if (String.valueOf(integer) != null && integer != null) {
                    int i = Integer.parseInt(String.valueOf(integer));
                    Objects.requireNonNull(list).remove(i - 1);
                    meta.lore(list);
                    meta.getPersistentDataContainer().remove(enchantment.getKey());
                    item.setItemMeta(meta);
                    int count = item.getEnchantmentLevel(enchantment);
                    item.removeEnchantment(enchantment);
                    item.addUnsafeEnchantment(enchantment, count + level);
                    int end = level + count;
                    Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d虫特攻&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d虫特攻&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            Objects.requireNonNull(list).clear();
        } else if (enchantment.equals(DAMAGE_ARTHROPODS) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d虫特攻&f: " + level)));
            meta.lore(list2);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
        }
        list2.clear();
    }
}
