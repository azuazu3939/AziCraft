package azuazu3939.azicraft.Enchants.Vanilla;

import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

import static org.bukkit.enchantments.Enchantment.*;

public class EditEnchantList  {

    public int editMaxLevel(Enchantment enchantment) {

        if (enchantment.getKey().getKey().equals(DAMAGE_ALL.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_ARTHROPODS.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_UNDEAD.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(ARROW_DAMAGE.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(ARROW_FIRE.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(ARROW_KNOCKBACK.getKey().getKey())) {
            return 3;
        } else if (enchantment.getKey().getKey().equals(DIG_SPEED.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(SWEEPING_EDGE.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(DEPTH_STRIDER.getKey().getKey())) {
            return 3;
        } else if (enchantment.getKey().getKey().equals(WATER_WORKER.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(KNOCKBACK.getKey().getKey())) {
            return 5;
        } else if (enchantment.getKey().getKey().equals(LOOT_BONUS_BLOCKS.getKey().getKey())) {
            return 5;
        } else if (enchantment.getKey().getKey().equals(OXYGEN.getKey().getKey())) {
            return 15;
        } else if (enchantment.getKey().getKey().equals(ARROW_INFINITE.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(LURE.getKey().getKey())) {
            return 5;
        } else if (enchantment.getKey().getKey().equals(SILK_TOUCH.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(FIRE_ASPECT.getKey().getKey())) {
            return 5;
        }
        return 1;
    }

    public int editCustomTableStartLevel(Enchantment enchantment) {

        if (enchantment.getKey().getKey().equals(DAMAGE_ALL.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_ARTHROPODS.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_UNDEAD.getKey().getKey())) {
            return 10;
        } else if (enchantment.getKey().getKey().equals(ARROW_DAMAGE.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(ARROW_FIRE.getKey().getKey())) {
            return 15;
        } else if (enchantment.getKey().getKey().equals(ARROW_KNOCKBACK.getKey().getKey())) {
            return 5;
        } else if (enchantment.getKey().getKey().equals(DIG_SPEED.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(SWEEPING_EDGE.getKey().getKey())) {
            return 20;
        } else if (enchantment.getKey().getKey().equals(DEPTH_STRIDER.getKey().getKey())) {
            return 15;
        } else if (enchantment.getKey().getKey().equals(WATER_WORKER.getKey().getKey())) {
            return 20;
        } else if (enchantment.getKey().getKey().equals(KNOCKBACK.getKey().getKey())) {
            return 5;
        } else if (enchantment.getKey().getKey().equals(LOOT_BONUS_BLOCKS.getKey().getKey())) {
            return 15;
        } else if (enchantment.getKey().getKey().equals(OXYGEN.getKey().getKey())) {
            return 7;
        } else if (enchantment.getKey().getKey().equals(ARROW_INFINITE.getKey().getKey())) {
            return 30;
        } else if (enchantment.getKey().getKey().equals(LURE.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(SILK_TOUCH.getKey().getKey())) {
            return 25;
        } else if (enchantment.getKey().getKey().equals(FIRE_ASPECT.getKey().getKey())) {
            return 10;
        }
        return 1;
    }

    public int editCustomTableEndLevel(Enchantment enchantment) {

        if (enchantment.getKey().getKey().equals(DAMAGE_ALL.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_ARTHROPODS.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_UNDEAD.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(ARROW_DAMAGE.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(ARROW_FIRE.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 75;
        } else if (enchantment.getKey().getKey().equals(ARROW_KNOCKBACK.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 30;
        } else if (enchantment.getKey().getKey().equals(DIG_SPEED.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 20;
        } else if (enchantment.getKey().getKey().equals(SWEEPING_EDGE.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(DEPTH_STRIDER.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 20;
        } else if (enchantment.getKey().getKey().equals(WATER_WORKER.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 85;
        } else if (enchantment.getKey().getKey().equals(KNOCKBACK.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 35;
        } else if (enchantment.getKey().getKey().equals(LOOT_BONUS_BLOCKS.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(OXYGEN.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        } else if (enchantment.getKey().getKey().equals(ARROW_INFINITE.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 75;
        } else if (enchantment.getKey().getKey().equals(LURE.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 20;
        } else if (enchantment.getKey().getKey().equals(SILK_TOUCH.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 80;
        } else if (enchantment.getKey().getKey().equals(FIRE_ASPECT.getKey().getKey())) {
            return editCustomTableStartLevel(enchantment) + 25;
        }
        return 6;
    }

    public int editCustomTableRate(Enchantment enchantment) {

        if (enchantment.getKey().getKey().equals(DAMAGE_ALL.getKey().getKey())) {
            return 8;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_ARTHROPODS.getKey().getKey())) {
            return 8;
        } else if (enchantment.getKey().getKey().equals(DAMAGE_UNDEAD.getKey().getKey())) {
            return 8;
        } else if (enchantment.getKey().getKey().equals(ARROW_DAMAGE.getKey().getKey())) {
            return 8;
        } else if (enchantment.getKey().getKey().equals(ARROW_FIRE.getKey().getKey())) {
            return 35;
        } else if (enchantment.getKey().getKey().equals(ARROW_KNOCKBACK.getKey().getKey())) {
            return 20;
        } else if (enchantment.getKey().getKey().equals(DIG_SPEED.getKey().getKey())) {
            return 9;
        } else if (enchantment.getKey().getKey().equals(SWEEPING_EDGE.getKey().getKey())) {
            return 6;
        } else if (enchantment.getKey().getKey().equals(DEPTH_STRIDER.getKey().getKey())) {
            return 20;
        } else if (enchantment.getKey().getKey().equals(WATER_WORKER.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(KNOCKBACK.getKey().getKey())) {
            return 20;
        } else if (enchantment.getKey().getKey().equals(LOOT_BONUS_BLOCKS.getKey().getKey())) {
            return 20;
        } else if (enchantment.getKey().getKey().equals(OXYGEN.getKey().getKey())) {
            return 5;
        } else if (enchantment.getKey().getKey().equals(ARROW_INFINITE.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(LURE.getKey().getKey())) {
            return 22;
        } else if (enchantment.getKey().getKey().equals(SILK_TOUCH.getKey().getKey())) {
            return 1;
        } else if (enchantment.getKey().getKey().equals(FIRE_ASPECT.getKey().getKey())) {
            return 23;
        }
        return 1;
    }

    public static @NotNull String editCustomType(@NotNull Enchantment enchantment) {

        if (enchantment.getKey().getKey().equals(DAMAGE_ALL.getKey().getKey())) {
            return "Weapon";
        } else if (enchantment.getKey().getKey().equals(DAMAGE_ARTHROPODS.getKey().getKey())) {
            return "Weapon";
        } else if (enchantment.getKey().getKey().equals(DAMAGE_UNDEAD.getKey().getKey())) {
            return "Weapon";
        } else if (enchantment.getKey().getKey().equals(ARROW_DAMAGE.getKey().getKey())) {
            return "Bow";
        } else if (enchantment.getKey().getKey().equals(ARROW_FIRE.getKey().getKey())) {
            return "Bow";
        } else if (enchantment.getKey().getKey().equals(ARROW_KNOCKBACK.getKey().getKey())) {
            return "Bow";
        } else if (enchantment.getKey().getKey().equals(DIG_SPEED.getKey().getKey())) {
            return "Tools";
        } else if (enchantment.getKey().getKey().equals(SWEEPING_EDGE.getKey().getKey())) {
            return "Weapon";
        } else if (enchantment.getKey().getKey().equals(DEPTH_STRIDER.getKey().getKey())) {
            return "Armor";
        } else if (enchantment.getKey().getKey().equals(WATER_WORKER.getKey().getKey())) {
            return "Armor";
        } else if (enchantment.getKey().getKey().equals(KNOCKBACK.getKey().getKey())) {
            return "Weapon";
        } else if (enchantment.getKey().getKey().equals(LOOT_BONUS_BLOCKS.getKey().getKey())) {
            return "Tools";
        } else if (enchantment.getKey().getKey().equals(OXYGEN.getKey().getKey())) {
            return "Armor";
        } else if (enchantment.getKey().getKey().equals(ARROW_INFINITE.getKey().getKey())) {
            return "Bow";
        } else if (enchantment.getKey().getKey().equals(LURE.getKey().getKey())) {
            return "Rod";
        } else if (enchantment.getKey().getKey().equals(SILK_TOUCH.getKey().getKey())) {
            return "Tools";
        } else if (enchantment.getKey().getKey().equals(FIRE_ASPECT.getKey().getKey())) {
            return "Weapon";
        } else return "NoType";
    }
}
