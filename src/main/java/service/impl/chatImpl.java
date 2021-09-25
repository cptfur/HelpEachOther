package service.impl;

import dao.impl.chatDaoImpl;
import domain.chat;

import java.util.List;

public class chatImpl {
    public  void  saveChat(chat chat){
        chatDaoImpl chatDao=new chatDaoImpl();
        chatDao.saveChat(chat);
    }
    public List<chat> findSend(String phonenumber){
        chatDaoImpl dao=new chatDaoImpl();
        return dao.findSend(phonenumber);
    }
    public List<chat> findAll(String send,String get){
        chatDaoImpl dao=new chatDaoImpl();
        return dao.findAll(send,get);
    }
}
