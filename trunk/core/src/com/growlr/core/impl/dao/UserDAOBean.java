package com.growlr.core.impl.dao;

import com.growlr.core.api.dao.UserDAO;
import com.growlr.core.data.User;

import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Stateless
@Local(UserDAO.class)
public class UserDAOBean implements UserDAO {

    @PersistenceContext(unitName = "growlr")
    private EntityManager manager;
    
    public User setUser( User u ) {
        return manager.merge( u );
    }

    public User getUser( int id ) {
        return manager.find( User.class, id );
    }

    public User editUser( User u ) {
        return manager.merge( u );
    }

    public void removeUser( User u ) {
        manager.remove( u );
        manager.flush();
    }

    public User authenticateUser( String number, String password ) {
        Query q = manager.createQuery( "select u from User where u.number = :number and u.password = :password" );
        q.setParameter( "number", number );
        q.setParameter( "password", password );
        return (User)q.getSingleResult();
    }
    
}
