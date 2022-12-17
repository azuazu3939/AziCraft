package azuazu3939.azicraft.ItemMeta;

import azuazu3939.azicraft.AziCraft;
import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static azuazu3939.azicraft.ItemMeta.ArmorPointNormalMeta.armorRemove;
import static azuazu3939.azicraft.ItemMeta.HealthBoosterMeta.healthRemove;
import static azuazu3939.azicraft.ItemMeta.ToughnessMeta.toughnessRemove;
import static org.bukkit.enchantments.Enchantment.*;

public class AttributeLoreMeta {

    public static void removeLore(@NotNull ItemStack itemStack) {

        if (!itemStack.getItemMeta().hasLore()) return;

        ItemMeta meta = itemStack.getItemMeta();
        List<Component> lore = meta.lore();

        if (itemStack.getItemMeta().hasLore()) {
            Integer repeat =  itemStack.getItemMeta().getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("lores", AziCraft.inst())), PersistentDataType.INTEGER);
            if (String.valueOf(repeat) != null && repeat != null) {
                int repeatI = Integer.parseInt(String.valueOf(repeat));
                int count = Objects.requireNonNull(lore).size();
                for (int i = 1; i <= count - repeatI; i++) {

                    lore.remove(repeatI);
                    meta.lore(lore);
                    itemStack.setItemMeta(meta);
                }
                meta.getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())));
                meta.getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())));
                meta.getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())));
                meta.getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())));
                meta.getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())));
                meta.getPersistentDataContainer().remove(NamespacedKey.minecraft("armor_point"));
                meta.getPersistentDataContainer().remove(NamespacedKey.minecraft("toughness_point"));
                meta.getPersistentDataContainer().remove(NamespacedKey.minecraft("health_booster"));
                meta.getPersistentDataContainer().remove(DAMAGE_ALL.getKey());
                meta.getPersistentDataContainer().remove(DAMAGE_UNDEAD.getKey());
                meta.getPersistentDataContainer().remove(DAMAGE_ARTHROPODS.getKey());
                meta.getPersistentDataContainer().remove(ARROW_DAMAGE.getKey());
                meta.getPersistentDataContainer().remove(ARROW_FIRE.getKey());
                meta.getPersistentDataContainer().remove(ARROW_KNOCKBACK.getKey());
                meta.getPersistentDataContainer().remove(ARROW_INFINITE.getKey());
                meta.getPersistentDataContainer().remove(DEPTH_STRIDER.getKey());
                meta.getPersistentDataContainer().remove(WATER_WORKER.getKey());
                meta.getPersistentDataContainer().remove(OXYGEN.getKey());
                meta.getPersistentDataContainer().remove(SILK_TOUCH.getKey());
                meta.getPersistentDataContainer().remove(DIG_SPEED.getKey());
                meta.getPersistentDataContainer().remove(LOOT_BONUS_BLOCKS.getKey());
                meta.getPersistentDataContainer().remove(KNOCKBACK.getKey());
                meta.getPersistentDataContainer().remove(SWEEPING_EDGE.getKey());
                meta.getPersistentDataContainer().remove(FIRE_ASPECT.getKey());
                meta.getPersistentDataContainer().remove(LURE.getKey());
                itemStack.setItemMeta(meta);
                healthRemove(itemStack);
                armorRemove(itemStack);
                toughnessRemove(itemStack);
            }
        }
    }

    public static void checkLore(ItemStack itemStack) {

        double a1 = 0;
        double a2 = 0;
        double a3 = 0;
        double a4 = 0;
        double a5 = 0;
        ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();
        ArrayList<Double> list3 = new ArrayList<>();
        ArrayList<Double> list4 = new ArrayList<>();
        ArrayList<Double> list5 = new ArrayList<>();

        if (itemStack.hasItemMeta() && itemStack.getItemMeta().hasAttributeModifiers()) {

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) != null) {
                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {
                    list1.add(modifier.getAmount());}
                for (Double health : list1) {a1 = health + a1;}
                list1.clear();}

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR) != null) {
                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR))) {
                    list2.add(modifier.getAmount());}
                for (Double armor : list2) {a2 = armor + a2;}
                list2.clear();}

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) != null) {
                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {
                    list3.add(modifier.getAmount());}
                for (Double toughness : list3) {a3 = toughness + a3;}
                list3.clear();}

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE) != null) {
                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE))) {
                    list4.add(modifier.getAmount());}
                for (Double damage : list4) {a4 = damage + a4;}
                list4.clear();}

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED) != null) {
                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED))) {
                    list5.add(modifier.getAmount());}
                for (Double speed : list5) {a5 = speed + a5;}
                list5.clear();}

            if (a1 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd1 = meta.lore();
                Integer integer1 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())), PersistentDataType.INTEGER);
                if (String.valueOf(integer1) != null && integer1 != null) {
                    int i = Integer.parseInt(String.valueOf(integer1));
                    Objects.requireNonNull(listAdd1).set(i - 1, Component.text(ChatColor.translateAlternateColorCodes('&', "&a体力&f: " + a1)));
                } else {
                    Objects.requireNonNull(listAdd1).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&a体力&f: " + a1)));
                    meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())), PersistentDataType.INTEGER, listAdd1.size());
                }
                meta.lore(listAdd1);
                itemStack.setItemMeta(meta);
            }

            if (a2 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd2 = meta.lore();
                Integer integer2 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())), PersistentDataType.INTEGER);
                if (String.valueOf(integer2) != null && integer2 != null) {
                    int i = Integer.parseInt(String.valueOf(integer2));
                    Objects.requireNonNull(listAdd2).set(i - 1, Component.text(ChatColor.translateAlternateColorCodes('&', "&b防御力&f: " + a2)));
                } else {
                    Objects.requireNonNull(listAdd2).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&b防御力&f: " + a2)));
                    meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())), PersistentDataType.INTEGER, listAdd2.size());
                }
                meta.lore(listAdd2);
                itemStack.setItemMeta(meta);
            }

            if (a3 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd3 = meta.lore();
                Integer integer3 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())), PersistentDataType.INTEGER);
                if (String.valueOf(integer3) != null && integer3 != null) {
                    int i = Integer.parseInt(String.valueOf(integer3));
                    Objects.requireNonNull(listAdd3).set(i - 1, Component.text(ChatColor.translateAlternateColorCodes('&', "&e軽減値&f: " + a3)));
                } else {
                    Objects.requireNonNull(listAdd3).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&e軽減値&f: " + a3)));
                    meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())), PersistentDataType.INTEGER, listAdd3.size());
                }
                meta.lore(listAdd3);
                itemStack.setItemMeta(meta);
            }

            if (a4 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd4 = meta.lore();
                Integer integer4 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())), PersistentDataType.INTEGER);
                if (String.valueOf(integer4) != null && integer4 != null) {
                    int i = Integer.parseInt(String.valueOf(integer4));
                    Objects.requireNonNull(listAdd4).set(i - 1, Component.text(ChatColor.translateAlternateColorCodes('&', "&c攻撃力&f: " + a4)));
                } else {
                    Objects.requireNonNull(listAdd4).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&c攻撃力&f: " + a4)));
                    meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())), PersistentDataType.INTEGER, listAdd4.size());
                }
                meta.lore(listAdd4);
                itemStack.setItemMeta(meta);
            }

            if (a5 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd5 = meta.lore();
                Integer integer5 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())), PersistentDataType.INTEGER);
                if (String.valueOf(integer5) != null && integer5 != null) {
                    int i = Integer.parseInt(String.valueOf(integer5));
                    Objects.requireNonNull(listAdd5).set(i - 1, Component.text(ChatColor.translateAlternateColorCodes('&', "&f移動速度&f: " + a5)));
                } else {
                    Objects.requireNonNull(listAdd5).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&f移動速度&f: " + a5)));
                    meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())), PersistentDataType.INTEGER, listAdd5.size());
                }
                meta.lore(listAdd5);
                itemStack.setItemMeta(meta);
            }
        }
    }
}
