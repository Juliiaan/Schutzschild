package de.julian.commands;

import de.julian.mysqlbzwextras.LevelAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LevelCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0){
            if (sender instanceof Player) {
                Player p = (Player)sender;
                sender.sendMessage("§aDu befindest dich im Level: " + LevelAPI.getLevel(p));
            }else{
                sender.sendMessage("§cDu bist kein Spieler! Gib /level <Player> ein um das Level von einem anderem Spieler zu sehen!");
            }
        }else if (args.length == 1){
            Player t = Bukkit.getPlayer(args[0]);
            if (t != null){
                sender.sendMessage("§aDas Level des Spielers " + t.getDisplayName() + " ist: "+LevelAPI.getLevel(t) + "!");

            }else{
                sender.sendMessage("§cDieser Spieler existiert nicht!");
            }


        }else{
            sender.sendMessage("§cGib /level oder /level <Player> ein, um das Level von dir bzw. eines anderen Spielers zu sehen!");
        }

        return false;
    }
}
