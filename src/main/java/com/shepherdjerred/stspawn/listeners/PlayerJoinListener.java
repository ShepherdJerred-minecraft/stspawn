package com.shepherdjerred.stspawn.listeners;

import com.shepherdjerred.stspawn.config.SpawnConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoinListener implements Listener {

    private Plugin plugin;
    private SpawnConfig spawnConfig;

    public PlayerJoinListener(Plugin plugin, SpawnConfig spawnConfig) {
        this.plugin = plugin;
        this.spawnConfig = spawnConfig;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        if (event.getPlayer().hasPlayedBefore() && spawnConfig.isOnlyFirstJoin()) {
            return;
        }

        if (!event.getPlayer().hasPermission("stSpawn.exempt")) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    event.getPlayer().teleport(spawnConfig.getSpawnLocation());
                }
            }.runTaskLater(plugin, 10L);
        }

    }

}
