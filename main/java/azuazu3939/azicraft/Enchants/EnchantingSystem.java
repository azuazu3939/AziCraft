package azuazu3939.azicraft.Enchants;

import azuazu3939.azicraft.AziCraft;
import azuazu3939.azicraft.Enchants.Custom.CustomEnchantList;
import azuazu3939.azicraft.Enchants.Vanilla.EditEnchantList;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.*;

import static azuazu3939.azicraft.Enchants.Custom.EnchantmentArmorPoint.ARMOR_POINT;
import static azuazu3939.azicraft.Enchants.Custom.EnchantmentHealthBooster.HEALTH_BOOSTER;
import static azuazu3939.azicraft.Enchants.Custom.EnchantmentToughnessPoint.TOUGHNESS_POINT;
import static azuazu3939.azicraft.Enchants.Vanilla.EditEnchantList.editCustomType;
import static azuazu3939.azicraft.ItemMeta.ArmorPointNormalMeta.armorPointNSetter;
import static azuazu3939.azicraft.ItemMeta.HealthBoosterMeta.HealthSetter;
import static azuazu3939.azicraft.ItemMeta.ToughnessMeta.toughnessSetter;
import static azuazu3939.azicraft.ItemMeta.VanillaEnchantMeta.vanillaEnchant;
import static azuazu3939.azicraft.ItemMeta.WeaponDamageMeta.weaponDamage;

public class EnchantingSystem {

    //対象のエンチャントが有効か確認する。
    @NotNull
    public static List<Enchantment> checkNormalEnchant() {

        List<Enchantment> list = new ArrayList<>();

        for (String enchant : Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Enable_Vanilla_Enchantment")).getKeys(false)) {

            if (enchant == null) continue;
            if (AziCraft.inst().getConfig().getBoolean("Enable_Vanilla_Enchantment." + enchant, true)) {
                list.add(Enchantment.getByKey(NamespacedKey.minecraft(enchant)));
            }
        }
        return list;
    }

    //対象のエンチャントが有効か確認する。
    @NotNull
    public static List<Enchantment> checkCustomEnchant() {

        List<Enchantment> list = new ArrayList<>();

        for (String customEnchant: Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Enable_Custom_Enchantment")).getKeys(false)) {

            if (customEnchant == null) {continue;}
            if (AziCraft.inst().getConfig().getBoolean("Enable_Custom_Enchantment." + customEnchant, true)) {

                for (String str: Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Custom_Enchantment_values")).getKeys(false)) {
                    if (str.equals(customEnchant)) list.add(Enchantment.getByKey(NamespacedKey.minecraft(str)));
                }
            }
        }
        return list;
    }

