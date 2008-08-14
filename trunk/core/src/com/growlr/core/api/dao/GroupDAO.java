package com.growlr.core.api.dao;

import com.growlr.core.data.Group;

import java.util.List;

/**
 * User: stuart
 * Date: Aug 13, 2008
 * Time: 6:07:46 PM
 */
public interface GroupDAO {

    public Group setGroup(Group g);
    public Group getGroup(int id);
    public Group editGroup(Group g);
    public void removeGroup(Group g);
    public List<Group> listGroupsByCreator(int creatorid);
}
