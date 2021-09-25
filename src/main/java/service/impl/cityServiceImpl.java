package service.impl;

import dao.impl.cityDao;
import domain.COVID19;

public class cityServiceImpl {
    public COVID19 findByCity(String city){
        cityDao cityDao=new cityDao();
        return cityDao.findCovid19(city);
    }
 }
