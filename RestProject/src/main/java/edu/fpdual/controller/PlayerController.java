package edu.fpdual.controller;

import edu.fpdual.api.dao.Player;
import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.PlayerManagerImpl;
import edu.fpdual.service.PlayerService;
import jakarta.ws.rs.*;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;

@Path("/player")
public class PlayerController {

    private PlayerService service;

    @POST
    @Path("/insertPlayer")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUser(Player player) throws SQLException, ClassNotFoundException{

        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        try {
            service.insertUser(player);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/findByName")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@QueryParam("nickname") String nickname) throws SQLException, ClassNotFoundException {
        service = new PlayerService(new MySQLConnector(), new PlayerManagerImpl());
        Player playerFound = new Player();
        try {
            playerFound = service.findByName(nickname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.ok().entity(playerFound).status(Response.Status.CREATED).build();
    }

    @OPTIONS
    public Response registerGameOptions() {
        return Response.ok("")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                .header("Access-Control-Allow-Credentials", "true")
                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                .header("Access-Control-Max-Age", "1209600")
                .build();
    }
}
