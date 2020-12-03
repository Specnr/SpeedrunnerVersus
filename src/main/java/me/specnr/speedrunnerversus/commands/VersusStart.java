package me.specnr.speedrunnerversus.commands;

import me.specnr.speedrunnerversus.helpers.BroadcastHelper;
import me.specnr.speedrunnerversus.helpers.HunterHelper;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class VersusStart implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Add given player names to runners
        int numPlayers = Bukkit.getOnlinePlayers().size();
        if (numPlayers != 2) {
            sender.sendMessage(BroadcastHelper.BroadcastPrefix + " Can only play with 2 players.");
            return false;
        }
        ArrayList<UUID> uuids = new ArrayList<>();
        for (Player p: Bukkit.getOnlinePlayers()) {
            uuids.add(p.getUniqueId());
        }
        HunterHelper.Runners.put(uuids.get(0), uuids.get(1));
        HunterHelper.Runners.put(uuids.get(1), uuids.get(0));
        BroadcastHelper.Broadcast("Speedrunner Versus Started!");
        HunterHelper.giveAllCompass();
        return true;
    }
}