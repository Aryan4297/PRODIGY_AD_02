package com.example.prodigy_ad_02;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class TodoViewModel extends ViewModel {
    private final MutableLiveData<List<String>> tasks = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<String>> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        List<String> current = tasks.getValue();
        current.add(task);
        tasks.setValue(current);
    }

    public void removeTask(int position) {
        List<String> current = tasks.getValue();
        current.remove(position);
        tasks.setValue(current);
    }
}