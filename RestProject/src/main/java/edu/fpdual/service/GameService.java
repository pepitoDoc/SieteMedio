package edu.fpdual.service;

import edu.fpdual.api.dao.Game;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GameService {

    private MySQLConnector connector;
    private GameManagerImpl manager;
    public GameService(MySQLConnector connector, GameManagerImpl manager) {
        this.connector = connector;
        this.manager = manager;
    }

    public int insertGame(Game game) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insertGame(con, game);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

    public List<Game> findByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;
        try {
            con = connector.getMySQLConnection();
            return manager.findByName(con, nickname);
        } finally {
            if (con!=null) {
                con.close();
            }
        }
    }

}
