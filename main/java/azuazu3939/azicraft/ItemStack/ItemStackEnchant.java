package azuazu3939.azicraft.ItemStack;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import static azuazu3939.azicraft.ItemMeta.AttributeLoreMeta.loreSetter;
import static azuazu3939.azicraft.ItemMeta.AttributeLoreMeta.removeLore;
import static azuazu3939.azicraft.ItemMeta.WeaponDamageMeta.weaponDamage;
import static azuazu3939.azicraft.ItemMeta.WeaponDamageMeta.weaponDamageRemover;
import static azuazu3939.azicraft.NMS.ArmorPointEnchantsNMS.armorPointNSetter;
import static azuazu3939.azicraft.NMS.HealthBoosterEnchantsNMS.HealthSetter;
import static azuazu3939.azicraft.NMS.ToughnessPointEnchantsNMS.toughnessSetter;

public class ItemStackEnchant extends ItemStack {

    public static void onEnchantItemStack(EnchantItemEvent event) {

        //カスタムエンチャント
        ItemStack itemStack = event.getItem();
        removeLore(itemStack);

        loreSetter(itemStack);

    }

    public static void onRemoveEnchant(InventoryClickEvent event) {

        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getType() == InventoryType.GRINDSTONE && event.getSlotType() == InventoryType.SlotType.RESULT) {
            if (event.getCurrentItem() == null) return;
            ItemStack itemStack = event.getCurrentItem();
            if (itemStack == null) return;

            weaponDamageRemover(itemStack);
            removeLore(itemStack);

        }
    }

    public static void onEnchantItemStackN(EnchantItemEvent event, Enchantment enchantment, int level) {

        //通常エンチャント
        ItemStack itemStack = event.getItem();
        weaponDamage(itemStack, enchantment, level);
        HealthSetter(itemStack, enchantment, level);
        toughnessSetter(itemStack, enchantment, level);
        armorPointNSetter(itemStack, enchantment, level);

    }
}
