package com.growlr.core.data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private int id;
    private String number = null;
    private String password = null;
    private Date created = null;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    @Column(name = "number", nullable = true, unique = false)    
    public String getNumber() {
        return number;
    }

    public void setNumber( String number ) {
        this.number = number;
    }

    @Column(name = "password", nullable = false, unique = false)
    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    @Column(name = "create", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    public Date getCreated() {
        return created;
    }

    public void setCreated( Date created ) {
        this.created = created;
    }
}
