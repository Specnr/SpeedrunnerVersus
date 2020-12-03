package me.specnr.speedrunnerversus.helpers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.CompassMeta;

public class LocationHelper {
    /**
     * Updates the Player's compass to track the given Location
     * reference: https://github.com/yummypasta/MinecraftManhunt/blob/master/MinecraftManhunt/src/main/java/com/yoonicode/minecraftmanhunt/PluginCommands.java
     * @param p The player to update compass
     * @param l The location to update to
     */
    public static void updateCompassWithDim (Player p, Location l) {
        switch (p.getWorld().getEnvironment()) {
            case NORMAL:
                p.setCompassTarget(l);
            default:
                PlayerInventory inv = p.getInventory();
                ItemStack compass = null;
                for (int j = 0; j < inv.getSize(); j++) {
                    ItemStack stack = inv.getItem(j);
                    if (stack != null && stack.getType() == Material.COMPASS) {
                        compass = stack;
                        break;
                    }
                }
                CompassMeta meta = (CompassMeta) compass.getItemMeta();
                meta.setLodestone(l);
                meta.setLodestoneTracked(false);
                compass.setItemMeta(meta);
        }
    }

    public static void updateCompass (Player p) {
        Location newLocation;
        Player otherHunter = Bukkit.getPlayer(HunterHelper.getOtherPlayer(p));
        if (otherHunter.getWorld().getEnvironment() == p.getWorld().getEnvironment()) {
            newLocation = otherHunter.getLocation();
        } else {
            newLocation = HunterHelper.LatestPortals.get(otherHunter.getUniqueId());
        }
        if (newLocation == null) {
            p.sendMessage(BroadcastHelper.BroadcastPrefix + " Portal location was lost");
        } else {
            updateCompassWithDim(p, newLocation);
        }
    }
}
