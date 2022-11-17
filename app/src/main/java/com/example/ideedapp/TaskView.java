package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ideedapp.Adapter.TagsAdapter;
import com.example.ideedapp.Adapter.TaskAdapter;
import com.example.ideedapp.DAO.TagsDAO;
import com.example.ideedapp.DAO.TaskDAO;
import com.example.ideedapp.DataBase.TaskDataBase;
import com.example.ideedapp.entities.Tasks;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class TaskView extends AppCompatActivity {



    //var
    List<Tasks> tasks = new ArrayList<>();
    private TaskAdapter taskAdapter;
    private TaskDAO taskDAO;
    private TaskDataBase taskDataBase;




    //widgets
    private RecyclerView tRecyclerView;
    private MaterialButton createTaskMenuBtn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view);
        setTitle("Tasks&Events");


        taskDataBase = TaskDataBase.getInstance(this);
        taskDAO=taskDataBase.taskDAO();
        //binding
        tRecyclerView = findViewById(R.id.tRecycler);
        createTaskMenuBtn=findViewById(R.id.createtaskmenu);


        //init

        taskAdapter = new TaskAdapter(this,tasks);



        //recyclerViw Config


        tRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        tRecyclerView.setAdapter(new TaskAdapter(this,tasks));


        createTaskMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TaskView.this,CreateTasksTagsLists.class);
                startActivity(intent);
            }
        });



    }



}
