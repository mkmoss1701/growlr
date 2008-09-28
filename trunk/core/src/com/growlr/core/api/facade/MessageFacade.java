package com.growlr.core.api.facade;

import com.growlr.core.data.Message;
import com.growlr.core.data.Group;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Creator: Espen Nordhaug
 * Date: Sep 18, 2008
 */
public interface MessageFacade {
    public Message createMessage(Message m);
    public Message getMessage(int id);
    public List<Message> getMessages(Group g);
    public void removeMessage(Message m);
}
