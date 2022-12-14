package azuazu3939.azicraft;

import azuazu3939.azicraft.Listener.ActionBarListener;
import azuazu3939.azicraft.Listener.ActionListener;
import azuazu3939.azicraft.Listener.CombatListener;
import azuazu3939.azicraft.Listener.EnchantingListener;
import azuazu3939.azicraft.NMS.EnchantManager;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

import static azuazu3939.azicraft.Enchants.Custom.EnchantmentArmorPoint.ARMOR_POINT;
import static azuazu3939.azicraft.Enchants.Custom.EnchantmentHealthBooster.HEALTH_BOOSTER;
import static azuazu3939.azicraft.Enchants.Custom.EnchantmentToughnessPoint.TOUGHNESS_POINT;


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
        getServer().getPluginManager().registerEvents(new ActionListener(), this);

        new EnchantManager().reload();

        register(HEALTH_BOOSTER);
        register(ARMOR_POINT);
        register(TOUGHNESS_POINT);

    }
    @Override
    public void onDisable() {

    }

    public void register(Enchantment enchantment) {

        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.setBoolean(null, true);

            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            getLogger().warning(enchantment.getKey().getKey() + "は既に追加されているためスキップされました。");
        }
    }
}
