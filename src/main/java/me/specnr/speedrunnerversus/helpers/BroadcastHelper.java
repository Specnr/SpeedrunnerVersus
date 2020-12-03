package me.specnr.speedrunnerversus.helpers;

import org.bukkit.Bukkit;

public class BroadcastHelper {
    public static String BroadcastPrefix = "[§4§oSrVs§r] ";

    public static void Broadcast(String msg) {
        Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage(BroadcastPrefix + msg));
    }
}
