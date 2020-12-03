package me.specnr.speedrunnerversus.helpers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class HunterHelper {
    public static Map<UUID, UUID> Runners = new HashMap<>();
    public static Map<UUID, Location> LatestPortals = new HashMap<>();

    public static void giveCompass(Player p) {
        p.getInventory().addItem(new ItemStack(Material.COMPASS, 1));
    }
    public static void giveAllCompass() {
        for (Player p: Bukkit.getOnlinePlayers()) {
            giveCompass(p);
        }
    }
    public static UUID getOtherPlayer(Player p) { return Runners.get(p.getUniqueId()); }
}
