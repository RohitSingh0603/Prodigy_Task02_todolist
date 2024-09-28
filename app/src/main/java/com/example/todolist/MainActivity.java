package com.example.todolist;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextTask;
    private ArrayList<String> taskList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTask = findViewById(R.id.editTextTask);
        Button buttonAdd = findViewById(R.id.buttonAdd);
        ListView listViewTasks = findViewById(R.id.listViewTasks);

        taskList = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listViewTasks.setAdapter(adapter);

        buttonAdd.setOnClickListener(v -> {
            String task = editTextTask.getText().toString();
            if (!task.isEmpty()) {
                taskList.add(task);
                adapter.notifyDataSetChanged();
                editTextTask.setText("");
            }
        });

        listViewTasks.setOnItemLongClickListener((parent, view, position, id) -> {
            taskList.remove(position);
            adapter.notifyDataSetChanged();
            return true;
        });
    }
}