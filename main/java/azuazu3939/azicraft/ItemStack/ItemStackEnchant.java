package azuazu3939.azicraft.ItemStack;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

import static azuazu3939.azicraft.ItemMeta.AttributeLoreMeta.removeLore;

public class ItemStackEnchant extends ItemStack {

    public static void onRemoveEnchant(InventoryClickEvent event) {

        if (event.getClickedInventory() == null) return;
        if (event.getClickedInventory().getType() == InventoryType.GRINDSTONE && event.getSlotType() == InventoryType.SlotType.RESULT) {
            if (event.getCurrentItem() == null) return;
            ItemStack itemStack = event.getCurrentItem();
            if (itemStack == null) return;

            removeLore(itemStack);
        }
    }
}
