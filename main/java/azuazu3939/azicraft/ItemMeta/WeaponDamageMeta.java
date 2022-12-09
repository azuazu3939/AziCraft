package azuazu3939.azicraft.ItemMeta;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.bukkit.enchantments.Enchantment.*;

public class WeaponDamageMeta {

    public static void weaponDamage(ItemStack item, Enchantment enchantment, int level) {

        ItemMeta meta = item.getItemMeta();
        List<Component> list = meta.lore();
        List<Component> list2 = new ArrayList<>();

        if (enchantment.equals(DAMAGE_ALL) && meta.hasLore()) {
            Objects.requireNonNull(list).add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dダメージ増加&f: " + level)));
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
        } else if (enchantment.equals(DAMAGE_ALL) && !meta.hasLore()) {
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dダメージ増加&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
        }
        if (enchantment.equals(DAMAGE_UNDEAD) && meta.hasLore()) {
            Objects.requireNonNull(list).add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dアンデット特攻&f: " + level)));
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
        } else if (enchantment.equals(DAMAGE_UNDEAD) && !meta.hasLore()) {
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dアンデット特攻&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
        }
        if (enchantment.equals(DAMAGE_ARTHROPODS) && meta.hasLore()) {
            Objects.requireNonNull(list).add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d虫特攻&f: " + level)));
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
        } else if (enchantment.equals(DAMAGE_ARTHROPODS) && !meta.hasLore()) {
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d虫特攻&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
        }
        list2.clear();
        item.setItemMeta(meta);
    }

    public static void weaponDamageRemover(ItemStack item) {

        ItemMeta meta = item.getItemMeta();
        List<Component> list = meta.lore();


        Integer integer1 = meta.getPersistentDataContainer().get(Enchantment.DAMAGE_ALL.getKey(), PersistentDataType.INTEGER);

        if (String.valueOf(integer1) != null && integer1 != null) {
            int i1 = Integer.parseInt(String.valueOf(integer1));
            if (Objects.requireNonNull(list).size() - 1 < i1) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i1);
        }


        Integer integer2 = meta.getPersistentDataContainer().get(Enchantment.DAMAGE_UNDEAD.getKey(), PersistentDataType.INTEGER);

        if (String.valueOf(integer2) != null && integer2 != null) {
            int i2 = Integer.parseInt(String.valueOf(integer2));
            if (Objects.requireNonNull(list).size() - 1 < i2) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i2);
        }

        Integer integer3 = meta.getPersistentDataContainer().get(DAMAGE_ARTHROPODS.getKey(), PersistentDataType.INTEGER);

        if (String.valueOf(integer3) != null && integer3 != null) {
            int i3 = Integer.parseInt(String.valueOf(integer3));
            if (Objects.requireNonNull(list).size() - 1 < i3) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i3);
        }

        item.getItemMeta().getPersistentDataContainer().remove(DAMAGE_ARTHROPODS.getKey());
        item.getItemMeta().getPersistentDataContainer().remove(DAMAGE_UNDEAD.getKey());
        item.getItemMeta().getPersistentDataContainer().remove(DAMAGE_ALL.getKey());

        meta.lore(list);
        item.setItemMeta(meta);
    }
}
