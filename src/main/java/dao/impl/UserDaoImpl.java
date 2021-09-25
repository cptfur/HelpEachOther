package dao.impl;

import dao.UserDao;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JdbcUtils.getDataSource());
    @Override
    public User findByphonenumber(String phonenumber) {
        User user=null;
        try {
            String sql="select * from user where phonenumber=?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), phonenumber);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return user;

    }
    @Override
    public void save(User user) {
        String sql="insert into user (username,password,email,phonenumber,gender,birthday) values(?,?,?,?,?,?)";
        template.update(sql,user.getUsername(),user.getPassword(),user.getEmail(),user.getPhonenumber(),user.getGender(),user.getBirthday());
    }

    public User login(String phonenumber, String password) {
        User user=null;
        try {
            String sql="select * from user where phonenumber=? and password =?";
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), phonenumber,password);
        } catch (DataAccessException e) {
            return null;
        }
        return user;

    }
    public void changePassword(String password,String phonenumber){
        String sql="update user set password = ? where phonenumber=?";
        template.update(sql,password,phonenumber);
    }


}
