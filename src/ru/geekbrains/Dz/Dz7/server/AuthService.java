package ru.geekbrains.Dz.Dz7.server;

import java.sql.*;
import java.util.Timer;
import java.util.TimerTask;

public class AuthService {
    private static Connection connection;

    public static Statement getStmt() {
        return stmt;
    }

    private static Statement stmt;

    public static void connect() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");

            connection = DriverManager.getConnection("jdbc:sqlite:UserDB.db");
            stmt = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void addUser(String login, String pass, String nick) {

        try {
            String query = "INSERT INTO main (login, password, nickname) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, login);
            ps.setInt(2, pass.hashCode());
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String getNickByLoginAndPass(String login, String pass) {
        String sql = String.format("SELECT nickname, password FROM main\n" +
                "WHERE login = '%s'\n", login);
        int myHash = pass.hashCode();
        try {
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                String nick = rs.getString(1);
                int dbHash = rs.getInt(2);
                if (myHash == dbHash) {
                    return nick;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void saveHistory(String login, String msg) {
        String sql = String.format("INSERT INTO history (post, nick) " +
                "VALUES ('%s', '%s')", msg, login);
        try {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getHistoryChat() {
        StringBuilder sb = new StringBuilder();
        String sql = String.format("SELECT nick, post FROM history ORDER BY id");
        try {
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                sb.append(rs.getString("nick") + " " + rs.getString("post") + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sb;
    }

    public static void addIntoBlacklist(String nick){

        try {
            String query = "UPDATE main SET blacklist=1 WHERE nickname=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                try {
                    String query = "UPDATE main SET blacklist=0 WHERE nickname=?";
                    PreparedStatement ps = connection.prepareStatement(query);
                    ps.setString(1, nick);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                timer.cancel();
            }
        }, 10000 );

    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
