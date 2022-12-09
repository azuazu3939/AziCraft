package azuazu3939.azicraft.Listener;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class CombatListener implements Listener {

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent event) {

        if (event.getDamager() instanceof Player player) {
            double damageDef = event.getFinalDamage();

            int count1 = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DAMAGE_ALL);
            int count2 = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DAMAGE_UNDEAD);
            int count3 = player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.DAMAGE_ARTHROPODS);
            double amount = 1 + (count1 * 5 + count2 * 7 + count3 * 7) / 100.0;

            player.sendMessage("a");
            event.setDamage(amount * damageDef);
        }
    }
}
