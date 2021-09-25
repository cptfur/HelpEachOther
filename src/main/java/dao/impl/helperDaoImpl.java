package dao.impl;

import dao.helperDao;
import domain.information;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class helperDaoImpl implements helperDao {
    private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    public void saveHelper(information heler ){
        String sql="insert into helper (username,phonenumber,address,thing,number) values(?,?,?,?,?)";
        template.update(heler.getUsername(),heler.getPhonenumber(),heler.getAddress(),heler.getThing(),heler.getNumber());
    }
    public List<information> getahelper(String page){
        String sql="select * from help limit "+page+",6";
        return template.query(sql,new BeanPropertyRowMapper<information>(information.class));

    }
}
