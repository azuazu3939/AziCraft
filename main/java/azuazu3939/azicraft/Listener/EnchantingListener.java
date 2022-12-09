package azuazu3939.azicraft.Listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Map;
import java.util.Set;

import static azuazu3939.azicraft.ItemStack.ItemStackEnchant.*;

public class EnchantingListener implements Listener {


    @EventHandler
    public void onEnchant(EnchantItemEvent event) {

        onEnchantItemStack(event);

       Set<Map.Entry<Enchantment, Integer>> set = event.getEnchantsToAdd().entrySet();

       for (Map.Entry<Enchantment, Integer> map : set) {

           onEnchantItemStackN(event, map.getKey(), map.getValue());
       }
    }

    @EventHandler
    public void onItemMerge(ItemMergeEvent event) {event.setCancelled(true);}

    @EventHandler
    public void onRemove(InventoryClickEvent event) {
        onRemoveEnchant(event);
    }
}
