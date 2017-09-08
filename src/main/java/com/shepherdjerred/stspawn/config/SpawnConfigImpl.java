package com.shepherdjerred.stspawn.config;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;

public class SpawnConfigImpl implements SpawnConfig {

    private final FileConfiguration config;

    public SpawnConfigImpl(FileConfiguration config) {
        this.config = config;
    }

    public boolean isOnlyFirstJoin() {
        return config.getBoolean("onlyFirstJoin");
    }

    public Location getSpawnLocation() {

        Location configSpawnLocation = new Location(
                Bukkit.getWorld(config.getString("spawnLocation.world")),
                config.getDouble("spawnLocation.x"),
                config.getDouble("spawnLocation.y"),
                config.getDouble("spawnLocation.z"),
                (float) config.getDouble("spawnLocation.yaw"),
                (float) config.getDouble("spawnLocation.pitch")
        );

        return configSpawnLocation;

    }

}
