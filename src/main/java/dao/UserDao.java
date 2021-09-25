package dao;

import domain.User;

public interface UserDao{
    User findByphonenumber(String username);

    void save(User user);

    User login(String phonenumber, String password);
    void changePassword(String password,String phonenumber);
}
