package com.example.ideedapp.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;


@Entity(tableName = "tasks_table")
public class Tasks {


    //var

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "taskname")
    private String taskName;



    @ColumnInfo(name = "note")
    private String note;

    @ColumnInfo(name = "creation_date")
    private String creationDate;

    @ColumnInfo(name = "task_date")
    private String setDate;


     /*  @ColumnInfo(name = "image")
    private int Image; */
  /*
    private Date creationDate;
    private int picture;
    private int gallerieImg; */




    //constructor

    public Tasks(int id, String taskName, String note, String creationDate, String setDate) {
        this.id = id;
        this.taskName = taskName;
        this.note = note;
        this.creationDate = creationDate;
        this.setDate = setDate;
    }


    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSetDate() {
        return setDate;
    }

    public void setSetDate(String setDate) {
        this.setDate = setDate;
    }

    //ToString


    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", note='" + note + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", setDate='" + setDate + '\'' +
                '}';
    }
}
