package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.chat;
import service.impl.chatImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/mainChatMainServlet")
public class mainChatMainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String phonenumber = (String) session.getAttribute("phonenumber");
        chatImpl chat1=new chatImpl();
        List<chat> send = chat1.findSend(phonenumber);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(send);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
