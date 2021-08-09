package me.u9g.bettercows.listeners;

import me.u9g.bettercows.Main;
import me.u9g.bettercows.Util;
import me.u9g.bettercows.events.CowMilkedEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class PlayerInteractAtEntityListener implements Listener {

    private static HashMap<UUID, Date> cowLastMilked;
    private Main plugin;

    public PlayerInteractAtEntityListener(Main _plugin) {
        plugin = _plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        cowLastMilked = new HashMap<>();
    }

    @EventHandler
    public void onCowMilked(PlayerInteractAtEntityEvent e) {
        Entity entity = e.getRightClicked();
        Player player = e.getPlayer();
        if (
            (player.getInventory().getItemInMainHand().getType().equals(Material.BUCKET) || player.getInventory().getItemInOffHand().getType().equals(Material.BUCKET)) &&
            entity.getType().equals(EntityType.COW)
        ) {
            if (!cowLastMilked.containsKey(entity.getUniqueId())) {
                cowLastMilked.put(entity.getUniqueId(), new Date());
                CowMilkedEvent event = new CowMilkedEvent(player, entity);
                plugin.getServer().getPluginManager().callEvent(event);
            } else {
                long timeSinceLastMilked = Util.getDateDiff(cowLastMilked.get(entity.getUniqueId()), new Date(), TimeUnit.SECONDS);
                if (timeSinceLastMilked > 60) {
                    CowMilkedEvent event = new CowMilkedEvent(player, entity);
                    plugin.getServer().getPluginManager().callEvent(event);
                } else {
                    long timeUntilNextMilk = 60 - timeSinceLastMilked;
                    player.sendMessage(Util.makeChat("&eYou milked a cow recently, wait " + timeUntilNextMilk + " seconds to try again."));
                }
            }
        }
    }
}
