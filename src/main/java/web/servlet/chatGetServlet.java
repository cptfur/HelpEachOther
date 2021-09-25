package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.UserDaoImpl;
import domain.User;
import domain.chat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/chatGetServlet")
public class chatGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        String phonenumber1 =(String) session.getAttribute("phonenumber1");
        String phonenumber =(String) session.getAttribute("phonenumber");
        System.out.println(phonenumber);
        chat chat=new chat();
        chat.setSend(phonenumber);
        chat.setGet(phonenumber1);
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(chat);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
