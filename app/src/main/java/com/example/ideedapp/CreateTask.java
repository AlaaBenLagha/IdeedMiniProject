package com.example.ideedapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ideedapp.Adapter.TaskAdapter;
import com.example.ideedapp.DAO.TaskDAO;
import com.example.ideedapp.DataBase.TaskDataBase;
import com.example.ideedapp.entities.Tags;
import com.example.ideedapp.entities.Tasks;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CreateTask extends AppCompatActivity {

    //var
    private Tags tags;
    private Tasks tasks;
    private TaskDataBase taskDataBase;
    private TaskDAO taskDAO;
    private Calendar calendar;
    private Calendar calendarS;
    private TaskAdapter taskAdapter;



    //Widgets

    private TextView tagName;
    private TextView currentDateT;
    private TextView tvdate;

    private EditText setNote;
    private Button addTask;
     DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);



        //binding
        tagName=findViewById(R.id.Tagname);
        setNote=findViewById(R.id.setNote);
        addTask=findViewById(R.id.addTask);
        currentDateT=findViewById(R.id.currentDate);



        tvdate=findViewById(R.id.tvdate);

        //instanciation BD
        taskDataBase=TaskDataBase.getInstance(this);
        taskDAO = taskDataBase.taskDAO();

        //calendar instanciation
        calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
        currentDateT.setText(currentDate);

        //calendar Set Date
        Calendar calendarS = Calendar.getInstance();
        final int year = calendarS.get(Calendar.YEAR);
        final int month = calendarS.get(Calendar.MONTH);
        final int day = calendarS.get(Calendar.DAY_OF_MONTH);


        tvdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        CreateTask.this, android.R.style.Theme_Holo_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();


            }
        });



        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvdate.setText(date);
            }
        };

















        tags=(Tags) getIntent().getSerializableExtra("modelTags");
        tagName.setText(tags.getTagName());


        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateTask.this,TaskView.class);

                String taskName=tagName.getText().toString();
                String note=setNote.getText().toString();
                String creationDate=currentDateT.getText().toString();
                String setDate = tvdate.getText().toString();
                Tasks tasks = new Tasks(0,taskName,note,creationDate,setDate);

                taskDAO.insert(tasks);
                currentDateT.setText("");
                tagName.setText("");
                setNote.setText("");
                tvdate.setText("");

                Toast.makeText(CreateTask.this,"Inserted",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

}
