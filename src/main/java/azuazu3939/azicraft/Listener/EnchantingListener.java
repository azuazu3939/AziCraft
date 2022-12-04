package azuazu3939.azicraft.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import static azuazu3939.azicraft.ItemStack.ItemStackEnchant.onEnchantItemStack;
import static azuazu3939.azicraft.ItemStack.ItemStackEnchant.onRemoveEnchant;

public class EnchantingListener implements Listener {


    @EventHandler
    public void onEnchant(EnchantItemEvent event) {
        onEnchantItemStack(event);
    }

    @EventHandler
    public void onItemMerge(ItemMergeEvent event) {event.setCancelled(true);}

    @EventHandler
    public void onRemove(InventoryClickEvent event) {
        onRemoveEnchant(event);
    }
}
