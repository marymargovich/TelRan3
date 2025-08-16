package telran.mvc.model.services;

import telran.mvc.model.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskModel {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        if(task == null)
            throw new IllegalArgumentException("Task content must not be NULL");
        tasks.add(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public int size(){
        return tasks.size();
    }
}
