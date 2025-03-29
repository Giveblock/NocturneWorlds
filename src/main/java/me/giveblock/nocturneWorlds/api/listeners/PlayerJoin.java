package me.giveblock.nocturneWorlds.api.listeners;

import me.giveblock.nocturneWorlds.api.helpers.WorldHelper;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (!p.hasPlayedBefore()) {
            p.teleport(WorldHelper.firstSpawn());
        }
    }


}
