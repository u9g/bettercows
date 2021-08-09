package me.u9g.bettercows.listeners;

import me.u9g.bettercows.CowLootTable;
import me.u9g.bettercows.Main;
import me.u9g.bettercows.Util;
import me.u9g.bettercows.events.CowMilkedEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class CowMilkedListener implements Listener {
    public CowMilkedListener (Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onCowMilked(CowMilkedEvent e) {
        Player p = e.getPlayer();
        String rewards = Util.makeChat("&fYou just received &a&lREWARDS&f!");
        p.sendMessage(rewards);
        Location pos = e.getCow().getLocation();
        pos.getWorld().dropItemNaturally(pos, CowLootTable.getRandomItem());
    }
}
