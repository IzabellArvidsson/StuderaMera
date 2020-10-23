package Models;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class creates a todoList with the values it got from the user
 * Used by: ToDoViewModel
 *
 * Author: Julia
 */

public class ToDoListModel implements Serializable {

    private String name;
    private String description;
    private ArrayList<String> checklists;
    private ArrayList<String> timeAndDeadline;
    private ArrayList<String> checkboxes;


    public ToDoListModel(String name, String description, ArrayList<String> timeAndDeadline, ArrayList<String> checklists,
                         ArrayList<String>  checkboxes){
        this.name = name;
        this.description = description;
        this.timeAndDeadline = timeAndDeadline;
        this.checklists = checklists;
        this.checkboxes =checkboxes;

    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getChecklists() { return checklists; }

    public ArrayList<String> getCheckboxes() { return checkboxes; }

    public ArrayList<String> getTimeAndDeadline() { return timeAndDeadline; }

    public void setName(String name) { this.name = name; }

    public void setDescription(String description) { this.description = description; }

    public void setTimeAndDeadline(ArrayList<String> timeAndDeadline) { this.timeAndDeadline = timeAndDeadline; }

    public void setChecklists(ArrayList<String> checklists) { this.checklists = checklists; }

    public void setCheckboxes(ArrayList<String> checkboxes) { this.checkboxes = checkboxes; }

    /**
     * This method return the size of the checklist
     *
     * @return the number of checklist there are
     */

    public int getNOfChecklists(){
        return checklists.size();
    }

    /**
     * This method checks which checkboxes have been clicked on
     *
     * @return the number of how many checkboxes are clicked
     */

    public int getNOfCheckboxesClicked(){
        int n = 0;
        for (Object checkbox : checkboxes) {
            if (checkbox.equals("clickOn")) {
                n++;
            }
        }
        return n;
    }


}
