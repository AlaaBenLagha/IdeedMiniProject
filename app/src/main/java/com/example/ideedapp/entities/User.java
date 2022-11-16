package com.example.ideedapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.Arrays;


@Entity(tableName = "users_table")
public class User implements Serializable {

    //var

    @PrimaryKey(autoGenerate = true)
    private int id;
//    @ColumnInfo(name = "username")
//    private String userName ;

    @ColumnInfo(name = "email")
    private String email;

    @ColumnInfo(name = "password")
    private String password;



    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    Byte [] image;

//    @ColumnInfo(name = "firstname")
//    private String firstName;

//    @ColumnInfo(name = "lastname")
//    private String lastName ;




    //constructor

    public User() {
    }


    public User(int id, String email, String password, Byte[] image) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.image = image;
    }



    public User(String userName,String password, String email,String firstName,String lastName) {

      //  this.userName = userName;

        this.email = email;
        this.password = password;
      //  this.firstName = firstName;
    //    this.lastName = lastName;
    }
//empty Constructor


    //Getters&Setters


    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

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
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
