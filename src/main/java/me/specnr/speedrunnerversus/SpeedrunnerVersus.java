package me.specnr.speedrunnerversus;

import me.specnr.speedrunnerversus.commands.VersusStart;
import me.specnr.speedrunnerversus.events.CompassEvents;
import me.specnr.speedrunnerversus.events.PortalEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpeedrunnerVersus extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CompassEvents(), this);
        getServer().getPluginManager().registerEvents(new PortalEvents(), this);
        getCommand("versus").setExecutor(new VersusStart());
        System.out.println("Minecraft Speedrunner Versus Loaded");
    }
}
