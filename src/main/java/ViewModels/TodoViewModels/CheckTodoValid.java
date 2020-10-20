package ViewModels.TodoViewModels;

import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
     * This method checks if a text field is valid or not
     *
     * @param textField the text field which will be tested
     * @return the return value is a boolean which indicates if the text field is valid or not.
     */

    public boolean isTextFieldValid(TextField textField){
        String onlyDigits = textField.getText().replaceAll("[^0-9]+", "");
        if (onlyDigits.length()==2){
            textField.setStyle(" -fx-border-color: white;");
            return true;
        }
        else {
            textField.setStyle(" -fx-border-color: RED;");
            return false;
        }
    }

    /**
     * This method checks if a text field is empty and removes it if that is the case
     *
     * @param checklist an arrayList with all the textFields that will be check if they are empty or not.
     * @return ArrayList with textFields that is not empty
     */

    public ArrayList<String> checkListEmpty(ArrayList<TextField> checklist){
        ArrayList<String> noEmptyChecklist = new ArrayList<>();
        for (TextField textField: checklist) {
            if(!textField.getText().equals("")){
                noEmptyChecklist.add(textField.getText());
            }
        }
        return noEmptyChecklist;
    }

    /**
     * This method checks if the checkboxes has been clicked on
     *
     * @param nCheckboxes ArrayList with checkboxes
     * @return return an arrayList with strings
     */

    public ArrayList<String> isCheckboxClicked(ArrayList<CheckBox> nCheckboxes){
        ArrayList<String> checkboxArraylist = new ArrayList<>();
        for (CheckBox checkBox: nCheckboxes) {
            if(checkBox.isSelected()){
                checkboxArraylist.add("clickOn");
            }
            else{
                checkboxArraylist.add("notClicked");
            }
        }
        return checkboxArraylist;
    }
}
