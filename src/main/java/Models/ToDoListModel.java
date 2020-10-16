package Models;

import Views.ListInToDoView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ToDoListModel implements Serializable {

    private String name;
    private String description;
    private ArrayList checklists;
    private ArrayList timeAndDeadline;
    private ArrayList checkboxes;


    public ToDoListModel(String name, String description, ArrayList timeAndDeadline){
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

    public ArrayList getCheckboxes() { return checkboxes; }

    public ArrayList getTimeAndDeadline() { return timeAndDeadline; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    public void setTimeAndDeadline(ArrayList timeAndDeadline) { this.timeAndDeadline = timeAndDeadline; }

    public void setChecklists(ArrayList checklists) { this.checklists = checklists; }

    public void setCheckboxes(ArrayList checkboxes) { this.checkboxes = checkboxes; }

    public int getNOfChecklists(){
        return checklists.size();
    }

    public int getNOfCheckboxesClicked(){
        int n = 0;
        for(int i = 0; i < checkboxes.size(); i++){
            if(checkboxes.get(i).equals("clickOn")){
                n++;
            }
        }
        return n;
    }


}
