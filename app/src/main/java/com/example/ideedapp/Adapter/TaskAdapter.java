package com.example.ideedapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideedapp.R;

import com.example.ideedapp.entities.Tasks;


import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {



    //var

    private Context tContext;
    private List<Tasks> tasks;



    //Constructor

    public TaskAdapter(Context tContext, List<Tasks> tasks) {
        this.tContext = tContext;
        this.tasks = tasks;
    }



    //ViewHolder  //gestionnaire de cellule  ( contenu mta3 kol cellule )
    public class ViewHolder extends RecyclerView.ViewHolder{
        //widget
         TextView tasksTv;
         TextView date;


         //Cellule
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Binding
            tasksTv = itemView.findViewById(R.id.tTask);
            date = itemView.findViewById(R.id.date);

        }
    }





    //First Life cycle
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //LayoutInflater(layout creator)          || layout create
        //Jib l modele a suivre
        View view = LayoutInflater.from(tContext).inflate(R.layout.tasks,parent,false);
        return new ViewHolder(view);
    }


    // Affect Content to Graphic Components  (!!loop!!)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tasks t = tasks.get(position);
        holder.tasksTv.setText(t.getTaskName());
        holder.date.setText(t.getSetDate());




    }


    //Size of displayed List
    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
