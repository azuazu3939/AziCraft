package azuazu3939.azicraft;

import net.kyori.adventure.text.Component;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ActionBarReturner {

    public static void ActionBarSender(Player player, double num1, double num2, double num3, double num4) {

        int num0 = (int) player.getHealth();
        int num1_0 = (int) num1;
        int num2_0 = (int) num2;
        int num3_0 = (int) num3;
        int num4_0 = (int) num4;
        player.sendActionBar(Component.text(ChatColor.translateAlternateColorCodes('&', "&a体力 &f" + num0 + "/" + num1_0 + " &c攻撃力 &f" + num2_0 + " &b防御力 &f" + num3_0 + " &e軽減値 &f" + num4_0)));
    }
}
