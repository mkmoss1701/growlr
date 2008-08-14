package com.growlr.core.api.dao;

import com.growlr.core.data.User;

/**
 * User: stuart
 * Date: Aug 13, 2008
 * Time: 5:46:00 PM
 */
public interface UserDAO {

    public User setUser(User u);
    public User getUser(int id);
    public User editUser(User u);
    public void removeUser(User u);
    public User authenticateUser(String number, String password);
}
