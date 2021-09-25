package web.servlet;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.covid19;
import domain.ResultInfo;
import domain.User;
import domain.location;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        User user=new User();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        UserServiceImpl userService = new UserServiceImpl();
        User loginUser=userService.login(user);
        HttpSession Session = req.getSession();
        String city = (String)Session.getAttribute("city");
        ResultInfo info = new ResultInfo();
        if(loginUser!=null && city!=null)
        {
            info.setFlag(true);
            Session.setAttribute("phonenumber",loginUser.getPhonenumber());
        }else {
            info.setFlag(false);
            info.setErrorMsg("用户名密码或定位错误");
        }
        ObjectMapper mapper=new ObjectMapper();
        String json = mapper.writeValueAsString(info);
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);

}
}
