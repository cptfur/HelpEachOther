package web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.ResultInfo;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/emailCheckServlet")
public class emailCheckServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user=new User();
        Map<String, String[]> parameterMap = req.getParameterMap();
        try {
            BeanUtils.populate(user,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
        HttpSession session=req.getSession();
        String check = (String) session.getAttribute("check");
        System.out.println(check);
        ResultInfo info=new ResultInfo();
        if(check.equals(user.getCheckbox())){
            info.setFlag(true);
            UserServiceImpl userService = new UserServiceImpl();
            userService.changePassword(user);
        }else{
            info.setFlag(false);
            info.setErrorMsg("验证码错误");
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        //将json数据写回客户端
        //设置content-type
        resp.setContentType("application/json;charset=utf-8");
        resp.getWriter().write(json);
    }
}
