package com.example.ideedapp;

import java.util.Date;

public class Tasks {


    //var
    private int id;
    private String taskName;
    private int Image;
   /* private String note;
    private Date tastDate;
    private Date creationDate;
    private int picture;
    private int gallerieImg; */




    //constructor

    public Tasks(int id) {
        this.id = id;
    }

    public Tasks(int id, String taskName, int image) {
        this.id = id;
        this.taskName = taskName;
        Image = image;
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

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }


    //ToString


    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", Image=" + Image +
                '}';
    }
}
