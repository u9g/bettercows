package me.u9g.bettercows;

import net.md_5.bungee.api.ChatColor;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Util {
    /**
     * Get a diff between two dates
     * @param date1 the oldest date
     * @param date2 the newest date
     * @param timeUnit the unit in which you want the diff
     * @return the diff value, in the provided unit
     */
    public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
        long diffInMillies = date2.getTime() - date1.getTime();
        return timeUnit.convert(diffInMillies,TimeUnit.MILLISECONDS);
    }

    public static String makeChat(String x) {
        return ChatColor.translateAlternateColorCodes('&', x);
    }
}
