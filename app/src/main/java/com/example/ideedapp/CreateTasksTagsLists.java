package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.ideedapp.Adapter.AdapterListener;
import com.example.ideedapp.Adapter.TagsAdapter;
import com.example.ideedapp.entities.Tags;
import com.example.ideedapp.entities.Tasks;

import java.util.ArrayList;
import java.util.List;

public class CreateTaksTagsLists extends AppCompatActivity implements AdapterListener {


    // var
    List<Tags> tags = new ArrayList<>();

    private TagsAdapter tagsAdapter;
    private RecyclerView tagRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_taks_tags_lists);



        //init

        tags.add(new Tags(1,"Do"));
        tags.add(new Tags(2,"Check"));
        tags.add(new Tags(3,"Get"));
        tags.add(new Tags(4,"Meet"));
        tags.add(new Tags(5,"Call"));
        tags.add(new Tags(6,"Send"));
        tags.add(new Tags(7,"Study"));
        tags.add(new Tags(8,"Ask"));
        tags.add(new Tags(9,"Read"));
        tags.add(new Tags(10,"Watch"));


        //binding
        tagRecycler = findViewById(R.id.tagRecycler);



        ////recyclerViw Config

        tagsAdapter = new TagsAdapter()


    }

    @Override
    public void OnClickTag(int id, int pos) {

    }
}
