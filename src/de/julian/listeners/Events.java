package de.julian.listeners;

import de.julian.levelsystem.LevelSystem;
import de.julian.mysqlbzwextras.LevelAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class Events implements Listener {

    BukkitTask task;


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
    if (!LevelAPI.isRegistered(e.getPlayer())){
        LevelAPI.register(e.getPlayer());
    }


        if (!e.getPlayer().hasPlayedBefore()){
            LevelAPI.setLevel(e.getPlayer(), 1);
            LevelAPI.setXP(e.getPlayer(), 0);
            e.getPlayer().sendMessage("§aWillkommen auf dem Server! Dein Level beträgt " + LevelAPI.getLevel(e.getPlayer()));

        }else {
            e.getPlayer().sendMessage("§aWillkommen zurück! Dein Level beträgt " + LevelAPI.getLevel(e.getPlayer()));


        }

        task = new BukkitRunnable() {

            @Override
            public void run() {

                int currentlevel = LevelAPI.getLevel(e.getPlayer());
                int currentxp = LevelAPI.getXP(e.getPlayer());

                if (LevelAPI.getLevel(e.getPlayer()) != 100) {
                    LevelAPI.addXP(e.getPlayer(), 5);
                    e.getPlayer().sendMessage("§aDu hast 5 Levelpunkte erhalten, da du (weitere) 15 Minuten Online warst");
                    if (currentlevel >= 1 && currentlevel <= 15 && currentxp == 10 ||currentxp >= 10) {
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 10);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    } else if (currentlevel >= 1 && currentlevel <= 15 && currentxp == 10 ||currentxp >= 10) {
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 10);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    } else if (currentlevel >= 16 && currentlevel <= 25 && currentxp == 20 ||currentxp >= 20) {
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 20);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    }else if (currentlevel >=26 && currentlevel <= 35 && currentxp == 25 ||currentxp >= 25){
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 25);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    }else if (currentlevel >=36 && currentlevel <= 45 && currentxp == 30 ||currentxp >= 30){
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 30);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    }else if (currentlevel >=46 && currentlevel <= 60 && currentxp == 40 ||currentxp >= 40){
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 40);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    }else if (currentlevel >=61 && currentlevel <= 80 && currentxp == 65 ||currentxp >= 65){
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 65);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    }else if (currentlevel >=81 && currentlevel < 99 && currentxp == 80 ||currentxp >= 80){
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), LevelAPI.getXP(e.getPlayer()) - 80);
                        e.getPlayer().sendMessage("§aDu bist ein Level aufgestiegen!");

                    }else if (currentlevel == 99 && currentxp == 100 ||currentxp >= 100){
                        LevelAPI.addLevel(e.getPlayer(), 1);
                        LevelAPI.setGod(e.getPlayer(), 1);
                        LevelAPI.setXP(e.getPlayer(), 0);
                        for (Player all: Bukkit.getOnlinePlayers()) {
                            Bukkit.getWorld(e.getPlayer().getWorld().getName()).playSound(all.getLocation(), Sound.ENDERDRAGON_DEATH, 1, 1);
                        }
                        Bukkit.broadcastMessage("§6Der Spieler §6§l" + e.getPlayer().getDisplayName() + " §6hat Level 100 erreicht!");
                        Bukkit.broadcastMessage("§6Herzlichen Glückwunsch, du hast für §6§l1 Monat den GOD-Rang §6gewonnen");
                    }

                }

                if (currentlevel == 10){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 2);
                }else if (currentlevel == 20){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 2);
                }else if (currentlevel == 35){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 2);
                    LevelAPI.addNicktokens(e.getPlayer(), 1);
                }else if (currentlevel == 50){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 2);
                    LevelAPI.addNicktokens(e.getPlayer(), 2);
                }else if (currentlevel == 60){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 2);
                    LevelAPI.addNicktokens(e.getPlayer(), 2);
                }else if (currentlevel == 80){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 2);
                    LevelAPI.addNicktokens(e.getPlayer(), 2);
                }else if (currentlevel == 99){
                    LevelAPI.addJoinmeTokens(e.getPlayer(), 3);
                    LevelAPI.addNicktokens(e.getPlayer(), 3);
                }

            }
        }.runTaskTimer(LevelSystem.getLevelSystem(), 0, 18000);


    }


    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){
    if (e.getBlock().getType() == Material.SAND){
     LevelAPI.addXP(e.getPlayer(), 5);
     e.getPlayer().sendMessage("§a+5");
    }else{
        
    }

    }

}
