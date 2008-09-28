package com.growlr.core.impl.dao;

import com.growlr.core.api.dao.MessageDAO;
import com.growlr.core.data.Message;
import com.growlr.core.data.Group;

import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Creator: Espen Nordhaug
 * Date: Sep 11, 2008
 */
@Stateless
@Local(MessageDAO.class)
public class MessageDAOBean implements MessageDAO {
    @PersistenceContext(unitName = "growlr")
    private EntityManager manager;

    public Message setMessage(Message m) {
        return manager.merge(m);
    }

    public Message getMessage(int id) {
         return manager.find( Message.class, id );
    }
    //TODO:Decide if this should be a groups timeline,how this should relate to a public timeline, limit by date, number etc
    public List<Message> getMessages(Group g) {
        return null;
    }

    public void removeMessage(Message m) {
        manager.remove(m);
        manager.flush();

    }
}
