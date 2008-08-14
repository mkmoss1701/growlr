package com.growlr.core.impl.facade;

import com.growlr.core.api.facade.UserFacade;
import com.growlr.core.api.dao.UserDAO;
import com.growlr.core.data.User;
import com.growlr.core.utils.SHA;

import javax.ejb.*;

import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;

import java.util.Date;


@Stateless
@Local(UserFacade.class)
@Remote(UserFacade.class)
@LocalBinding(jndiBinding = "growlr/UserFacade/local")
@RemoteBinding(jndiBinding = "growlr/UserFacade/remote")
public class UserFacadeBean implements UserFacade {

    @EJB
    private UserDAO dao;


    public User createNewUser( User u ) {

        if (u == null) {
            throw new EJBException("USERFACADE:CreateUser:: supplied user is null ");
        }

        if (u.getNumber() == null || u.getNumber().equalsIgnoreCase( "" )) {
            throw new EJBException("USERFACADE:CreateUser:: User number field is null/blank ");
        }

        if (u.getPassword() == null || u.getPassword().equalsIgnoreCase( "" )) {
            throw new EJBException("USERFACADE:CreateUser:: User password field is null/blank ");            
        }

        //== set to now() :D
        u.setCreated(  new Date() );

        //== persist and return saved object
        return dao.setUser( u );
    }

    public User editUser( User u ) {
        
        if (u == null) {
            throw new EJBException("USERFACADE:CreateUser:: supplied user is null ");
        }

        if (u.getNumber() == null || u.getNumber().equalsIgnoreCase( "" )) {
            throw new EJBException("USERFACADE:CreateUser:: User number field is null/blank ");
        }

        if (u.getPassword() == null || u.getPassword().equalsIgnoreCase( "" )) {
            throw new EJBException("USERFACADE:CreateUser:: User password field is null/blank ");
        }

        return dao.editUser( u );
    }

    public void removeUser( User u ) {
        dao.removeUser( u );  
    }

    public User getUser( int id ) {
        return dao.getUser( id );
    }

    public User authenticateUser( String number, String password ) {
        if (number == null || number.equalsIgnoreCase( "" )) {
            throw new EJBException("Authentication Failed: Number field is null/blank");
        }

        if (password == null || password.equalsIgnoreCase( "" )) {
            throw new EJBException("Authentication Failed: Password field is null/blank");
        }

        password = SHA.getDigest( password );
        return dao.authenticateUser( number, password );

    }
}
