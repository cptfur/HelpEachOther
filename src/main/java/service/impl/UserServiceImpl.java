package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao=new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        User  phonenumber=userDao.findByphonenumber(user.getPhonenumber());
        if(phonenumber!=null)
        {
            return false;
        }else {
            userDao.save(user);
            return true;
        }
    }
    public User login(User user){
        UserDaoImpl userDao = new UserDaoImpl();
        User login = userDao.login(user.getPhonenumber(), user.getPassword());
        return login;
    }
    public void changePassword(User user)
    {
        UserDaoImpl userDao=new UserDaoImpl();
        userDao.changePassword(user.getPassword(),user.getPhonenumber());
    };

}
