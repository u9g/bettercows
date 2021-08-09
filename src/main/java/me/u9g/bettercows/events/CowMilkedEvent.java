package me.u9g.bettercows.events;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public final class CowMilkedEvent extends Event {
    private static final HandlerList handlers = new HandlerList();
    private Player _player;
    private Entity _cow;

    public CowMilkedEvent(Player player, Entity cow) {
        this._player = player;
        this._cow = cow;
    }

    public Player getPlayer() {
        return _player;
    }

    public Entity getCow() {
        return _cow;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}