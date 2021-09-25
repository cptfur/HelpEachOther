package service.impl;

import dao.impl.newsDao;
import domain.news;

import java.util.List;

public class newsServiceImpl {
    public List<news> findAll(){
        newsDao dao=new newsDao();
        return dao.findAll();
    }
}
