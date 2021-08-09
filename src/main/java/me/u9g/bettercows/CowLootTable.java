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
    private static Random r = new Random();

    public static ItemStack getRandomItem() {
        switch(r.nextInt(7)) {
            case 0: // sharp 10 book
                ItemStack shX = new ItemStack(Material.ENCHANTED_BOOK);
                shX.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
                return shX;
            case 1: // eff 10 book
                ItemStack eff5 = new ItemStack(Material.ENCHANTED_BOOK);
                eff5.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
                return eff5;
            case 2: // 2 diams
                ItemStack diamonds = new ItemStack(Material.DIAMOND);
                diamonds.setAmount(2);
                return diamonds;
            case 3: // 1 pearl
                ItemStack pearl = new ItemStack(Material.ENDER_PEARL);
                return pearl;
            case 4: // 1 netherite
                ItemStack netheriteIngot = new ItemStack(Material.NETHERITE_INGOT);
                return netheriteIngot;
            case 5: // exp bottle
                ItemStack expBottle = new ItemStack(Material.EXPERIENCE_BOTTLE);
                expBottle.setAmount(2);
                return expBottle;
            case 6: // good potion - https://www.spigotmc.org/threads/give-a-player-a-custom-potion.395740/#post-3552693
                ItemStack goodPotion = new ItemStack(Material.SPLASH_POTION);
                PotionMeta goodPotionMeta = (PotionMeta) goodPotion.getItemMeta();
                goodPotionMeta.setColor(Color.FUCHSIA);
                goodPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, Ticks.TICKS_PER_SECOND * 30, 1), true);
                goodPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, Ticks.TICKS_PER_SECOND * 30, 1), true);
                ItemMeta goodMeta = goodPotionMeta;
                goodMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                goodPotion.setItemMeta(goodMeta);
                return goodPotion;
            case 7: // bad potion - https://www.spigotmc.org/threads/give-a-player-a-custom-potion.395740/#post-3552693
                ItemStack badPotion = new ItemStack(Material.SPLASH_POTION);
                PotionMeta badPotionMeta = (PotionMeta) badPotion.getItemMeta();
                badPotionMeta.setColor(Color.FUCHSIA);
                badPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.WEAKNESS, Ticks.TICKS_PER_SECOND * 30, 1), true);
                badPotionMeta.addCustomEffect(new PotionEffect(PotionEffectType.SLOW, Ticks.TICKS_PER_SECOND * 30, 1), true);
                ItemMeta badMeta = badPotionMeta;
                badMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                badPotion.setItemMeta(badMeta);
                return badPotion;
        }
        return null;
    }
}
