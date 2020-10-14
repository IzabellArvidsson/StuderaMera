package Models;

import javafx.scene.control.TextField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDoLists implements Serializable {

    String name;
    String description;
    private ArrayList checklists;
    private ArrayList timeAndDeadline;


    public ToDoLists(String name, String description, ArrayList timeAndDeadline){
        this.name = name;
        this.description = description;
        this.timeAndDeadline = timeAndDeadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList getChecklists() { return checklists; }

    public ArrayList getTimeAndDeadline() { return timeAndDeadline; }

    public void setChecklists(ArrayList checklists) { this.checklists = checklists; }

    public int getNOfChecklists(){
        return checklists.size();
    }

}
