package com.example.ideedapp.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ideedapp.entities.User;

import java.util.List;

@Dao
public interface UserDAO {

        @Insert
        void setUser(User user);


//        @Update
 //       void updateUser(User user);





        @Update
        void updateUsers(User user);




 //       @Query("DELETE FROM users_table WHERE id=:id")
 //       void deleteUser(int id);

   //     @Query("SELECT * FROM users_table")
     //   List<User> getAllUsers();

        @Query("SELECT * FROM users_table WHERE email=(:email) AND password=(:password)")
        User login(String email,String password);




}
