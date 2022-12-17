package azuazu3939.azicraft.ItemMeta;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.bukkit.enchantments.Enchantment.*;

public class VanillaEnchantMeta {

    public static void vanillaEnchant(@NotNull ItemStack item, @NotNull Enchantment enchantment, int level, Player player) {

        List<Component> list2 = new ArrayList<>();

        if (enchantment.equals(DEPTH_STRIDER) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中歩行&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add(list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中歩行&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(DEPTH_STRIDER.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中歩行&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(WATER_WORKER) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中採掘&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中採掘&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(WATER_WORKER.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中採掘&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }
        if (enchantment.equals(OXYGEN) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中呼吸&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中呼吸&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            Objects.requireNonNull(list).clear();
        } else if (enchantment.getKey().getKey().equals(OXYGEN.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d水中呼吸&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(LURE) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d入れ食い&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d入れ食い&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(LURE.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d入れ食い&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(SILK_TOUCH) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dシルクタッチ&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dシルクタッチ&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(SILK_TOUCH.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dシルクタッチ&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(LOOT_BONUS_BLOCKS) && item.getItemMeta().hasLore()) {
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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d幸運&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d幸運&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(LOOT_BONUS_BLOCKS.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d幸運&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(DIG_SPEED) && item.getItemMeta().hasLore()) {
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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d効率強化&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d効率強化&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(DIG_SPEED.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d効率強化&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(ARROW_DAMAGE) && item.getItemMeta().hasLore()) {
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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dパワー&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dパワー&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(ARROW_DAMAGE.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dパワー&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(ARROW_FIRE) && item.getItemMeta().hasLore()) {
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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dフレイム&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dフレイム&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER,  + Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(ARROW_FIRE.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dフレイム&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(ARROW_KNOCKBACK) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dパンチ&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dパンチ&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER,  + Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(ARROW_KNOCKBACK.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dパンチ&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(ARROW_INFINITE) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d無限&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d無限&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER,  + Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(ARROW_INFINITE.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d無限&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(SWEEPING_EDGE) && item.getItemMeta().hasLore()) {

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
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d範囲ダメージ増加&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d範囲ダメージ増加&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER,  + Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(SWEEPING_EDGE.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d範囲ダメージ増加&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(KNOCKBACK) && item.getItemMeta().hasLore()) {

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
                    int count = item.removeEnchantment(enchantment);
                    item.addUnsafeEnchantment(enchantment, count + level);
                    int end = level + count;
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dノックバック&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&dノックバック&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER,  + Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(KNOCKBACK.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&dノックバック&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }

        if (enchantment.equals(FIRE_ASPECT) && item.getItemMeta().hasLore()) {

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
                    int count = item.removeEnchantment(enchantment);
                    item.addUnsafeEnchantment(enchantment, count + level);
                    int end = level + count;
                    Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d火属性&f: " + end)));
                }
            } else {
                Objects.requireNonNull(list).add( + list.size(), Component.text(ChatColor.translateAlternateColorCodes('&', "&d火属性&f: " + level)));
            }
            meta.lore(list);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER,  + Objects.requireNonNull(list).size());
            item.setItemMeta(meta);
            list.clear();
        } else if (enchantment.getKey().getKey().equals(FIRE_ASPECT.getKey().getKey()) && !item.getItemMeta().hasLore()) {
            ItemMeta meta = item.getItemMeta();
            list2.add(0, Component.text(ChatColor.translateAlternateColorCodes('&', "&d火属性&f: " + level)));
            meta.lore(list2);
            item.setItemMeta(meta);
            meta.getPersistentDataContainer().set(enchantment.getKey(), PersistentDataType.INTEGER, 0);
            item.setItemMeta(meta);
            list2.clear();
        }
    }
}
