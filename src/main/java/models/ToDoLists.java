package models;

import java.util.List;

public class ToDoLists {

    String name;
    int tasks;

    public ToDoLists(String name, int tasks){
        this.name = name;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public int getTasks() {
        return tasks;
    }
}
