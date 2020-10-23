package ViewModels.TodoViewModels;
import java.util.ArrayList;
import java.util.List;

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

    public final List<String> checkListEmpty(final List<String> checklist){
        final List<String> noEmptyChecklist = new ArrayList<>();
        for (final String string: checklist) {
            if(!("".equals(string))){
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

    public final List<String> isCheckboxClicked(final List<Boolean> nCheckboxes){
        final List<String> checkboxArraylist = new ArrayList<>();
        for (final Boolean bool: nCheckboxes) {
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
