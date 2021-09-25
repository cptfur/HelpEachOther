package service.impl;

import dao.impl.helperDaoImpl;
import domain.information;

import java.util.List;

public class helperServiceImpl {
    public void saveHelper(information information){
        helperDaoImpl dao = new helperDaoImpl();
        dao.saveHelper(information);
    }
    public List<information> information(String page){
        helperDaoImpl helperDao=new helperDaoImpl();
        return  helperDao.getahelper(page);
    }
}
