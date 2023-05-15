package edu.fpdual.persistence.manager.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import edu.fpdual.api.dao.Game;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameManagerImpl {

    public int insertGame(Connection con, Game game) {

        String sql = "INSERT INTO game(player1, player2, player3, dealer, timestamp, player1score, player2score, player3score, dealerScore, " +
                "player1bet, player2bet, player3bet) values (?, ?, ?, ?, SYSDATE(), ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, game.getPlayer1());
            stmt.setString(2, game.getPlayer2());
            stmt.setString(3, game.getPlayer3());
            stmt.setString(4, game.getDealer());
            stmt.setFloat(5, game.getPlayer1score());
            stmt.setFloat(6, game.getPlayer2score());
            stmt.setFloat(7, game.getPlayer3score());
            stmt.setFloat(8, game.getDealerScore());
            stmt.setFloat(9, game.getPlayer1bet());
            stmt.setFloat(10, game.getPlayer2bet());
            stmt.setFloat(11, game.getPlayer3bet());
            return stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Game> findByName(Connection con, String name) {
        String sql = "SELECT player1, player2, player3, dealer, timestamp, player1score, player2score, player3score, dealerScore, " +
                "player1bet, player2bet, player3bet FROM game WHERE " +
                "player1 LIKE ? OR " +
                "player2 LIKE ? OR " +
                "player3 LIKE ? OR " +
                "dealer LIKE ?";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + name + "%");
            stmt.setString(3, "%" + name + "%");
            stmt.setString(4, "%" + name + "%");
            ResultSet result = stmt.executeQuery();
            List<Game> games = new ArrayList<Game>();
            while (result.next()) {
                games.add(new Game(result));
            }
            return games;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
