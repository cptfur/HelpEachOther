package service;

import domain.User;

public interface UserService {
    boolean regist(User user);
    void changePassword(User user);
}
