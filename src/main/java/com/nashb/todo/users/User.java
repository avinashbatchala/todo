package com.nashb.todo.users;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
public class User {

    @Id
    @Generated
    private int userId;

    @Column
    private String firstName;
    @Column
    private String lastName;
    private String email;
    private String password;

}
