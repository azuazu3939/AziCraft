package azuazu3939.azicraft.ItemStack;

import azuazu3939.azicraft.Enchants.EnchantmentArmorPointNormal;
import azuazu3939.azicraft.Enchants.EnchantmentHealthBooster;
import azuazu3939.azicraft.Enchants.EnchantmentToughnessPoint;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import static azuazu3939.azicraft.Enchants.EnchantmentArmorPointNormal.ARMOR_POINT_NORMAL;
import static azuazu3939.azicraft.Enchants.EnchantmentHealthBooster.HEALTH_BOOSTER;
import static azuazu3939.azicraft.Enchants.EnchantmentToughnessPoint.ARMOR_TOUGHNESS;
import static azuazu3939.azicraft.ItemMeta.ArmorPointNormalMeta.armorPointNRemover;
import static azuazu3939.azicraft.ItemMeta.HealthBoosterMeta.HealthRemover;
import static azuazu3939.azicraft.ItemMeta.ToughnessMeta.toughnessRemover;

public class ItemStackEnchant extends ItemStack {

    public static void onEnchantItemStack(EnchantItemEvent event) {

        ItemStack itemStack = event.getItem();
        itemStack.addUnsafeEnchantment(HEALTH_BOOSTER, 10);
        itemStack.addUnsafeEnchantment(ARMOR_POINT_NORMAL, 10);
        itemStack.addUnsafeEnchantment(ARMOR_TOUGHNESS, 5);
        EnchantmentHealthBooster.HealthSetter(itemStack);
        EnchantmentArmorPointNormal.armorPointNSetter(itemStack);
        EnchantmentToughnessPoint.toughnessSetter(itemStack);
    }

    public static void onRemoveEnchant(InventoryClickEvent event) {

        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getType() == InventoryType.GRINDSTONE && event.getSlotType() == InventoryType.SlotType.RESULT) {
            if (event.getCurrentItem() == null) return;
            ItemStack itemStack = event.getCurrentItem();
            if (itemStack == null) return;
            HealthRemover(itemStack);
            armorPointNRemover(itemStack);
            toughnessRemover(itemStack);
        }
    }
}
