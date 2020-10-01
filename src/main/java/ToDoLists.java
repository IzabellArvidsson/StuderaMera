import java.util.ArrayList;
import java.util.List;

public class ToDoLists  {

    String name;
    String description;
    ArrayList checklists;
    String time;
    String deadline;


    public ToDoLists(String name, ArrayList checklists){
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

    public ArrayList getChecklists() {

        return checklists;
    }

    public int getNOfChecklists(){
        return checklists.size();
    }

    public String getTime() {
        return time;
    }

    public String getDeadline() {
        return deadline;
    }
}
