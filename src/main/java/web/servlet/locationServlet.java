package web.servlet;

import domain.location;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.Location;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/locationServlet")
public class locationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        location location = new location();
        try {
            BeanUtils.populate(location,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(location);
        HttpSession Session = req.getSession();
        Session.setAttribute("PersonAddress",location.getProvince()+location.getCity()+location.getAddr());
        Session.setAttribute("Address",location.getProvince()+location.getCity());
        Session.setAttribute("city",location.getCity());
        Session.setAttribute("lng",location.getLng());
        Session.setAttribute("lat",location.getLat());
    }
}
