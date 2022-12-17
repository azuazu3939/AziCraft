package azuazu3939.azicraft.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import static azuazu3939.azicraft.Enchants.EnchantMechanic.EnchantmentMechanic;
import static azuazu3939.azicraft.ItemStack.ItemStackEnchant.onRemoveEnchant;

public class EnchantingListener implements Listener {


    @EventHandler
    public void onEnchant(EnchantItemEvent event) {

        EnchantmentMechanic(event.getItem(), event.getEnchanter(), event.getExpLevelCost());
        event.setCancelled(true);

    }

    @EventHandler
    public void onItemMerge(ItemMergeEvent event) {event.setCancelled(true);}

    @EventHandler
    public void onRemove(InventoryClickEvent event) {
        onRemoveEnchant(event);
    }
}
