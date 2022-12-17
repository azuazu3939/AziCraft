package azuazu3939.azicraft;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class AttributeReturner {

    public static double d1;
    public static double d2;
    public static double d3;
    public static double d4;
   public static void AttributeGetter(Player player) {

       d1 = 0;
       d2 = 0;
       d3 = 0;
       d4 = 0;
       ArrayList<Double> listArmor = new ArrayList<>();
       ArrayList<Double> listToughness = new ArrayList<>();
       ArrayList<Double> listHealth = new ArrayList<>();
       ArrayList<Double> listDamage = new ArrayList<>();

       AttributeInstance attr1 = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
       AttributeInstance attr2 = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
       AttributeInstance attr3 = player.getAttribute(Attribute.GENERIC_ARMOR);
       AttributeInstance attr4 = player.getAttribute(Attribute.GENERIC_ARMOR_TOUGHNESS);
       if (attr1 == null || attr2 == null || attr3 == null || attr4 == null) return;

       for (AttributeModifier modifier: attr1.getModifiers()) {
           listHealth.add(modifier.getAmount());
       }

       for (Double health : listHealth) {
           d1 = health + d1;
       }

       d1 = attr1.getBaseValue() +d1;
       listHealth.clear();
       for (AttributeModifier modifier: attr2.getModifiers()) {
           listDamage.add(modifier.getAmount());
       }

       for (Double damage : listDamage) {
           d2 = damage + d2;
       }

       d2 = attr2.getBaseValue() +d2;
       listDamage.clear();
       for (AttributeModifier modifier: attr3.getModifiers()) {
           listArmor.add(modifier.getAmount());
       }

       for (Double armor : listArmor) {
           d3 = armor + d3;
       }

       d3 = attr3.getBaseValue() +d3;
       listArmor.clear();
       for (AttributeModifier modifier: attr4.getModifiers()) {
           listToughness.add(modifier.getAmount());
       }

       for (Double toughness : listToughness) {
           d4 = toughness + d4;
       }

       d4 = attr4.getBaseValue() +d4;
       listToughness.clear();
   }
}
