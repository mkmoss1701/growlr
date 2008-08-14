package com.growlr.core.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "groups")
public class Group implements Serializable {

    private int id;
    private String name = null;
    private int creatorId;
    private Date created;
    private boolean publicGroup = false;
    private boolean memberMessaging = false;



    public Group() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName( String name ) {
        this.name = name;
    }

    @Column(name = "creator", nullable = false)
    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId( int creatorId ) {
        this.creatorId = creatorId;
    }

    @Column(name = "created", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getCreated() {
        return created;
    }

    public void setCreated( Date created ) {
        this.created = created;
    }

    @Column(name = "public", nullable = false)
    public boolean isPublicGroup() {
        return publicGroup;
    }

    public void setPublicGroup( boolean publicGroup ) {
        this.publicGroup = publicGroup;
    }

    @Column(name = "membermessaging", nullable = false)
    public boolean isMemberMessaging() {
        return memberMessaging;
    }

    public void setMemberMessaging( boolean memberMessaging ) {
        this.memberMessaging = memberMessaging;
    }
}
