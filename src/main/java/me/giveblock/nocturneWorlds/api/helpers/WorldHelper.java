package me.giveblock.nocturneWorlds.api.helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import me.giveblock.nocturneWorlds.utils.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;

public class WorldHelper {

    private static JsonObject worldsConfig = FileUtils.worldConfig;

    public static void loadWorlds() {
        JsonArray worldArray = worldsConfig.get("worlds").getAsJsonArray();
        for (JsonElement world : worldArray) {
            String worldName = world.getAsString();
            loadWorld(worldName);
        }



    }
    public static void loadWorld(String name) {
        WorldCreator wc = new WorldCreator(name);
        wc.createWorld();
    }

    public static Location firstSpawn() {
        World spawnWorld = Bukkit.getWorld(worldsConfig.get("spawn-world").getAsString());
        JsonObject spawnCoords = worldsConfig.get("spawn-coords").getAsJsonObject();
        double x = spawnCoords.get("x").getAsDouble();
        double y = spawnCoords.get("y").getAsDouble();
        double z = spawnCoords.get("z").getAsDouble();
        float yaw = spawnCoords.get("yaw").getAsFloat();
        Location loc = new Location(spawnWorld, x, y, z);
        loc.setYaw(yaw);


        return loc;
    }

}
