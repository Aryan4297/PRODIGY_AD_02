package com.example.prodigy_ad_02;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {

    private final TodoViewModel viewModel;

    public TodoAdapter(TodoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TodoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        List<String> tasks = viewModel.getTasks().getValue();
        String task = tasks.get(position);

        holder.taskText.setText(task);
        holder.deleteButton.setOnClickListener(v -> viewModel.removeTask(holder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        List<String> tasks = viewModel.getTasks().getValue();
        return tasks != null ? tasks.size() : 0;
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        TextView taskText;
        ImageButton deleteButton;

        TodoViewHolder(View itemView) {
            super(itemView);
            taskText = itemView.findViewById(R.id.taskText);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}