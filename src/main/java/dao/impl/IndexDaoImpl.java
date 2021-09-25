package dao.impl;

import dao.IndexDao;
import domain.message;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;
import java.util.List;

public class IndexDaoImpl implements IndexDao {
    private  JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    public List<message> findMessage(String address){
        String sql="select * from indexsql where address=?";
        return (List<message>) template.query(sql,new BeanPropertyRowMapper<message>(message.class),address);
    }

}
