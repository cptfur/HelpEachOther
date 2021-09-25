package dao.impl;

import domain.chat;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class chatDaoImpl {
    private JdbcTemplate template = new JdbcTemplate(JdbcUtils.getDataSource());
    public void saveChat(chat chat){
        String sql="insert into chat (send,get,message) values (?,?,?)";
        template.update(sql,chat.getSend(),chat.getGet(),chat.getMessage());

    }
    public List<chat> findSend(String phonenumber){
        String sql="select  distinct send,get from chat where get=?";
        return  template.query(sql,new BeanPropertyRowMapper<chat>(chat.class),phonenumber);

    }
    public List<chat> findAll(String send,String get){
        String sql="select * from chat where (send=? and get=? ) or (send=? and get=?)" ;
        return template.query(sql,new BeanPropertyRowMapper<chat>(chat.class),send,get,get,send);
    }

}