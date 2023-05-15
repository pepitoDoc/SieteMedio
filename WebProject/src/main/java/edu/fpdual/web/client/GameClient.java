package edu.fpdual.web.client;

import edu.fpdual.web.client.dto.Game;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

public class GameClient {

    private final WebTarget webTarget;

    public GameClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8081/RestProject/api/");
    }

    public Game registerGame(Game game) {

        return webTarget.path("game/registerGame")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(game, MediaType.APPLICATION_JSON), Game.class);

    }

    public List<Game> findByName(String nickname) {
        return webTarget.path("game/findByName")
                .queryParam("nickname", nickname)
                .request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Game>>(){});
    }

}
