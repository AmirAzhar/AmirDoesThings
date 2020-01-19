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

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private EditText editText;
    private Button btn;
    private ListView tasksList;
    private FloatingActionButton fab;

    private ArrayList<String> tasks;
    private ArrayAdapter<String> arrayAdapter; //a tool for android studio to fill in lists

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.addTaskText);
        btn = findViewById(R.id.addTaskButton);
        tasksList = findViewById(R.id.taskList);
        fab = findViewById(R.id.floatingActionButton);

        tasks = StorageHelper.readData(this);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,tasks); //converts ArrayList into a View object
        tasksList.setAdapter(arrayAdapter);

        btn.setOnClickListener(this);
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

    //save wtv that is typed into the editText into the Arraylist
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.addTaskButton:
                String newTask = editText.getText().toString();
                arrayAdapter.add(newTask);
                editText.setText(""); // change the edit text to empty after entering

                StorageHelper.writeData(tasks,this);

                Toast.makeText(this, "Successfully added task!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //delete item when clicked
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tasks.remove(position);
        arrayAdapter.notifyDataSetChanged(); //refereh the data in the arrayadapter
        Toast.makeText(this, "Task successfully deleted!", Toast.LENGTH_SHORT).show();
    }
}
