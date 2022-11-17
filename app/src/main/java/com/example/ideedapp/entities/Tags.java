package com.example.ideedapp.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "tags_table")
public class Tags implements Serializable{


    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "tagname")
    private String TagName;






    public Tags(int id) {
        this.id = id;
    }

    public Tags(int id, String tagName) {
        this.id = id;
        TagName = tagName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagName() {
        return TagName;
    }

    public void setTagName(String tagName) {
        TagName = tagName;
    }



    @Override
    public String toString() {
        return "Tags{" +
                "id=" + id +
                ", TagName='" + TagName + '\'' +

                '}';
    }
}
