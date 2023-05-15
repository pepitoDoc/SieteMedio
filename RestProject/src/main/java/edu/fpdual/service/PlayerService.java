package edu.fpdual.service;

import edu.fpdual.api.dao.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class PlayerService {

    private MySQLConnector connector;
    private PlayerManagerImpl manager;

    public PlayerService(MySQLConnector connector, PlayerManagerImpl manager) {
        this.connector = connector;
        this.manager = manager;
    }

    public int insertUser(Player player) throws SQLException, ClassNotFoundException{

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.insertUser(con, player);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

    public Player findByName(String nickname) throws SQLException, ClassNotFoundException {

        Connection con = null;

        try {
            con = connector.getMySQLConnection();
            return manager.findByName(con, nickname);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }

}
