package me.giveblock.nocturneWorlds.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Json {

    public static JsonObject load(File file) {
        try {
            String data = new String(Files.readAllBytes(Paths.get(file.toURI())));
            return JsonParser.parseString(data).getAsJsonObject();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
