package ViewModels;

import Models.ToDoListModel;
import Views.TodoListView;
import Views.ListInToDoView;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;


public class ToDoViewModel  {

    public ArrayList<ToDoListModel> allToDoLists = new ArrayList<>();

    /**
     * This method creates a toDoList and a ListInToDoView and adds it to a Pane
     *
     * @param nameTextField a string with a name for the toDoList
     * @param description a string with a description for the toDoList
     * @param checklist an arrayList with textFields for the toDoList
     * @param string an arrayList with strings, with the time and deadline for the toDoList
     * @param toDoListFlowPane the FlowPane where the list will appear
     * @param id an indicator which indicates which method called up on this method
     * @param todoListView
     */

     public void addToDoListsToPane(String nameTextField, String description, ArrayList<TextField> checklist, ArrayList<CheckBox>
             nCheckboxes, ArrayList<String> string, FlowPane toDoListFlowPane, String id, TodoListView todoListView){
         ToDoListModel toDoListModel = new ToDoListModel(nameTextField, description, string);

        if(id.equals("handler")){
            toDoListModel.setChecklists(checklist);
            toDoListModel.setCheckboxes(nCheckboxes);
        }
        else{
            toDoListModel.setChecklists(checkListEmpty(checklist));
            toDoListModel.setCheckboxes(isCheckboxClicked(nCheckboxes));
        }
        addToDoListToArrayList(toDoListModel);
        ListInToDoView listInToDoView = new ListInToDoView(toDoListModel);
        listInToDoView.add(todoListView);
        listInToDoView.addOpen(todoListView);
        toDoListFlowPane.getChildren().add(listInToDoView);
        saveToDoList(allToDoLists);
    }



    public void updateToDoInList(String nameTextField, String description, ArrayList<TextField> checklist, ArrayList<CheckBox>
            nCheckboxes, ArrayList<String> string, ToDoListModel toDoListModel){
         for(ToDoListModel toDoListModelInList : allToDoLists){
             if(toDoListModelInList.equals(toDoListModel)){
                 toDoListModelInList.setName(nameTextField);
                 toDoListModelInList.setDescription(description);
                 toDoListModelInList.setCheckboxes(isCheckboxClicked(nCheckboxes));
                 toDoListModelInList.setChecklists(checkListEmpty(checklist));
                 toDoListModelInList.setTimeAndDeadline(string);
                 saveToDoList(allToDoLists);
             }
         }
    }

    /**
     * This method checks if a text field is empty and removes it if that is the case
     *
     * @param checklist an arrayList with all the textFields that will be check if they are empty or not.
     * @return ArrayList with textFields that is not empty
     */
    
    private ArrayList<String> checkListEmpty(ArrayList<TextField> checklist){
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

    private ArrayList<String> isCheckboxClicked(ArrayList<CheckBox> nCheckboxes){
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

    /**
     * This method adds a toDoList to an arrayList
     *
     * @param toDoList the toDoList which will be add to the arrayList
     */

    private void addToDoListToArrayList(ToDoListModel toDoList){
        allToDoLists.add(toDoList);
    }

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
     * This method saves all the toDoLists in the arrayList that was sent in the parameter to a .ser file
     *
     * @param toDoLists a list with all the toDoLists which will be saved
     */

    public void saveToDoList(ArrayList<ToDoListModel> toDoLists) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Models.ToDoLists.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toDoLists);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * This method reads from the .ser file and writes out the toDoLists on the flowPane given in the parameter
     *
     * @param toDoListFlowPane the FlowPane which the toDoList will be added on
     * @param todoListView
     */

    public void writeToDoList(FlowPane toDoListFlowPane, TodoListView todoListView) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.ToDoLists.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<ToDoListModel> toDoLists = (ArrayList<ToDoListModel>) in.readObject();
            String id = "handler";
            for (ToDoListModel toDoList : toDoLists) {
                String name = toDoList.getName();
                String description = toDoList.getDescription();
                ArrayList<TextField> nChecklist = toDoList.getChecklists();
                ArrayList<CheckBox> nCheckboxes = toDoList.getCheckboxes();
                ArrayList<String> timeAndDeadline = toDoList.getTimeAndDeadline();
                addToDoListsToPane(name, description, nChecklist, nCheckboxes, timeAndDeadline, toDoListFlowPane, id, todoListView);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Models.ToDoLists class not found");
            c.printStackTrace();
        }
    }


}