package edu.fpdual.persistence.manager.impl;

import edu.fpdual.api.dao.Player;

import java.sql.*;

public class PlayerManagerImpl {

    public int insertUser(Connection con, Player player) {
        String sql = "INSERT INTO player(nickname, password) VALUES(?, ?)";
        try(PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, player.getNickname());
            stmt.setString(2, player.getPassword());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Player findByName(Connection con, String nickname) {

        String sql = "SELECT * FROM player WHERE nickname = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nickname);
            ResultSet result = stmt.executeQuery();
            Player playerFound = null;
            while(result.next()) {
                playerFound = new Player(result);
            }
            return playerFound;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

}
