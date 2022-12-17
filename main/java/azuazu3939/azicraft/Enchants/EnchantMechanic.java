package azuazu3939.azicraft.Enchants;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import static azuazu3939.azicraft.Enchants.EnchantingSystem.checkCustomType;

public class EnchantMechanic {

    public static void EnchantmentMechanic(ItemStack itemStack, Player player, int level) {

        checkCustomType(itemStack, player, level);
    }
}
