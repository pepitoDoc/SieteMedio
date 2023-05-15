package edu.fpdual.web.service.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.fpdual.web.client.GameClient;
import edu.fpdual.web.client.dto.Game;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name="FindGameByName", urlPatterns = "/findgameby-name")
public class FindGameByName extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestBody = req.getParameter("nombre");
        if (requestBody == null || requestBody.isEmpty()) {
            resp.setContentType("text/plain");
            resp.getWriter().write("0");
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        List<Game> dataRetrieved = new GameClient().findByName(requestBody);
        if (dataRetrieved != null) {
            resp.setContentType("application/json");
            resp.getWriter().write(mapper.writeValueAsString(dataRetrieved));
        } else {
            resp.setContentType("text/plain");
            resp.getWriter().write("0");
        }
    }
}
