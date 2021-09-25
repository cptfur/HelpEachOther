package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.news;
import service.impl.newsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/newsServlet")
public class newsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        newsServiceImpl service=new newsServiceImpl();
        List<news> newsList = service.findAll();
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(newsList);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
