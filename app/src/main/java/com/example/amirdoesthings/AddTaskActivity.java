package com.example.amirdoesthings;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        editText = findViewById(R.id.editTitle);
        btn = findViewById(R.id.addTaskBtn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        MainActivity.arrayAdapter.add(editText.getText().toString());
        StorageHelper.writeData(MainActivity.tasks,this);
        Toast.makeText(this, "Task successfully added!", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
