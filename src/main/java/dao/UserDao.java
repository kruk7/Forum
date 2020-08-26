package dao;

import entity.User;

public interface UserDao
{
    String USER_ROLE = "user";
    String ADMIN_ROLE = "admin";

    User getByLogin(String login);

    boolean addUser(User user);
}
