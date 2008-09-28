package com.growlr.core.api.dao;

import com.growlr.core.data.Message;
import com.growlr.core.data.Group;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Creator: Espen Nordhaug
 * Date: Sep 10, 2008
 */
public interface MessageDAO {
    public Message setMessage(Message m);
    public Message getMessage(int id);
    public List<Message> getMessages(Group g);
    public void removeMessage(Message m);
}
