package com.example.ideedapp.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.ideedapp.DAO.TaskDAO;
import com.example.ideedapp.entities.Tasks;



@Database(entities = {Tasks.class},version = 5)
public abstract class TaskDataBase extends RoomDatabase {

    //var
    private static TaskDataBase instance;

    private final static String DATABASE_NAME = "taskDB";
    public static synchronized TaskDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context, TaskDataBase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    public abstract TaskDAO taskDAO();
}
