package me.giveblock.nocturneWorlds.utils;

import com.google.gson.JsonObject;
import me.giveblock.nocturneWorlds.NocturneWorlds;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class FileUtils {

    private static final Plugin pl = NocturneWorlds.getPlugin(NocturneWorlds.class);

    public static JsonObject worldConfig;
    private static final File worldFile = new File(pl.getDataFolder(), "worlds.json");

    public static void init() {
        //worlds config
        if (!worldFile.exists()) {
            pl.saveResource("worlds.json", false);
        }
        worldConfig = Json.load(worldFile);
    }

    public static void deleteFile(File element) {
        if (element.isDirectory()) {
            for (File sub : element.listFiles()) {
                deleteFile(sub);
            }
        }
        element.delete();
    }

}
