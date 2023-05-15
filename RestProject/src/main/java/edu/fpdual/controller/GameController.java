package edu.fpdual.controller;

import edu.fpdual.persistence.connector.MySQLConnector;
import edu.fpdual.persistence.manager.impl.GameManagerImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import edu.fpdual.api.dao.Game;
import edu.fpdual.service.GameService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

@Path("/game")
public class GameController {

    private GameService service;

    @POST
    @Path("/registerGame")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerGame(Game game) throws SQLException, ClassNotFoundException {
        try {
            service = new GameService(new MySQLConnector(), new GameManagerImpl());
            service.insertGame(game);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.ok().status(Response.Status.CREATED).build();
    }

    @GET
    @Path("/findByName")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@QueryParam("nickname") String nickname) throws SQLException, ClassNotFoundException {
        List<Game> listado = new ArrayList<Game>();
        try {
            service = new GameService(new MySQLConnector(), new GameManagerImpl());
            listado = service.findByName(nickname);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Response.ok().entity(listado)
                .status(Response.Status.CREATED).build();
    }

    @OPTIONS
    @Path("{path : .*}")
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