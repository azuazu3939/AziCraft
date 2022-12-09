package azuazu3939.azicraft.Listener;

import com.destroystokyo.paper.event.player.PlayerArmorChangeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import static azuazu3939.azicraft.ItemMeta.AttributeLoreMeta.checkLore;

public class AllActionListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {

        ItemStack itemStack = event.getCurrentItem();

        if (itemStack != null) {
            checkLore(itemStack);
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {

        ItemStack itemStack = event.getItem();
        if (itemStack != null) {
            checkLore(itemStack);
        }
    }

    @EventHandler
    public void onChange(PlayerArmorChangeEvent event) {

        ItemStack itemStack = event.getNewItem();
        ItemStack itemStack1 = event.getOldItem();

        if (itemStack != null) {
            checkLore(itemStack);
        }
        if (itemStack1 != null) {
            checkLore(itemStack1);
        }
    }

    @EventHandler
    public void onMoveItem(InventoryMoveItemEvent event) {

        ItemStack itemStack = event.getItem();

        if (itemStack != null) {
            checkLore(itemStack);
        }
    }
}
