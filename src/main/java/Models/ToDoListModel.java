package Models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class creates a todoList with the values it got from the user
 * Used by: ToDoViewModel
 *
 * Author: Julia
 */

public class ToDoListModel implements Serializable {

    private String name;
    private String description;
    private List<String> checklists;
    private List<String> timeAndDeadline;
    private List<String> checkboxes;


    public ToDoListModel(final String name, final String description, final List<String> timeAndDeadline, final List<String> checklists,
                         final List<String> checkboxes){
        this.name = name;
        this.description = description;
        this.timeAndDeadline = timeAndDeadline;
        this.checklists = checklists;
        this.checkboxes =checkboxes;

    }

    public final String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getChecklists() { return checklists; }

    public List<String> getCheckboxes() { return checkboxes; }

    public List<String> getTimeAndDeadline() { return timeAndDeadline; }

    public final void setName(final String name) { this.name = name; }

    public final void setDescription(final String description) { this.description = description; }

    public final void setTimeAndDeadline(final List<String> timeAndDeadline) { this.timeAndDeadline = timeAndDeadline; }

    public final void setChecklists(final List<String> checklists) { this.checklists = checklists; }

    public final void setCheckboxes(final List<String> checkboxes) { this.checkboxes = checkboxes; }

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
        for (final Object checkbox : checkboxes) {
            if ("clickOn".equals(checkbox)) {
                n++;
            }
        }
        return n;
    }


}
