package de.julian.listeners;

import de.julian.mysqlbzwextras.LevelAPI;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class AchievmentListener implements Listener {

    public HashMap<Player, Player> inFight = new HashMap<>();
    public HashMap<Player, Integer> cobwebcounter = new HashMap<>();
    public HashMap<Player, Integer> wincount = new HashMap<>();
    public HashMap<Player, Integer> losecount = new HashMap<>();
    public HashMap<Player, Double> damageInFight = new HashMap<>();

    @EventHandler(priority = EventPriority.MONITOR)
    public void onEntityDeath(PlayerDeathEvent e) {
        try {
            Player ent = e.getEntity();
            Player k = inFight.get(ent);
            int heart12 = LevelAPI.get12heart(k);
            int heart10 = LevelAPI.get10heart(k);
            int fundf = LevelAPI.getfundf(k);

            if (damageInFight.get(ent) >= 10.0){
                if (LevelAPI.getTank(ent) == 0) {
                    LevelAPI.setTank(ent, 1);
                    ent.sendMessage("§aDu hast erfolgreich das Achievement §6Tank §aerreicht! (Nimm in einem Match 10 Herzen schaden ohne zu sterben)");
                    LevelAPI.addXP(ent, 20);
                    ent.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");
                }
            }else{
             damageInFight.put(ent, 0.0);
            }

            damageInFight.put(ent, 0.0);

            EntityDamageEvent ede = ent.getLastDamageCause();
            EntityDamageEvent.DamageCause dc = ede.getCause();

            if (ent instanceof Player && dc == EntityDamageEvent.DamageCause.FIRE || dc == EntityDamageEvent.DamageCause.FIRE_TICK && fundf == 0) {
                LevelAPI.addXP(k, 20);
                k.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");
                k.sendMessage("§aDu hast das Achievement §6Feuer und Flamme §aerreicht! (Besiege einen Spieler indem er verbrennt)");
                inFight.remove(ent);
                LevelAPI.setfundf(ent, 1);

            } else if (ent instanceof Player && ent.getHealth() == 24 && heart12 == 0) {
                LevelAPI.addXP(k, 25);
                k.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");
                k.sendMessage("§aDu hast das Achievement §412 Heart §aerreicht! (Besiege einen Spieler indem er verbrennt)");
                inFight.remove(ent);
                LevelAPI.set12heart(ent, 1);

            } else if (ent instanceof Player && ent.getHealth() == 20 && heart10 == 0) {
                LevelAPI.addXP(k, 25);
                k.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");
                k.sendMessage("§aDu hast das Achievement §410 Heart §aerreicht! (Besiege einen Spieler indem er verbrennt)");
                inFight.remove(ent);
                LevelAPI.set10heart(ent, 1);

            }
          if (LevelAPI.getnoob(ent) == 0) {
              if (ent instanceof Player && !losecount.containsKey(ent)) {
                  losecount.put(ent, 1);
              } else if (losecount.get(ent) != 10) {
                  int lc = losecount.get(ent);
                  lc++;
              } else if (losecount.get(ent) == 10) {
                  LevelAPI.setnoob(ent, 1);
                  ent.sendMessage("§aDu hast erfolgreich das Achievement §6Noob erreicht§a! (Verliere 10 mal hintereinander)");
                  LevelAPI.addXP(ent, 10);
                  ent.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");

              }else if (losecount.containsKey(k)){
                  losecount.remove(k);
              }else{
                  losecount.put(ent, 0);
              }
          }
          if (LevelAPI.gettryhard(k) == 0 && LevelAPI.getTerminator(k) == 0) {
              if (k instanceof Player && !wincount.containsKey(k)) {
                  wincount.put(k, 1);
              } else if (k instanceof Player && wincount.get(k) != 10) {
                  int wc = wincount.get(k);
                  wc++;
              } else if (k instanceof Player && wincount.get(k) == 10) {
                  LevelAPI.setTryhard(k, 1);
                  ent.sendMessage("§aDu hast erfolgreich das Achievement §6Tryhard erreicht§a! (Gewinne 10 mal hintereinander)");
                  LevelAPI.addXP(ent, 20);
                  ent.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");

              } else if (k instanceof Player && wincount.get(k) == 20) {
                  LevelAPI.setTerminator(k, 1);
                  ent.sendMessage("§aDu hast erfolgreich das Achievement §6Terminator erreicht§a! (Gewinne 20 mal hintereinander)");
                  LevelAPI.addXP(ent, 25);
                  ent.sendMessage("§aFalls du ein Level aufsteigen solltest und nicht aufgestiegen bist, warte ein paar Minuten");
              }
          }

        }catch (Exception e1){
            e1.printStackTrace();
        }
    }



    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {

            Player ldd = (Player) e.getEntity();
            Entity dc = ldd.getLastDamageCause().getEntity();
            inFight.put((Player) e.getEntity(), (Player) dc);
            double damage = e.getDamage();

            if (!damageInFight.containsKey(e.getEntity())) {
                damageInFight.put((Player) e.getEntity(), damage);
            } else {
                double playerdamage = damageInFight.get(e.getEntity());
                playerdamage++;
            }

        }
    }
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        int i = cobwebcounter.get(e.getPlayer());
        if (LevelAPI.getSpiderman(e.getPlayer()) == 0) {
            if (e.getBlockPlaced().getType() == Material.WEB) {
                if (!cobwebcounter.containsKey(e.getPlayer())) {
                    cobwebcounter.put(e.getPlayer(), 1);
                } else {
                    i++;

                }

            }
            if (i == 10) {
                LevelAPI.setSpiderman(e.getPlayer(), 1);
                e.getPlayer().sendMessage("§aDu hast das Achievement §6Spiderman §aerreicht! (Platziere 10 Spinnenweben)");
                LevelAPI.setSpiderman(e.getPlayer(), 1);
            }

        }
    }

}