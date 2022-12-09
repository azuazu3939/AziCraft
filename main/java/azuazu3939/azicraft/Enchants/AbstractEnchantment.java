package azuazu3939.azicraft.Enchants;

import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractEnchantment extends Enchantment {

    public AbstractEnchantment(@NotNull String key) {
        super(NamespacedKey.minecraft(key));
    }
}
