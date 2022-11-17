package com.example.ideedapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ideedapp.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ideedapp.entities.Tags;

import java.util.List;

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.ViewHolder> {



    //var
    private Context tagsContext;
    private List<Tags> tagsList;
    private AdapterListener adapterListener;

    //Constructor

    public TagsAdapter(Context tagsContext, List<Tags> tags,AdapterListener adapterListener ){
        this.tagsContext = tagsContext;
        this.tagsList = tags;
        this.adapterListener = adapterListener;
    }




    //ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tTags;
        ImageView useTag;

        //cellule
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //Binding
            tTags = itemView.findViewById(R.id.tTags);
            useTag = itemView.findViewById(R.id.useTag);
        }
    }


    //first in life cycle
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(tagsContext).inflate(R.layout.tasks_tags,parent,false);

        return new ViewHolder(view);
    }


    // Affect Content to Graphic Components  (!!loop!!)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tags tags = tagsList.get(position);
        holder.tTags.setText(tags.getTagName());


        holder.useTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterListener.OnClickTag(tags);

            }
        });

    }

    @Override
    public int getItemCount() {
        return tagsList.size();
    }
}
