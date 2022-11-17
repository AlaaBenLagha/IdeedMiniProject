package com.example.ideedapp.DataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ideedapp.DAO.TagsDAO;

import com.example.ideedapp.entities.Tags;


@Database(entities = {Tags.class},version = 2)
public abstract class TagsDataBase extends RoomDatabase {

    //var
    private static TagsDataBase instance;


    private final static String DATABASE_NAME = "tagsDB";
    public static synchronized TagsDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, TagsDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract TagsDAO getDao();
}
