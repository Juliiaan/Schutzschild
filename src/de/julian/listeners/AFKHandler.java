package de.julian.listeners;

import de.julian.levelsystem.LevelSystem;
import de.julian.mysqlbzwextras.LevelAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;

public class AFKHandler implements Listener {

    File file = new File("plugins//LevelSystem//config.yml");
    YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);




        BukkitTask task;

        @EventHandler
        public void onJoin(PlayerJoinEvent e) {
            cfg.set(e.getPlayer().getDisplayName(), 0);
            task = new BukkitRunnable() {

                @Override
                public void run() {

                    if (cfg.getInt(e.getPlayer().getDisplayName()) >= 6000) {
                        e.getPlayer().kickPlayer("§cDu warst zu lange AFK!");
                        cancel();
                    } else {
                        cfg.set(e.getPlayer().getDisplayName(), cfg.getInt(e.getPlayer().getDisplayName()) + 1);
                    }
                }
            }.runTaskTimer(LevelSystem.getLevelSystem(), 0, 20);

        }



        @EventHandler
        public void onMove(PlayerMoveEvent e){

            if (cfg.getInt(e.getPlayer().getDisplayName()) != 0){
                cfg.set(e.getPlayer().getDisplayName(), 0);
        }
        }




    }


