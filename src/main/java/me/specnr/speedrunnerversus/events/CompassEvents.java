package me.specnr.speedrunnerversus.events;

import me.specnr.speedrunnerversus.helpers.HunterHelper;
import me.specnr.speedrunnerversus.helpers.LocationHelper;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class CompassEvents implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent evt){
        Player player = evt.getPlayer();
        if(player.getEquipment() != null && player.getEquipment().getItemInMainHand().getType() == Material.COMPASS) {
            LocationHelper.updateCompass(player);
        }
    }

    @EventHandler
    /**
     * Gives a Compass to respawned Hunters
     */
    public void onPlayerRespawn(PlayerRespawnEvent evt){
        HunterHelper.giveCompass(evt.getPlayer());
    }
}