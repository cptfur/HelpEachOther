package dao.impl;
import domain.COVID19;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

public class cityDao {
    private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    public COVID19 findCovid19(String city){
        String sql="select * from province where provinceName=?";
        return  template.queryForObject(sql,new BeanPropertyRowMapper<COVID19>(COVID19.class),city);
    }

}
