package me.u9g.bettercows;
import net.kyori.adventure.util.Ticks;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class CowLootTable {
    private static ItemStack[] items = null;
    private static Random r = new Random();
    private static int THIRY_SECONDS_AS_TICKS = Ticks.TICKS_PER_SECOND * 30;

    private static ItemStack makePotion(Boolean good) {
        ItemStack potion = new ItemStack(Material.SPLASH_POTION);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setColor(Color.FUCHSIA);
        if (good) {
            meta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, CowLootTable.THIRY_SECONDS_AS_TICKS, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, CowLootTable.THIRY_SECONDS_AS_TICKS, 1), true);
        } else {
            meta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, CowLootTable.THIRY_SECONDS_AS_TICKS, 1), true);
            meta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, CowLootTable.THIRY_SECONDS_AS_TICKS, 1), true);
        }
        ItemMeta im = meta;
        im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        potion.setItemMeta(meta);
        return potion;
    }



    public static ItemStack getRandomItem() {
        if (items == null) {
            items = new ItemStack[] {
                    Util.makeEnchantedBook(Enchantment.DAMAGE_ALL, 10), // sh 5
                    Util.makeEnchantedBook(Enchantment.DIG_SPEED, 10), // eff 5
                    new ItemStack(Material.DIAMOND, 2), // 2 diamonds
                    new ItemStack(Material.ENDER_PEARL), // 1 pearl
                    new ItemStack(Material.NETHERITE_INGOT), // // 1 netherite ingot
                    new ItemStack(Material.EXPERIENCE_BOTTLE, 2), // 2 exp bottles
                    CowLootTable.makePotion(true), // make good potion
                    CowLootTable.makePotion(false) // make bad potion
            };
        }
        return items[r.nextInt(items.length)];
    }
}
