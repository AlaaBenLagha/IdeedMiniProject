package com.example.ideedapp.DAO;


import androidx.room.Dao;
import androidx.room.Query;

import com.example.ideedapp.entities.Tags;
import com.example.ideedapp.entities.Tasks;

import java.util.List;

@Dao
public interface TagsDAO {



    @Query("Select * from tags_table")
    List<Tags> getAllTags();
}
