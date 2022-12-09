package azuazu3939.azicraft.NMS;

import azuazu3939.azicraft.ItemMeta.ArmorPointNormalMeta;
import net.minecraft.world.entity.EnumItemSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentSlotType;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class ArmorPointEnchantsNMS extends Enchantment {

    public ArmorPointEnchantsNMS(Rarity var0, EnumItemSlot[] var2) {
        super(var0, EnchantmentSlotType.a, var2);
    }

    public int a(int var0) {
        return 8 + (var0 - 1) * 10;
    }

    public int b(int var0) {
        return super.a(var0) + 55;
    }

    public int a() {
        return 10;
    }

    public String f() {
        this.f = ChatColor.GRAY + "通常防御";

        return this.f;
    }

    public static void armorPointNSetter(ItemStack itemStack, org.bukkit.enchantments.Enchantment enchantment, int level) {

        ArmorPointNormalMeta.armorPointNSetter(itemStack, enchantment, level);
    }
}
