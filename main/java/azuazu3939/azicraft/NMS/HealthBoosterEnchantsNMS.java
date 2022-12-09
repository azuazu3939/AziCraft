package azuazu3939.azicraft.NMS;

import azuazu3939.azicraft.ItemMeta.HealthBoosterMeta;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentSlotType;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class HealthBoosterEnchantsNMS extends Enchantment {

    public HealthBoosterEnchantsNMS(Rarity var0, EnumItemSlot[] var2) {
        super(var0, EnchantmentSlotType.a, var2);
    }

    public int a(int var0) {
        return 5 + (var0 - 1) * 12;
    }

    public int b(int var0) {
        return super.a(var0) + 50;
    }

    public int a() {
        return 10;
    }

    public String f() {
            this.f = ChatColor.GRAY + "体力";

        return this.f;
    }

    public static void HealthSetter(ItemStack itemStack, org.bukkit.enchantments.Enchantment enchantment, int level) {

        HealthBoosterMeta.HealthSetter(itemStack, enchantment, level);
    }
}
