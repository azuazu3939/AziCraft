package azuazu3939.azicraft.NMS;

import azuazu3939.azicraft.ItemMeta.ToughnessMeta;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentSlotType;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class ToughnessPointEnchantsNMS extends Enchantment {

    public ToughnessPointEnchantsNMS(Rarity var0, EnumItemSlot[] var2) {
        super(var0, EnchantmentSlotType.a, var2);
    }

    public int a(int var0) {
        return 16 + (var0 - 1) * 16;
    }

    public int b(int var0) {
        return super.a(var0) + 32;
    }

    public int a() {
        return 5;
    }

    public String f() {
        this.f = ChatColor.GRAY + "実数ダメージ軽減";

        return this.f;
    }

    public static void toughnessSetter(ItemStack itemStack, org.bukkit.enchantments.Enchantment enchantment, int level) {

        ToughnessMeta.toughnessSetter(itemStack, enchantment, level);
    }
}
