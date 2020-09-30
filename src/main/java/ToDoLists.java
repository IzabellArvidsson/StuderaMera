import java.util.ArrayList;
import java.util.List;

public class ToDoLists  {

    String name;
    String description;
    int checklists;
    String time;
    String deadline;


    public ToDoLists(String name, int checklists){
        this.name = name;
        //this.description = description;
        this.checklists = checklists;
        //this.time = time;
        //this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getChecklists() {
        return checklists;
    }

    public String getTime() {
        return time;
    }

    public String getDeadline() {
        return deadline;
    }
}
