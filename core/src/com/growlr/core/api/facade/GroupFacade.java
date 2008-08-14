package com.growlr.core.api.facade;

import com.growlr.core.data.Group;

import java.util.List;

/**
 * User: stuart
 * Date: Aug 13, 2008
 * Time: 6:07:53 PM
 */
public interface GroupFacade {

    //== group stuff
    public Group createNewGroup(Group g);
    public Group editGroup(Group g);
    public void removeGroup(Group g);
    public Group getGroup(int id);
    public List<Group> listGroupsByCreator(int id);

    //== Group member stuff
}
