package dao.impl;

import dao.affectedPeopleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;
import domain.information;

import java.util.List;

public class affectedPeopleDaoImpl implements affectedPeopleDao {
     private  JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
        public void saveAffectedPeople(information affected ){
            String sql="insert into affectedPeople (username,phonenumber,address,thing,number) values(?,?,?,?,?)";
            template.update(affected.getUsername(),affected.getPhonenumber(),affected.getAddress(),affected.getThing(),affected.getNumber());
        }
        public List<information> getaffected(String page){
            String sql="select * from affectedPeople limit "+page+",6";
            return template.query(sql,new BeanPropertyRowMapper<information>(information.class));

        }
}
