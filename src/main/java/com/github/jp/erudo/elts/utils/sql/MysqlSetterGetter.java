package com.github.jp.erudo.elts.utils.sql;

import com.github.jp.erudo.elts.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlSetterGetter {

    private final Main plugin = Main.getInstance();

    public boolean teamExists(String team_name) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + plugin.getConfig().getTeams_table() + " WHERE team_name=?");
            statement.setString(1,team_name);

            ResultSet results = statement.executeQuery();

            if(results.next()) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return false;
    }

    public void createTeam(String team_name) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + plugin.getConfig().getTeams_table() + " WHERE team_name=?");
            statement.setString(1, team_name);
            ResultSet results = statement.executeQuery();
            results.next();

            if (!teamExists(team_name)) {
                PreparedStatement insert = db.getConnection()
                        .prepareStatement("INSERT INTO " + plugin.getConfig().getTeams_table() + " (team_name,kill,point) VALUE (?,?,?)");
                insert.setString(1,team_name);
                insert.setInt(2,0);
                insert.setInt(3,0);

                insert.executeUpdate();

            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void updateKill(String team_name, int kill) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("UPDATE " + plugin.getConfig().getTeams_table() + "SET 'kill'=? WHERE team_name=?");
            statement.setInt(1,kill);
            statement.setString(2,team_name);
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void updatePoint(String team_name, int point) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("UPDATE " + plugin.getConfig().getTeams_table() + "SET 'point'=? WHERE team_name=?");
            statement.setInt(1,point);
            statement.setString(2,team_name);
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public int getTeamID(String team_name) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + plugin.getConfig().getTeams_table() + " WHERE team_name=?");
            statement.setString(1,team_name);

            ResultSet results = statement.executeQuery();
            results.next();

            return results.getInt("id");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }

}
