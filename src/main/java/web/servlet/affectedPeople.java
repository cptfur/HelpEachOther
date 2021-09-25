package web.servlet;

import domain.information;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.util.ClusterNodeInformation;
import service.affectedPeopleService;
import service.impl.affectedServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/affectedPeople")
public class affectedPeople extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        information information=new information();
         Map<String,String[]> parameterMap=req.getParameterMap();
        try {
            BeanUtils.populate(information,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        HttpSession session=req.getSession();
        String lng = (String)session.getAttribute("lng");
        String lat = (String) session.getAttribute("lat");
        information.setLat(lat);
        information.setLng(lng);
        affectedServiceImpl service=new affectedServiceImpl();
        service.saveAffected(information);


    }
}
