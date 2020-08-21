package de.julian.levelsystem;

import de.julian.commands.LevelCommand;
import de.julian.listeners.AFKHandler;
import de.julian.listeners.AchievmentListener;
import de.julian.listeners.Events;
import de.julian.listeners.PrefixEvents;
import de.julian.mysqlbzwextras.LevelAPI;
import de.julian.mysqlbzwextras.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LevelSystem extends JavaPlugin {

    public static LevelSystem levelSystem;

    @Override
    public void onEnable() {
        MySQL.connect();
        LevelAPI.createTable();
        register(Bukkit.getPluginManager());
        levelSystem = this;


    }

    @Override
    public void onDisable() {
        MySQL.disconnect();
    }

    public static LevelSystem getLevelSystem() {
        return levelSystem;
    }

    public void register(PluginManager pluginManager){
        pluginManager.registerEvents(new AFKHandler(), this);
        pluginManager.registerEvents(new Events(), this);
        pluginManager.registerEvents(new PrefixEvents(), this);
        pluginManager.registerEvents(new AchievmentListener(), this);
        getCommand("level").setExecutor(new LevelCommand());


    }

}
