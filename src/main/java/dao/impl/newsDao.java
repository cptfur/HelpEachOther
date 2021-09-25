package dao.impl;

import domain.news;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

import java.util.List;

public class newsDao {
    private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    public List<news> findAll(){
        String sql="select * from news";
        return template.query(sql,new BeanPropertyRowMapper<news>(news.class));
    }
}
