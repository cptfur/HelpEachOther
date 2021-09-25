package service.impl;

import dao.affectedPeopleDao;
import dao.impl.affectedPeopleDaoImpl;
import domain.information;

import java.util.List;

public class affectedServiceImpl {
    public void saveAffected(information information){
        affectedPeopleDaoImpl dao=new affectedPeopleDaoImpl();
        dao.saveAffectedPeople(information);

    }
    public List<information> getAffected(String page){
        affectedPeopleDaoImpl dao=new affectedPeopleDaoImpl();
        return dao.getaffected(page);
    }

}
