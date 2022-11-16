package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ideedapp.Adapter.TaskAdapter;

import java.util.ArrayList;
import java.util.List;

public class TaskView extends AppCompatActivity {



    //var
    List<Tasks> tasks = new ArrayList<>();




    //widgets
    private RecyclerView tRecyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view);

        //init

        tasks.add(new Tasks(1,"Email",R.mipmap.ic_launcher));
        tasks.add(new Tasks(1,"Check",R.mipmap.ic_launcher));
        tasks.add(new Tasks(1,"Get",R.mipmap.ic_launcher));
        tasks.add(new Tasks(1,"Call",R.mipmap.ic_launcher));
        tasks.add(new Tasks(1,"Send",R.mipmap.ic_launcher));


        //binding
        tRecyclerView = findViewById(R.id.tRecycler);


        //recyclerViw Config

        tRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        tRecyclerView.setAdapter(new TaskAdapter(this,tasks));
    }
}
