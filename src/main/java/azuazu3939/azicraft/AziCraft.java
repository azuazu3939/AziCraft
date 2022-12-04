package azuazu3939.azicraft;

import azuazu3939.azicraft.Enchants.EnchantManager;
import azuazu3939.azicraft.Listener.ActionBarListener;
import azuazu3939.azicraft.Listener.EnchantingListener;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

import static azuazu3939.azicraft.Enchants.EnchantmentArmorPointNormal.ARMOR_POINT_NORMAL;
import static azuazu3939.azicraft.Enchants.EnchantmentHealthBooster.HEALTH_BOOSTER;
import static azuazu3939.azicraft.Enchants.EnchantmentToughnessPoint.ARMOR_TOUGHNESS;


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

        new EnchantManager().reload();

        registering();
    }
    @Override
    public void onDisable() {

    }

    public static void registering() {

        try {
            Field fieldNew = Enchantment.class.getDeclaredField("acceptingNew");
            fieldNew.setAccessible(true);
            fieldNew.set(null, true);

            Enchantment.registerEnchantment(ARMOR_TOUGHNESS);
            Enchantment.registerEnchantment(ARMOR_POINT_NORMAL);
            Enchantment.registerEnchantment(HEALTH_BOOSTER);

            fieldNew.setAccessible(false);
        } catch (Exception e) {
            return; //バグる場合はここで確認。
        }
    }
}
