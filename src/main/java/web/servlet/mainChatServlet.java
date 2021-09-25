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

@WebServlet("/mainChatServlet")
public class mainChatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String send =(String) session.getAttribute("mainSend");
        String get=(String) session.getAttribute("mainGet");
        chat chat1=new chat();
        chat1.setSend(send);
        chat1.setGet(get);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(chat1);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
