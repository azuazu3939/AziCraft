package azuazu3939.azicraft.NMS;

import azuazu3939.azicraft.AziCraft;
import javassist.*;
import net.blueberrymc.nativeutil.ClassDefinition;
import net.blueberrymc.nativeutil.NativeUtil;

import java.io.IOException;
import java.util.function.Function;


public class EnchantManager {

    private static final ClassPool cp = ClassPool.getDefault();
    private static String body;

    private void queueClass(String name, Function<String, byte[]> bytecodeProvider) {

        Class<?> clazz = getLoadedClass(name);
        if (clazz != null) {
            AziCraft.inst().getLogger().info(name + " is already loaded, attempting to redefine the class");
            byte[] bytecode = bytecodeProvider.apply(name);
            NativeUtil.redefineClasses(new ClassDefinition[]{new ClassDefinition(clazz, bytecode)});
            AziCraft.inst().getLogger().info(name + " has been redefined");
        } else {
            AziCraft.inst().getLogger().info(name + " is not loaded, registering a class load hook");
            NativeUtil.registerClassLoadHook((classLoader, cname, redefiningClass, protectionDomain, bytes) -> {
                if (cname.replace('/', '.').equals(name)) {
                    AziCraft.inst().getLogger().info("Modifying class " + name);
                    byte[] bytecode = bytecodeProvider.apply(name);
                    AziCraft.inst().getLogger().info("Modified class " + name);
                    return bytecode;
                }
                return null;
            });
        }
    }
    private static byte[] rewriteEnchantManagerClass(String name) {
        try {
            CtClass cc = cp.get(name);
            cc.defrost();
            cc.getMethod("a", "(Lnet/minecraft/util/RandomSource;IILnet/minecraft/world/item/ItemStack;)I").setBody(body);
            AziCraft.inst().getLogger().info("エンチャントテーブルに使用する本棚の最大設置可能数が" + AziCraft.inst().getConfig().getInt("MaxEnchantTableLevel", 50) + "に変更されました。");
            return cc.toBytecode();
        } catch (NotFoundException | CannotCompileException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static byte[] rewriteEnchantWeaponDamageClass(String name) {
        try {
            CtClass cc = cp.get(name);
            cc.defrost();
            cc.getMethod("a", "(ILnet/minecraft/world/entity/EnumMonsterType;)F").setBody("{ return 0F;}");
            AziCraft.inst().getLogger().info("WeaponDamageエンチャントがカスタムされました。");
            return cc.toBytecode();
        } catch (NotFoundException | CannotCompileException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] rewriteEnchantProtectionClass(String name) {
        try {
            CtClass cc = cp.get(name);
            cc.defrost();
            cc.getMethod("a", "(ILnet/minecraft/world/damagesource/DamageSource;)I").setBody(
                    """
                            {
                              if ($2.i()) {
                                return 0;
                              } else if (this.a == net.minecraft.world.item.enchantment.EnchantmentProtection.DamageType.a) {
                                return 0;
                              } else if (this.a == net.minecraft.world.item.enchantment.EnchantmentProtection.DamageType.b && $2.u()) {
                                return 0;
                              } else if (this.a == net.minecraft.world.item.enchantment.EnchantmentProtection.DamageType.c && $2.B()) {
                                return 0;
                              } else if (this.a == net.minecraft.world.item.enchantment.EnchantmentProtection.DamageType.d && $2.d()) {
                                return 0;
                              } else if (this.a == net.minecraft.world.item.enchantment.EnchantmentProtection.DamageType.e && $2.b()) {
                                return 0;
                              }
                              return 0;
                            }"""
                    );
            AziCraft.inst().getLogger().info("ダメージ軽減エンチャント類の効果が無効化されました。");
            return cc.toBytecode();
        } catch (NotFoundException | CannotCompileException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static Class<?> getLoadedClass(String name) {
        for (Class<?> clazz: NativeUtil.getLoadedClasses()) {
            if (clazz.getTypeName().equals(name)) {
                return clazz;
            }
        }
        return null;
    }
    public void reload() {
        // 1.19 Only

        String string = String.valueOf(AziCraft.inst().getConfig().getInt("MaxEnchantTableLevel", 50));
        body = AziCraft.inst().getConfig().getString("body",
                "{\n" +
                        "  net.minecraft.world.item.Item var4 = $4.c();\n" +
                        "  int var5 = var4.c();\n" +
                        "  if (var5 <= 0) {\n" +
                        "    return 0;\n" +
                        "  } else if ($3 > " + string + ") {$3 = " + string + " ;}\n" +
                        "  int var6 = $1.a(8) + 1 + ($3 >> 1) + $1.a($3 + 1);\n" +
                        "  if ($2 == 0) {\n" +
                        "    return Math.max(var6 / 3, 1);\n" +
                        "  } else {return $2 == 1 ? var6 * 2 / 3 + 1 : Math.max(var6, $3 * 2);}\n" +
                        "}"
                );

        queueClass("net.minecraft.world.item.enchantment.EnchantmentProtection", EnchantManager::rewriteEnchantProtectionClass);
        queueClass("net.minecraft.world.item.enchantment.EnchantmentWeaponDamage", EnchantManager::rewriteEnchantWeaponDamageClass);
        queueClass("net.minecraft.world.item.enchantment.EnchantmentManager", EnchantManager::rewriteEnchantManagerClass);
    }
}
