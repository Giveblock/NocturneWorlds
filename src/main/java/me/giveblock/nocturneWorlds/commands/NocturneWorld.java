package me.giveblock.nocturneWorlds.commands;

import me.giveblock.nocturneWorlds.NocturneWorlds;
import me.giveblock.nocturneWorlds.api.helpers.WorldHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NocturneWorld implements CommandExecutor {

    public NocturneWorld(NocturneWorlds plugin) {}

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            p.teleport(WorldHelper.firstSpawn());

            return true;
        }

        return false;
    }

}
