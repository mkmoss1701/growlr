package com.growlr.core.impl.facade;

import com.growlr.core.api.facade.GroupFacade;
import com.growlr.core.api.dao.GroupDAO;
import com.growlr.core.data.Group;

import javax.ejb.*;

import org.jboss.annotation.ejb.LocalBinding;
import org.jboss.annotation.ejb.RemoteBinding;

import java.util.List;
import java.util.Date;

@Stateless
@Local(GroupFacade.class)
@Remote(GroupFacade.class)
@LocalBinding(jndiBinding = "growlr/GroupFacade/local")
@RemoteBinding(jndiBinding = "growlr/GroupFacade/remote")
public class GroupFacadeBean implements GroupFacade {


    @EJB
    private GroupDAO dao;

    //== group stuff
    public Group createNewGroup( Group g ) {
        if (g == null) {
            throw new EJBException("GROUPFACADE:CreateGroup:: supplied group is null ");
        }

        if (g.getName() == null || g.getName().equalsIgnoreCase( "" )) {
            throw new EJBException("GROUPFACADE:CreateGroup:: Group name field is null/blank ");
        }

        //== set created date
        g.setCreated( new Date() );

        return dao.setGroup( g );
    }

    public Group editGroup( Group g ) {
        if (g == null) {
            throw new EJBException("GROUPFACADE:CreateGroup:: supplied group is null ");
        }

        if (g.getName() == null || g.getName().equalsIgnoreCase( "" )) {
            throw new EJBException("GROUPFACADE:CreateGroup:: Group name field is null/blank ");
        }

        return dao.editGroup( g );
    }

    
    public void removeGroup( Group g ) {
        dao.removeGroup( g );
    }

    
    public Group getGroup( int id ) {
        return dao.getGroup( id );
    }

    public List<Group> listGroupsByCreator( int id ) {
        return dao.listGroupsByCreator( id );
    }
}
