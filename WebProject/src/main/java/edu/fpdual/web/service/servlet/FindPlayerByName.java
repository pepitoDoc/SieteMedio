package edu.fpdual.web.service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fpdual.web.client.PlayerClient;
import edu.fpdual.web.client.dto.Player;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="FindUserByName", urlPatterns = "/findplayerby-name")
public class FindPlayerByName extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ObjectMapper mapper = new ObjectMapper();
        Player player = mapper.readValue(req.getReader(), Player.class);

        String result = "0";

        Player playerFound = new PlayerClient().findByName(player.getNickname());
        if ((player.getNickname().equals(playerFound.getNickname()))) {
            result = "1";
        }
        resp.setContentType("text/plain");
        resp.getWriter().write(result);
    }
}
