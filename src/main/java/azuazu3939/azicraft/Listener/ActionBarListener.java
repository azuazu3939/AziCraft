package azuazu3939.azicraft.Listener;

import azuazu3939.azicraft.AziCraft;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import static azuazu3939.azicraft.ActionBarReturner.ActionBarSender;
import static azuazu3939.azicraft.AttributeReturner.*;
import static azuazu3939.azicraft.SetHealthScale.SetHealthScaleSetter;

public class ActionBarListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();

        if (world.getName().equalsIgnoreCase(AziCraft.inst().getConfig().getString("ActionBarShowWorldName", "AziCraft"))) {

            AttributeGetter(player);
            ActionBarSender(player, d1, d2, d3, d4);
            SetHealthScaleSetter(player);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {

        Player player = event.getPlayer();
        World world = player.getWorld();

        if (world.getName().equalsIgnoreCase(AziCraft.inst().getConfig().getString("ActionBarShowWorldName", "AziCraft"))) {

            AttributeGetter(player); //actionBar取得
            ActionBarSender( player, d1, d2, d3, d4); //actionBarセット
            SetHealthScaleSetter(player); //Health20に偽装

            ItemStack itemStack = player.getEquipment().getItemInMainHand();
            if (itemStack.getItemMeta() == null || itemStack.getType() == Material.AIR) return;

        }
    }

    @EventHandler
    public void onChangeWorld(PlayerChangedWorldEvent event) {

        Player player = event.getPlayer();
        World world = event.getPlayer().getWorld();

        if (world.getName().equalsIgnoreCase(AziCraft.inst().getConfig().getString("ActionBarShowWorldName", "AziCraft"))) {

            AttributeGetter(player);
            ActionBarSender(player, d1, d2, d3, d4);
            SetHealthScaleSetter(player);
        }
    }
}
