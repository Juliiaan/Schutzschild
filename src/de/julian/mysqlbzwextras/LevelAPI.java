package de.julian.mysqlbzwextras;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LevelAPI {

    public static void createTable() {
        try {
            PreparedStatement ps = MySQL.getStatement("CREATE TABLE IF NOT EXISTS LevelSystem (UUID VARCHAR(100), level INT(16), xp INT(16)," +
                    " joinmetokens INT(16), nicktokens INT(16), god INT(1), 10heart INT(1), 12heart INT(1), spiderman INT(1), fundf INT(1)," +
                    " noob INT(1), tryhard INT(1), terminator INT(1), tank INT(1)) ");
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void register(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("INSERT INTO LevelSystem (UUID, level, xp, joinmetokens, nicktokens, god, 10heart," +
                    " 12heart, spiderman, fundf, noob, tryhard, terminator, tank) VALUES (?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, p.getUniqueId().toString());
            ps.setInt(2, 1);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setInt(6, 1);
            ps.setInt(7, 0);
            ps.setInt(8, 0);
            ps.setInt(9, 0);
            ps.setInt(10, 0);
            ps.setInt(11, 0);
            ps.setInt(12, 0);
            ps.setInt(13, 0);
            ps.setInt(14, 0);

            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static boolean isRegistered(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            boolean user = rs.next();
            rs.close();
            rs.close();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static int getLevel(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int level = rs.getInt("level");
            rs.close();
            ps.close();
            return level;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static void setLevel(Player p, int level) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET level= ? WHERE UUID= ?");
            ps.setInt(1, level);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addLevel(Player p, int level) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET level= ? WHERE UUID= ?");
            ps.setInt(1, getLevel(p) + level);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getXP(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int level = rs.getInt("xp");
            rs.close();
            ps.close();
            return level;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static void addXP(Player p, int xp) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET xp= ? WHERE UUID= ?");
            ps.setInt(1, getXP(p) + xp);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setXP(Player p, int xp) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET xp= ? WHERE UUID= ?");
            ps.setInt(1, xp);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setGod(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET god= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static int getJoinME(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("joinmetokens");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int getNick(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("nicktokens");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static void addJoinmeTokens(Player p, int tokens) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET joinmetokens= ? WHERE UUID= ?");
            ps.setInt(1, getJoinME(p) + tokens);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void addNicktokens(Player p, int tokens) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET nicktokens= ? WHERE UUID= ?");
            ps.setInt(1, getNick(p) + tokens);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    public static int getnoob(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
          return -1;
    }

    public static int gettryhard(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int getTerminator(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int getTank(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static void setnoob(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET noob= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setTryhard(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET tryhard= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setTerminator(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET terminator= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setTank(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET tank= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static int get10heart(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int get12heart(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int getfundf(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static int getSpiderman(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            int tokens = rs.getInt("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    public static void set10heart(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET 10heart= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void set12heart(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET 12heart= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setSpiderman(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET spiderman= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setfundf(Player p, int god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET fundf= ? WHERE UUID= ?");
            ps.setInt(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

