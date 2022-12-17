package azuazu3939.azicraft.Enchants.Custom;

import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.jetbrains.annotations.NotNull;

public abstract class UWPEnchantment extends Enchantment implements Keyed {

    private final NamespacedKey key;

    protected UWPEnchantment(NamespacedKey key) {
        super(key);
        this.key = key;
    }
    @NotNull
    @Override
    public NamespacedKey getKey() {
        return key;
    }
}
