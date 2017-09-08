package com.shepherdjerred.stspawn;

import com.shepherdjerred.riotbase.RiotBase;
import com.shepherdjerred.stspawn.config.SpawnConfig;
import com.shepherdjerred.stspawn.config.SpawnConfigImpl;
import com.shepherdjerred.stspawn.listeners.PlayerJoinListener;
import com.shepherdjerred.stspawn.messages.Parser;

import java.util.ResourceBundle;

public class Main extends RiotBase {

    private Parser parser;
    private SpawnConfig spawnConfig;

    @Override
    public void onEnable() {
        setupConfigs();

        System.out.println(spawnConfig.getSpawnLocation().toString());

        // TODO Load from plugin dir
        parser = new Parser(ResourceBundle.getBundle("messages"));

        registerListeners();

        startMetrics();
    }

    private void setupConfigs() {
        copyFile(getResource("config.yml"), getDataFolder().getAbsolutePath() + "/config.yml");
        copyFile(getResource("messages.properties"), getDataFolder().getAbsolutePath() + "/messages.properties");

        spawnConfig = new SpawnConfigImpl(getConfig());
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(this, spawnConfig), this);
    }

}
