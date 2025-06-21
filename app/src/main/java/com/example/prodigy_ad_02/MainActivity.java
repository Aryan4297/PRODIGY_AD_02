package com.example.prodigy_ad_02;


import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ComponentActivity {

    private TodoViewModel viewModel;
    private TodoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(TodoViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        adapter = new TodoAdapter(viewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        EditText inputTask = findViewById(R.id.inputTask);
        Button addButton = findViewById(R.id.addButton);

        addButton.setOnClickListener(v -> {
            String task = inputTask.getText().toString().trim();
            if (!task.isEmpty()) {
                viewModel.addTask(task);
                inputTask.setText("");
            }
        });

        viewModel.getTasks().observe(this, tasks -> adapter.notifyDataSetChanged());
    }
}