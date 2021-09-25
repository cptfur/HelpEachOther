package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.information;
import service.impl.helperServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findHelper")
public class findHelper extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page=req.getParameter("page");
        helperServiceImpl helperService=new helperServiceImpl();
        List<information> information = helperService.information(page);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(information);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
