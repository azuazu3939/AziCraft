package azuazu3939.azicraft.Enchants.Custom;

import azuazu3939.azicraft.AziCraft;
import org.bukkit.enchantments.Enchantment;

import java.util.Objects;

public class CustomEnchantList {

    public int getMaxLevel(Enchantment enchantment) {

        for (String str : Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Custom_Enchantment_values")).getKeys(false)) {

            if (enchantment.getKey().getKey().equals(str)) {
                return AziCraft.inst().getConfig().getInt("Custom_Enchantment_values." + str + ".maxLv");
            }
        }
        return 0;
    }

    public int getTableStartLv(Enchantment enchantment) {

        for (String str : Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Custom_Enchantment_values")).getKeys(false)) {

            if (enchantment.getKey().getKey().equals(str)) {
                return AziCraft.inst().getConfig().getInt("Custom_Enchantment_values." + str + ".tableStartLv");
            }
        }
        return 0;
    }

    public int getTableEndLv(Enchantment enchantment) {

        for (String str : Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Custom_Enchantment_values")).getKeys(false)) {

            if (enchantment.getKey().getKey().equals(str)) {
                return getTableStartLv(enchantment) + AziCraft.inst().getConfig().getInt("Custom_Enchantment_values." + str + ".tableEndLv");
            }
        }
        return 0;
    }

    public int getRangeAdd(Enchantment enchantment) {

        for (String str : Objects.requireNonNull(AziCraft.inst().getConfig().getConfigurationSection("Custom_Enchantment_values")).getKeys(false)) {

            if (enchantment.getKey().getKey().equals(str)) {
                return AziCraft.inst().getConfig().getInt("Custom_Enchantment_values." + str + ".rangeAdd");
            }
        }
        return 0;
    }
}
