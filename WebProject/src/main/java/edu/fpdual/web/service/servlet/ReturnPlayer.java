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

@WebServlet(name="ReturnPlayer", urlPatterns = "/return-player")
public class ReturnPlayer extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Player player = mapper.readValue(req.getReader(), Player.class);
        resp.setContentType("application/json");
        Player playerFound = new PlayerClient().findByName(player.getNickname());
        if ((player.getNickname().equals(playerFound.getNickname()))) {
            resp.getWriter().write(playerFound.toString());
        }
    }
}
