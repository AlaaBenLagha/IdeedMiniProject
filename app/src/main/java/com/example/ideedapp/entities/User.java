package com.example.ideedapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Arrays;



@Entity(tableName = "users_table")
public class User implements Serializable {

    //var

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;










    //constructor


    public User() {
    }


    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;

    }



//empty Constructor


    //Getters&Setters



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





    //ToString


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}
