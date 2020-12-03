package me.specnr.speedrunnerversus.events;

import me.specnr.speedrunnerversus.helpers.HunterHelper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPortalEvent;

public class PortalEvents implements Listener {
    @EventHandler
    /**
     * Sets the latest portal location when a runner changes dimensions
     */
    public void onPlayerEnterPortal(PlayerPortalEvent evt){
        HunterHelper.LatestPortals.put(evt.getPlayer().getUniqueId(), evt.getFrom());
    }
}