package me.giveblock.nocturneWorlds;

import me.giveblock.nocturneWorlds.api.helpers.WorldHelper;
import me.giveblock.nocturneWorlds.api.listeners.PlayerJoin;
import me.giveblock.nocturneWorlds.commands.NocturneWorld;
import me.giveblock.nocturneWorlds.utils.FileUtils;
import org.bukkit.plugin.java.JavaPlugin;

public final class NocturneWorlds extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        FileUtils.init();
        WorldHelper.loadWorlds();

        registerCommands();
        registerEvents();

        getLogger().info("NocturneWorlds has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        getLogger().info("NocturneWorlds has been disabled!");

    }

    private void registerCommands() {
        this.getCommand("nocturneworld").setExecutor(new NocturneWorld(this));
    }

    private void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    }


}
