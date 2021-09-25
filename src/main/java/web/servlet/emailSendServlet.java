package web.servlet;

import domain.User;
import domain.checkbox;
import util.emailUtil;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/emailSendServlet")
public class emailSendServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        System.out.println(email);
        checkbox checkbox = new checkbox();
        String check= checkbox.getCheckCode();
        emailUtil emailUtil=new emailUtil();
        try {
            emailUtil.sendMail(email,"验证邮件",check);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        HttpSession session= req.getSession();
        session.setAttribute("check",check);
    }
}
