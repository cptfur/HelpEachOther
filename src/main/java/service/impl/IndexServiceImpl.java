package service.impl;
import dao.IndexDao;
import dao.impl.IndexDaoImpl;
import domain.message;
import service.IndexService;

import java.util.List;

public class IndexServiceImpl implements IndexService {
    public List<message> findMessages(String address){
        IndexDao service=new IndexDaoImpl();
        return  service.findMessage(address);
    }

}
