package com.growlr.core.api.facade;

import com.growlr.core.data.User;

/**
 * User: stuart
 * Date: Aug 13, 2008
 * Time: 5:37:26 PM
 */
public interface UserFacade {

    public User createNewUser(User u);
    public User editUser(User u);
    public void removeUser(User u);
    public User getUser(int id);
    public User authenticateUser(String number, String password);
   
}
