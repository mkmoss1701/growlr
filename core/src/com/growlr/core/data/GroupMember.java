package com.growlr.core.data;

import java.io.Serializable;

/**
 * User: stuart
 * Date: Aug 13, 2008
 * Time: 6:08:26 PM
 */
public class GroupMember implements Serializable {

    private int id;
    private int userId;
    private int groupdId;
    private boolean isAdmin = false;


    public GroupMember() {
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId( int userId ) {
        this.userId = userId;
    }

    public int getGroupdId() {
        return groupdId;
    }

    public void setGroupdId( int groupdId ) {
        this.groupdId = groupdId;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin( boolean admin ) {
        isAdmin = admin;
    }
}
