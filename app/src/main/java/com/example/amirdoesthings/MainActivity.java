package com.example.amirdoesthings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private EditText editText;
    private Button btn;
    public static ListView tasksList;
    private FloatingActionButton fab;

    public static ArrayList<String> tasks;
    public static ArrayAdapter<String> arrayAdapter; //a tool for android studio to fill in lists

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasksList = findViewById(R.id.taskList);
        fab = findViewById(R.id.floatingActionButton);

        tasks = StorageHelper.readData(this);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tasks); //converts ArrayList into a View object
        tasksList.setAdapter(arrayAdapter);

        tasksList.setOnItemClickListener(this); //for arrayAdapter, to do sth when item is clicked
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddTaskActivity();
            }
        });
    }

    private void openAddTaskActivity() {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }


    //delete item when clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tasks.remove(position);
        arrayAdapter.notifyDataSetChanged(); //refresh the data in the arrayadapter
        Toast.makeText(this, "Task successfully deleted!", Toast.LENGTH_SHORT).show();
    }
}
