package ViewModels.TodoViewModels;
import java.util.ArrayList;

/**
 *  This class checks if the lists values are valid, as well as their status
 *
 *  Used by: TodoListView
 *
 *  Author: Julia
 */
public class CheckTodoValid {


    /**
     * This method checks if a text field is empty and removes it if that is the case
     *
     * @param checklist an arrayList with all the strings that will be check if they are empty or not.
     * @return ArrayList with textFields that is not empty
     */

    public ArrayList<String> checkListEmpty(ArrayList<String> checklist){
        ArrayList<String> noEmptyChecklist = new ArrayList<>();
        for (String string: checklist) {
            if(!string.equals("")){
                noEmptyChecklist.add(string);
            }
        }
        return noEmptyChecklist;
    }

    /**
     * This method checks if the checkboxes has been clicked on
     *
     * @param nCheckboxes ArrayList with booleans
     * @return return an arrayList with strings
     */

    public ArrayList<String> isCheckboxClicked(ArrayList<Boolean> nCheckboxes){
        ArrayList<String> checkboxArraylist = new ArrayList<>();
        for (Boolean bool: nCheckboxes) {
            if(bool){
                checkboxArraylist.add("clickOn");
            }
            else{
                checkboxArraylist.add("notClicked");
            }
        }
        return checkboxArraylist;
    }
}