    public static void checkCustomType(ItemStack itemStack, Player player, int level) {

        List<Enchantment> vanilla = new ArrayList<>();
        List<Enchantment> custom = new ArrayList<>();
        Map<Enchantment, Integer> map1 = new LinkedHashMap<>();
        Map<Enchantment, Integer> map2 = new LinkedHashMap<>();

        if (!itemStack.hasItemMeta()) return;
        if (!itemStack.getItemMeta().getPersistentDataContainer().has(NamespacedKey.minecraft("custom_type"), PersistentDataType.STRING)) return;
        //対象のエンチャントとアイテムのタイプが一致しているかチェック。
        for (Enchantment enchant : checkNormalEnchant()) {

            String str = itemStack.getItemMeta().getPersistentDataContainer().get(NamespacedKey.minecraft("custom_type"), PersistentDataType.STRING);
            if (Objects.requireNonNull(str).equals(editCustomType(enchant))) {
                vanilla.add(enchant);
            }
        }

        //対象のエンチャントとアイテムのタイプが一致しているかチェック。
        for (Enchantment uwp : checkCustomEnchant()) {

            if (uwp == null) continue;

            String str = itemStack.getItemMeta().getPersistentDataContainer().get(NamespacedKey.minecraft("custom_type"), PersistentDataType.STRING);

            for (String string : Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Custom_Enchantment_values")).getKeys(false)) {

                if (uwp.getKey().getKey().equals(string) &&
                        Objects.requireNonNull(str).equals(AziCraft.inst().getConfig().getString("Custom_Enchantment_values." + string + ".type"))) {
                    custom.add(Enchantment.getByKey(NamespacedKey.minecraft(string)));
                }
            }
        }

        if (vanilla.size() != 0) {

            //アイテムに付けれるエンチャントを全て格納する。
            for (Enchantment get : vanilla) {

                int maxLv = new EditEnchantList().editMaxLevel(get);
                int minRange = new EditEnchantList().editCustomTableStartLevel(get);
                int MaxRange = new EditEnchantList().editCustomTableEndLevel(get);
                int perLvAdd = new EditEnchantList().editCustomTableRate(get);

                for (int i = 1; i <= maxLv; i++) {

                    if (minRange <= level && level <= MaxRange) {
                        map1.put(get, i);
                    }
                    minRange = minRange + perLvAdd;
                    MaxRange = MaxRange + perLvAdd;
                }
            }
        }

        if (custom.size() != 0) {

            //アイテムに付けれるエンチャントを全て格納する。
            for (Enchantment get : custom) {

                int maxLv = new CustomEnchantList().getMaxLevel(get);
                int MinRange = new CustomEnchantList().getTableStartLv(get);
                int MaxRange = new CustomEnchantList().getTableEndLv(get);
                int perLvAdd = new CustomEnchantList().getRangeAdd(get);

                for (int i = 1; i <= maxLv; i++) {

                    if (MinRange <= level && level <= MaxRange) {
                        map2.put(get, i);
                    }
                    MinRange = MinRange + perLvAdd;
                    MaxRange = MaxRange + perLvAdd;
                }
            }
        }

        //後はエンチャントをランダムで付ける。
        Integer rankI = itemStack.getItemMeta().getPersistentDataContainer().get(Objects.requireNonNull(NamespacedKey.fromString("rank", AziCraft.inst())), PersistentDataType.INTEGER);
        int rank = 0;
        if (String.valueOf(rankI) != null && rankI != null) {
            rank = Integer.parseInt(String.valueOf(rankI));
        }

        List<Enchantment> record = new ArrayList<>();
        int chance = (int) (Math.random() * 4) + 1 + (rank * 2);
        int random = (int) (Math.random() * (map1.size() + map2.size()));

        //1つは必ずエンチャントする Enchantment ver

        if (!map1.isEmpty() && random <= map1.size()) {
            int count = 0;
            for (Map.Entry<Enchantment, Integer> mapGet : map1.entrySet()) {
                if (mapGet == null) continue;
                count = count + 1;
                if (random + 1 == count) {
                    itemStack.addUnsafeEnchantment(mapGet.getKey(), mapGet.getValue());
                    enchantmentSetter(itemStack, mapGet.getKey(), mapGet.getValue(), player);
                    chance = chance - 1;
                    //player.sendMessage(mapGet.getKey().displayName(mapGet.getValue()));
                }
            }
        }

        random = random - map1.size();

        //1つは必ずエンチャントする UWPEnchantment ver
        if (!map2.isEmpty() && !(chance <= 0) && random <= map2.size()) {
            int count = 0;
            for (Map.Entry<Enchantment, Integer> mapGet2 : map2.entrySet()) {
                if (mapGet2 == null) continue;
                count = count + 1;
                if (random + 1 == count) {
                    itemStack.addUnsafeEnchantment(mapGet2.getKey(), mapGet2.getValue());
                    enchantmentSetter(itemStack, mapGet2.getKey(), mapGet2.getValue(), player);
                    chance = chance - 1;
                    //player.sendMessage(mapGet2.getKey().displayName(mapGet2.getValue()));
                }
            }
        }

        //2度目以降の抽選 Enchantment ver
        for (int i = 1; i <= chance; i++) {

            int random2 = (int) (Math.random() * (map1.size() + map2.size() + 5));

            if (!map1.isEmpty() && !(chance <= 0) && random2 <= map1.size()) {
                int count = 0;
                for (Map.Entry<Enchantment, Integer> map : map1.entrySet()) {
                    if (map == null) continue;
                    count = count + 1;
                    if (random2 + 1 == count) {
                        itemStack.addUnsafeEnchantment(map.getKey(), map.getValue());
                        enchantmentSetter(itemStack, map.getKey(), map.getValue(), player);
                        chance = chance -1;
                        //player.sendMessage(map.getKey().displayName(map.getValue()));
                    }
                }
            }

            random2 = random2 - map1.size();

            //2度目以降の抽選 UWPEnchantment ver
            if (!map2.isEmpty() && !(chance <= 0) && random2 <= map2.size()) {
                int count = 0;
                for (Map.Entry<Enchantment, Integer> map : map2.entrySet()) {
                    if (map == null) continue;
                    count = count + 1;
                    if (random2 + 1 == count) {
                        itemStack.addUnsafeEnchantment(map.getKey(), map.getValue());
                        enchantmentSetter(itemStack, map.getKey(), map.getValue(), player);
                        chance = chance - 1;
                        //player.sendMessage(map.getKey().displayName(map.getValue()));
                    }
                }
                //2度目以降の抽選 ハズレ
            } else {chance = chance - 1;}
        }
    }

    public static void enchantmentSetter(ItemStack item, Enchantment enchantment, int level, Player player) {

        if (enchantment.getKey().getKey().equals(TOUGHNESS_POINT.getKey().getKey())) {
            toughnessSetter(item, enchantment, level, player);
            return;
        }
        if (enchantment.getKey().getKey().equals(HEALTH_BOOSTER.getKey().getKey())) {
            HealthSetter(item, enchantment, level, player);
            return;
        }
        if (enchantment.getKey().getKey().equals(ARMOR_POINT.getKey().getKey())) {
            armorPointNSetter(item, enchantment, level, player);
            return;
        }
        vanillaEnchant(item, enchantment, level, player);
        weaponDamage(item, enchantment, level, player);
    }
}
