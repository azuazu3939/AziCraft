package azuazu3939.azicraft;

import azuazu3939.azicraft.Listener.ActionBarListener;
import azuazu3939.azicraft.Listener.AllActionListener;
import azuazu3939.azicraft.Listener.CombatListener;
import azuazu3939.azicraft.Listener.EnchantingListener;
import azuazu3939.azicraft.NMS.EnchantManager;
import org.bukkit.craftbukkit.v1_19_R1.enchantments.CraftEnchantment;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;


public final class AziCraft extends JavaPlugin {

    private static AziCraft aziCraft;

    public AziCraft() {aziCraft = this;}

    public static AziCraft inst() {return aziCraft;}

    @Override
    public void onEnable() {
        saveDefaultConfig();
        saveConfig();
        getServer().getPluginManager().registerEvents(new ActionBarListener(), this);
        getServer().getPluginManager().registerEvents(new EnchantingListener(), this);
        getServer().getPluginManager().registerEvents(new CombatListener(), this);
        getServer().getPluginManager().registerEvents(new AllActionListener(), this);

        new EnchantManager().reload();

        //register(HEALTH_BOOSTER);
        //register(ARMOR_POINT);
        //register(TOUGHNESS_POINT);

    }
    @Override
    public void onDisable() {

    }

    public void register(Enchantment enchantment) {

        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.setBoolean(null, true);

            if (!hasRegistered(enchantment)) {

                CraftEnchantment.registerEnchantment(enchantment);
            }

            Enchantment.stopAcceptingRegistrations();
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean hasRegistered(Enchantment enchantment) {

        for (Enchantment enchant:  CraftEnchantment.values()) {
            if (enchant.equals(enchantment)) {
                return true;
            }
        }
        return false;
    }
}
