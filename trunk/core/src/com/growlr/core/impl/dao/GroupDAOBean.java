package com.growlr.core.impl.dao;

import com.growlr.core.api.dao.GroupDAO;
import com.growlr.core.data.Group;

import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Stateless
@Local(GroupDAO.class)
public class GroupDAOBean implements GroupDAO {

    @PersistenceContext(unitName = "growlr")
    private EntityManager manager;

    public Group setGroup( Group g ) {
        return manager.merge( g );
    }

    public Group getGroup( int id ) {
        return manager.find( Group.class, id );
    }

    public Group editGroup( Group g ) {
        return manager.merge( g );
    }

    public void removeGroup( Group g ) {
        manager.remove( g );
        manager.flush();
    }

    public List<Group> listGroupsByCreator( int creatorid ) {
        Query q = manager.createQuery( "select g from Group g where g.creatorId = :creatorId" );
        q.setParameter( "creatorId", creatorid );
        return q.getResultList();
    }
}
