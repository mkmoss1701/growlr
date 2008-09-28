package com.growlr.core.data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * Creator: Espen Nordhaug
 * Date: Sep 10, 2008
 */
@Entity
public class Message {
    private int id;
    private int groupId;
    private String message;
    private Date sent;
    private String type;

    public final static String TYPE_SMS = "SMS";
    public final static String TYPE_MAIL = "MAIL";

    public Message() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Column(name = "message", nullable = false)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Column(name = "sent", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
