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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AttributeLoreMeta {

    public static double a1;
    public static double a2;
    public static double a3;
    public static double a4;
    public static double a5;

    public static void loreSetter(ItemStack itemStack) {

        a1 = 0;
        a2 = 0;
        a3 = 0;
        a4 = 0;
        a5 = 0;

        ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();
        ArrayList<Double> list3 = new ArrayList<>();
        ArrayList<Double> list4 = new ArrayList<>();
        ArrayList<Double> list5 = new ArrayList<>();

        if (itemStack.hasItemMeta() &&
                itemStack.getItemMeta().hasAttributeModifiers() &&
                itemStack.getItemMeta().getAttributeModifiers() != null) {

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                    list1.add(modifier.getAmount());
                }
                for (Double health : list1) {
                    a1 = health + a1;
                }
                list1.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR))) {

                    list2.add(modifier.getAmount());
                }
                for (Double armor : list2) {
                    a2 = armor + a2;
                }
                list2.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                    list3.add(modifier.getAmount());
                }
                for (Double toughness : list3) {
                    a3 = toughness + a3;
                }
                list3.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE))) {

                    list4.add(modifier.getAmount());
                }
                for (Double damage : list4) {
                    a4 = damage + a4;
                }
                list4.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED))) {

                    list5.add(modifier.getAmount());
                }
                for (Double speed : list5) {
                    a5 = speed + a5;
                }
                list5.clear();
            }

            if (a1 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd1 = meta.lore();
                Objects.requireNonNull(listAdd1).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&a体力&f: " + a1)));
                meta.lore(listAdd1);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())), PersistentDataType.INTEGER, listAdd1.size());
                itemStack.setItemMeta(meta);
                listAdd1.clear();
            }

            if (a2 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd2 = meta.lore();
                Objects.requireNonNull(listAdd2).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&b防御力&f: " + a2)));
                meta.lore(listAdd2);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())), PersistentDataType.INTEGER, listAdd2.size());
                itemStack.setItemMeta(meta);
                listAdd2.clear();
            }

            if (a3 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd3 = meta.lore();
                Objects.requireNonNull(listAdd3).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&e軽減値&f: " + a3)));
                meta.lore(listAdd3);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())), PersistentDataType.INTEGER, listAdd3.size());
                itemStack.setItemMeta(meta);
                listAdd3.clear();
            }

            if (a4 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd4 = meta.lore();
                Objects.requireNonNull(listAdd4).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&c攻撃力&f: " + a4)));
                meta.lore(listAdd4);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())), PersistentDataType.INTEGER, listAdd4.size());
                itemStack.setItemMeta(meta);
                listAdd4.clear();
            }

            if (a5 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd5 = meta.lore();
                Objects.requireNonNull(listAdd5).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&f移動速度&f: " + a5)));
                meta.lore(listAdd5);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())), PersistentDataType.INTEGER, listAdd5.size());
                itemStack.setItemMeta(meta);
                listAdd5.clear();
            }
        }
    }

    public static void removeLore(ItemStack itemStack) {

        if (!itemStack.getItemMeta().hasLore()) return;
        if (itemStack.getItemMeta().getPersistentDataContainer().isEmpty()) return;

        ItemMeta meta = itemStack.getItemMeta();
        List<Component> list = meta.lore();

        Integer integer1 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())), PersistentDataType.INTEGER);

        if (String.valueOf(integer1) != null && integer1 != null) {

            int i = Integer.parseInt(String.valueOf(integer1));
            if (Objects.requireNonNull(list).size() - 1 < i) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i);

        }
        meta.lore(list);
        itemStack.setItemMeta(meta);

        Integer integer2 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())), PersistentDataType.INTEGER);

        if (String.valueOf(integer2) != null && integer2 != null) {

            int i = Integer.parseInt(String.valueOf(integer2));
            if (Objects.requireNonNull(list).size() - 1 < i) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i);

        }
        meta.lore(list);
        itemStack.setItemMeta(meta);

        Integer integer3 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())), PersistentDataType.INTEGER);

        if (String.valueOf(integer3) != null && integer3 != null) {

            int i = Integer.parseInt(String.valueOf(integer3));
            if (Objects.requireNonNull(list).size() - 1 < i) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i);

        }
        meta.lore(list);
        itemStack.setItemMeta(meta);

        Integer integer4 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())), PersistentDataType.INTEGER);

        if (String.valueOf(integer4) != null && integer4 != null) {

            int i = Integer.parseInt(String.valueOf(integer4));
            if (Objects.requireNonNull(list).size() - 1 < i) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i);

        }
        meta.lore(list);
        itemStack.setItemMeta(meta);

        Integer integer5 = meta.getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())), PersistentDataType.INTEGER);

        if (String.valueOf(integer5) != null && integer5 != null) {

            int i = Integer.parseInt(String.valueOf(integer5));
            if (Objects.requireNonNull(list).size() - 1 < i) {
                Objects.requireNonNull(list).remove(list.size() - 1);
            } else Objects.requireNonNull(list).remove(i);

        }
        itemStack.getItemMeta().getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())));
        itemStack.getItemMeta().getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())));
        itemStack.getItemMeta().getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())));
        itemStack.getItemMeta().getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())));
        itemStack.getItemMeta().getPersistentDataContainer().remove(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())));

        meta.lore(list);
        itemStack.setItemMeta(meta);
    }

    public static void checkLore(ItemStack itemStack) {

        a1 = 0;
        a2 = 0;
        a3 = 0;
        a4 = 0;
        a5 = 0;

        ArrayList<Double> list1 = new ArrayList<>();
        ArrayList<Double> list2 = new ArrayList<>();
        ArrayList<Double> list3 = new ArrayList<>();
        ArrayList<Double> list4 = new ArrayList<>();
        ArrayList<Double> list5 = new ArrayList<>();

        if (itemStack.hasItemMeta() &&
                itemStack.getItemMeta().hasAttributeModifiers() &&
                itemStack.getItemMeta().getAttributeModifiers() != null &&
                itemStack.getItemMeta().getPersistentDataContainer().isEmpty()) {

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MAX_HEALTH))) {

                    list1.add(modifier.getAmount());
                }
                for (Double health : list1) {
                    a1 = health + a1;
                }
                list1.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR))) {

                    list2.add(modifier.getAmount());
                }
                for (Double armor : list2) {
                    a2 = armor + a2;
                }
                list2.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ARMOR_TOUGHNESS))) {

                    list3.add(modifier.getAmount());
                }
                for (Double toughness : list3) {
                    a3 = toughness + a3;
                }
                list3.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_ATTACK_DAMAGE))) {

                    list4.add(modifier.getAmount());
                }
                for (Double damage : list4) {
                    a4 = damage + a4;
                }
                list4.clear();
            }

            if (itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED) != null) {

                for (AttributeModifier modifier : Objects.requireNonNull(itemStack.getItemMeta().getAttributeModifiers(Attribute.GENERIC_MOVEMENT_SPEED))) {

                    list5.add(modifier.getAmount());
                }
                for (Double speed : list5) {
                    a5 = speed + a5;
                }
                list5.clear();
            }

            if (a1 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd1 = meta.lore();
                Objects.requireNonNull(listAdd1).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&a体力&f: " + a1)));
                meta.lore(listAdd1);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("health", AziCraft.inst())), PersistentDataType.INTEGER, listAdd1.size());
                itemStack.setItemMeta(meta);
                listAdd1.clear();
            }

            if (a2 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd2 = meta.lore();
                Objects.requireNonNull(listAdd2).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&b防御力&f: " + a2)));
                meta.lore(listAdd2);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("armor", AziCraft.inst())), PersistentDataType.INTEGER, listAdd2.size());
                itemStack.setItemMeta(meta);
                listAdd2.clear();
            }

            if (a3 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd3 = meta.lore();
                Objects.requireNonNull(listAdd3).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&e軽減値&f: " + a3)));
                meta.lore(listAdd3);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("toughness", AziCraft.inst())), PersistentDataType.INTEGER, listAdd3.size());
                itemStack.setItemMeta(meta);
                listAdd3.clear();
            }

            if (a4 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd4 = meta.lore();
                Objects.requireNonNull(listAdd4).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&c攻撃力&f: " + a4)));
                meta.lore(listAdd4);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("damage", AziCraft.inst())), PersistentDataType.INTEGER, listAdd4.size());
                itemStack.setItemMeta(meta);
                listAdd4.clear();
            }

            if (a5 != 0) {
                ItemMeta meta = itemStack.getItemMeta();
                List<Component> listAdd5 = meta.lore();
                Objects.requireNonNull(listAdd5).add(Component.text(ChatColor.translateAlternateColorCodes('&', "&f移動速度&f: " + a5)));
                meta.lore(listAdd5);
                itemStack.setItemMeta(meta);
                meta.getPersistentDataContainer().set(Objects.requireNonNull(NamespacedKey.fromString("speed", AziCraft.inst())), PersistentDataType.INTEGER, listAdd5.size());
                itemStack.setItemMeta(meta);
                listAdd5.clear();
            }
        }
    }
}
