package me.u9g.bettercows;

import me.u9g.bettercows.events.CowMilkedEvent;
import me.u9g.bettercows.listeners.CowMilkedListener;
import me.u9g.bettercows.listeners.PlayerInteractAtEntityListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("BetterCows Loaded!");
        new PlayerInteractAtEntityListener(this);
        new CowMilkedListener(this);
    }

    @Override
    public void onDisable() {
        System.out.println("BetterCows Unloaded!");
        // Plugin shutdown logic
    }
}
