package com.growlr.core.impl.facade;

import com.growlr.core.data.Message;
import com.growlr.core.data.Group;

import javax.ejb.Stateless;

/**
 * Created by IntelliJ IDEA.
 * Creator: Espen Nordhaug
 * Date: Sep 20, 2008
 */
//TODO: Does not belong in facade, since will contain business logic. Refactoring needed
@Stateless
public class MessageDispatcherBean {
    public void publish(Message m, Group g) {
        //g.getUsers();
    }
}
