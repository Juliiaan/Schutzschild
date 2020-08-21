package de.julian.mysqlbzwextras;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MySQL {

    public static String host = "localhost";
    public static String port = "3306";
    public static String database = "LevelSystem";
    public static String username = "root";
    public static String password = ""; //hab keins ;)

    public static Connection con;

    public static boolean isConnected(){
        return con != null;
    }

    public static void connect(){
        if(!isConnected()){
            try {
                con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database + "?autoReconnect=true", username, password);
                Bukkit.getConsoleSender().sendMessage("§aEs konnte erfolgreich mit der Datenbank verbunden werden");
            } catch (SQLException e) {
                Bukkit.getConsoleSender().sendMessage("§cEs konnte nicht mit der Datenbank verbunden werden");
            }
        }
    }

    public static void disconnect(){
        try {
            con.close();
            Bukkit.getConsoleSender().sendMessage("§aDie Verbindung zur Datenbank konnte erfolgreich geschlossen werden");
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("§cDie Verbindung zur Datenbank konnte nicht geschlossen werden");
        }
    }

    public static PreparedStatement getStatement(String sql){
        if(isConnected()){
            PreparedStatement ps;
            try {
                ps = con.prepareStatement(sql);
                return ps;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static ResultSet getResult(String sql){
        if(isConnected()){
            PreparedStatement ps;
            ResultSet rs;
            try {
                ps = getStatement(sql);
                rs = ps.executeQuery();
                return rs;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
