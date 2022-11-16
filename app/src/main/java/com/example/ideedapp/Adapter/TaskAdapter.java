package com.example.ideedapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideedapp.R;
import com.example.ideedapp.Tasks;
import com.example.ideedapp.entities.User;

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
    public class ViewHolder extends  RecyclerView.ViewHolder{
        //widgets
         TextView ttaskt;
         ImageView timageview;


         //Cellule
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Binding
            ttaskt = itemView.findViewById(R.id.tTask);
            timageview = itemView.findViewById(R.id.tImageView);
        }
    }





    //First Life cycle
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //LayoutInflater(layout creator)          || layout create
        //Jib l modele a suivre
        View tItemView = LayoutInflater.from(tContext).inflate(R.layout.tasks, parent, false);
        return new ViewHolder(tItemView);
    }


    // Affect Content to Graphic Components  (!!loop!!)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tasks t = tasks.get(position);
        holder.ttaskt.setText(t.getTaskName());
        holder.timageview.setImageResource(t.getImage());



    }


    //Size of displayed List
    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
