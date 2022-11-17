package com.example.ideedapp.DAO;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ideedapp.entities.Tasks;

import java.util.List;


@Dao
public interface TaskDAO {


    @Insert
    void insert(Tasks tasks);


    @Update
    void update(Tasks task);

    @Query("delete from tasks_table where id=:id")
    void delete(int id);


    @Query("Select * from tasks_table")
    List<Tasks> getAllTasks();
}
