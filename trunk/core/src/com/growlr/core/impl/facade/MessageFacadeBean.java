package com.growlr.core.impl.facade;

import com.growlr.core.api.facade.MessageFacade;
import com.growlr.core.api.dao.MessageDAO;
import com.growlr.core.data.Message;
import com.growlr.core.data.Group;

import javax.ejb.*;
import java.util.List;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Creator: Espen Nordhaug
 * Date: Sep 18, 2008
 */

@Stateless
@Local(MessageFacade.class)
@Remote(MessageFacade.class)
@LocalBinding(jndiBinding = "growlr/MessageFacade/local")
@RemoteBinding(jndiBinding = "growlr/MessageFacade/remote")

public class MessageFacadeBean implements MessageFacade {
    @EJB
    private MessageDAO dao;
    public Message createMessage(Message m) {
         if (m == null) {
            throw new EJBException(this.getClass().getCanonicalName() + ":createMessage:: message is null");
        }

        if (m.getMessage() == null || m.getMessage().equalsIgnoreCase("")) {
            throw new EJBException(this.getClass().getCanonicalName() + ":createMessage:: message field is null/blank");
        }

        //why not ? :D
        m.setSent(new Date());

        return dao.setMessage(m);
        //Todo: send message if save is ok
    }

    public Message getMessage(int id) {
        return dao.getMessage(id);
    }

    public List<Message> getMessages(Group g) {
        return dao.getMessages(g);
    }

    public void removeMessage(Message m) {
        dao.removeMessage(m);
    }
}
