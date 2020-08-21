package de.julian.listeners;

import de.julian.mysqlbzwextras.LevelAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class PrefixEvents implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        if (LevelAPI.getLevel(e.getPlayer()) >= 1 && LevelAPI.getLevel(e.getPlayer()) <= 20){
            e.setMessage(e.getFormat() + "§7 |§a " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) >=21 && LevelAPI.getLevel(e.getPlayer()) <= 35){
            e.setMessage(e.getFormat() + "§7 |§2 " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) >=36 && LevelAPI.getLevel(e.getPlayer()) <= 45){
            e.setMessage(e.getFormat() + "§7 |§b " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) >=46 && LevelAPI.getLevel(e.getPlayer()) <= 50){
            e.setMessage(e.getFormat() + "§7 |§9 " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) >=51 && LevelAPI.getLevel(e.getPlayer()) <= 60){
            e.setMessage(e.getFormat() + "§7 |§1 " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) >=61 && LevelAPI.getLevel(e.getPlayer()) <= 80){
            e.setMessage(e.getFormat() + "§7 |§c " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) >=81 && LevelAPI.getLevel(e.getPlayer()) <= 99){
            e.setMessage(e.getFormat() + "§7 |§4 " + LevelAPI.getLevel(e.getPlayer()));
        }else if (LevelAPI.getLevel(e.getPlayer()) ==100){
            e.setMessage(e.getFormat() + "§7 |§6 " + LevelAPI.getLevel(e.getPlayer()));
        }

    }

}
