package web.servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import service.IndexService;
import service.impl.IndexServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/indexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IndexService indexService=new IndexServiceImpl();
        HttpSession session=req.getSession();
        String address=(String) session.getAttribute("Address");
        ObjectMapper mapper = new ObjectMapper();
        resp.setContentType("application/json;charset=utf-8");
        mapper.writeValue(resp.getOutputStream(),indexService.findMessages(address));
        System.out.println(indexService.findMessages(address));
    }
}
