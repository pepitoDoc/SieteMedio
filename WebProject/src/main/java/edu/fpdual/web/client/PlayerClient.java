package edu.fpdual.web.client;

import edu.fpdual.web.client.dto.Player;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;

import javax.print.attribute.standard.Media;

public class PlayerClient {

    private final WebTarget webTarget;

    public PlayerClient() {
        Client client = ClientBuilder.newClient();
        this.webTarget = client.target("http://localhost:8081/RestProject/api/");
    }

    public Player insertUser(Player player) {

        return webTarget.path("player/insertPlayer")
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(player, MediaType.APPLICATION_JSON), Player.class);
    }

    public Player findByName(String nickname) {
        return webTarget.path("player/findByName")
                .queryParam("nickname", nickname)
                .request(MediaType.APPLICATION_JSON)
                .get(Player.class);
    }
}