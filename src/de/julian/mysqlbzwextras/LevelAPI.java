package de.julian.mysqlbzwextras;

import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LevelAPI {

    public static void createTable() {
        try {
            PreparedStatement ps = MySQL.getStatement("CREATE TABLE IF NOT EXISTS LevelSystem (UUID VARCHAR(100), level INT(16), xp INT(16)," +
                    " joinmetokens INT(16), nicktokens INT(16), god BOOL, 10heart BOOL, 12heart BOOL, fundf BOOL, spiderman BOOL, noob BOOL, tryhard BOOL," +
                    " terminator BOOL, tank BOOL ");
            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void register(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("INSERT INTO LevelSystem (UUID, level, xp, joinmetokens, nicktokens, god) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?)");
            ps.setString(1, p.getUniqueId().toString());
            ps.setInt(2, 1);
            ps.setInt(3, 0);
            ps.setInt(4, 0);
            ps.setInt(5, 0);
            ps.setBoolean(6, false);
            ps.setBoolean(7, false);
            ps.setBoolean(8, false);
            ps.setBoolean(9, false);
            ps.setBoolean(10, false);
            ps.setBoolean(11, false);
            ps.setBoolean(12, false);
            ps.setBoolean(13, false);
            ps.setBoolean(14, false);
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

    public static void setGod(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET god= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
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

    public static boolean getnoob(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("noob");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean gettryhard(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("tryhard");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean getTerminator(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("terminator");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean getTank(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("tank");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void setnoob(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET noob= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setTryhard(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET tryhard= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setTerminator(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET terminator= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setTank(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET tank= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static boolean get10heart(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("10heart");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean get12heart(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("12heart");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean getfundf(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("fundf");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static boolean getSpiderman(Player p) {
        try {
            PreparedStatement ps = MySQL.getStatement("SELECT * FROM LevelSystem WHERE UUID= ?");
            ps.setString(1, p.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean tokens = rs.getBoolean("spiderman");
            rs.close();
            ps.close();
            return tokens;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static void set10heart(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET 10heart= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void set12heart(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET 12heart= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setSpiderman(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET spiderman= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void setfundf(Player p, boolean god) {
        try {
            PreparedStatement ps = MySQL.getStatement("UPDATE LevelSystem SET fundf= ? WHERE UUID= ?");
            ps.setBoolean(1, god);
            ps.setString(2, p.getUniqueId().toString());
            ps.executeUpdate();
            ps.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

