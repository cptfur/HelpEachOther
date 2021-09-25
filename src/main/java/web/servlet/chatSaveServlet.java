package web.servlet;

import dao.impl.UserDaoImpl;
import domain.User;
import domain.chat;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.chatImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/chatSaveServlet")
public class chatSaveServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = req.getParameter("message");
        chat chat=new chat();
        HttpSession session=req.getSession();
        String phonenumber = (String) session.getAttribute("phonenumber");
        String phonenumber1 = (String)session.getAttribute("phonenumber1");
        chat.setSend(phonenumber);
        chat.setGet(phonenumber1);
        chat.setMessage(message);
        chatImpl chat1=new chatImpl();
        chat1.saveChat(chat);

    }
}
