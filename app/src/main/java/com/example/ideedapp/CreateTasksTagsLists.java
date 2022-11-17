package com.example.ideedapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ideedapp.Adapter.AdapterListener;
import com.example.ideedapp.Adapter.TagsAdapter;
import com.example.ideedapp.Adapter.TaskAdapter;
import com.example.ideedapp.DAO.TagsDAO;
import com.example.ideedapp.DAO.TaskDAO;
import com.example.ideedapp.DataBase.TagsDataBase;
import com.example.ideedapp.entities.Tags;
import com.example.ideedapp.entities.Tasks;

import java.util.ArrayList;
import java.util.List;

public class CreateTasksTagsLists extends AppCompatActivity implements AdapterListener{


    // var
    List<Tags> tags = new ArrayList<>();
    private TagsDataBase tagsDataBase;
    private TagsDAO tagsDAO;
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

        tagsDataBase = TagsDataBase.getInstance(this);
        tagsDAO=tagsDataBase.getDao();
        //binding
        tagRecycler = findViewById(R.id.tagRecycler);






        ////recyclerViw Config
        tagRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        tagRecycler.setAdapter(new TagsAdapter(this,tags,this));



    }


    @Override
    public void OnClickTag(Tags tags) {
        Intent intent = new Intent(this,CreateTask.class);
        intent.putExtra("modelTags",tags);
        startActivity(intent);


    }
}
