package ViewModels.TodoViewModels;

import Models.ToDoListModel;
import Views.TodoListView;
import Views.ListInToDoView;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;

/**
 * This class saves and writes out todoLists and creates new ones
 *
 * Uses: ToDoListModel and ListInToDoView
 * Used by: TodoListView
 * Author: Julia
 */

public class ToDoViewModel  {

    public ArrayList<ToDoListModel> allToDoLists = new ArrayList<>();

    /**
     * This method creates a toDoList and a ListInToDoView and adds it to a Pane
     *
     * @param nameTextField a string with a name for the toDoList
     * @param description a string with a description for the toDoList
     * @param checklist an arrayList with strings for the toDoList regarding the checklists
     * @param checkboxes an arrayList with strings for the toDoList regarding the checkboxes
     * @param string an arrayList with strings, with the time and deadline for the toDoList
     * @param toDoListFlowPane the FlowPane where the list will appear
     * @param todoListView
     */

    public void addToDoListsToPane(String nameTextField, String description, ArrayList<String> checklist, ArrayList<String>
            checkboxes, ArrayList<String> string, FlowPane toDoListFlowPane, TodoListView todoListView){
        ToDoListModel toDoListModel = new ToDoListModel(nameTextField, description, string, checklist, checkboxes);

        addToDoListToArrayList(toDoListModel);
        ListInToDoView listInToDoView = new ListInToDoView(toDoListModel);
        listInToDoView.add(todoListView);
        listInToDoView.addOpen(todoListView);
        toDoListFlowPane.getChildren().add(listInToDoView);
        saveToDoList(allToDoLists);
    }

    /**
     * This method sets the new values from the user in the toDoList
     *
     * @param nameTextField a string with a name for the toDoList
     * @param description a string with a description for the toDoList
     * @param checklist an arrayList with strings for the toDoList regarding the checklists
     * @param nCheckboxes an arrayList with strings for the toDoList regarding the checkboxes
     * @param string an arrayList with strings, with the time and deadline for the toDoList
     * @param toDoListModel the list how's values will be changed
     */

    public void updateToDoInList(String nameTextField, String description, ArrayList<String> checklist, ArrayList<String>
            nCheckboxes, ArrayList<String> string, ToDoListModel toDoListModel){
        for(ToDoListModel toDoListModelInList : allToDoLists){
            if(toDoListModelInList.equals(toDoListModel)){
                toDoListModelInList.setName(nameTextField);
                toDoListModelInList.setDescription(description);
                toDoListModelInList.setCheckboxes(nCheckboxes);
                toDoListModelInList.setChecklists(checklist);
                toDoListModelInList.setTimeAndDeadline(string);
                System.out.println(allToDoLists);
                saveToDoList(allToDoLists);
            }
        }
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
            for (ToDoListModel toDoList : toDoLists) {
                String name = toDoList.getName();
                String description = toDoList.getDescription();
                ArrayList<String> nChecklist = toDoList.getChecklists();
                ArrayList<String> nCheckboxes = toDoList.getCheckboxes();
                ArrayList<String> timeAndDeadline = toDoList.getTimeAndDeadline();
                addToDoListsToPane(name, description, nChecklist, nCheckboxes, timeAndDeadline, toDoListFlowPane, todoListView);
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