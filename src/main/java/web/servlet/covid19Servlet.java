package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.COVID19;
import service.cityService;
import service.impl.cityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/covid19Servlet")
public class covid19Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String city=(String) session.getAttribute("city");
        System.out.println(city);
        cityServiceImpl service=new cityServiceImpl();
        COVID19 covid19=service.findByCity(city);
        System.out.println(covid19);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(covid19);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
        }
    }

