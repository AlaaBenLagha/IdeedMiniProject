package com.example.ideedapp.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ideedapp.DAO.UserDAO;
import com.example.ideedapp.entities.User;


@Database(entities = {User.class},version = 7)
public abstract class AppDataBase extends RoomDatabase {


   //var
    private static AppDataBase instance;

    private final static String DATABASE_NAME = "userDB";
    public static synchronized AppDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, AppDataBase.class, DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }


    public abstract UserDAO userDAO();
}
