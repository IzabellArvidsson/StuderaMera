package ViewModels.TodoViewModels;

import Models.ToDoListModel;
import Views.TodoListView;
import Views.ListInToDoView;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class saves and writes out todoLists and creates new ones
 *
 * Uses: ToDoListModel and ListInToDoView
 * Used by: TodoListView
 * Author: Julia
 */

public class ToDoViewModel  {

    public List<ToDoListModel> allToDoLists = new ArrayList<>();

    /**
     * This method creates a toDoList and a ListInToDoView and adds it to a Pane
     *
     * @param nameTextField a string with a name for the toDoList
     * @param description a string with a description for the toDoList
     * @param checklist an arrayList with strings for the toDoList regarding the checklists
     * @param checkboxes an arrayList with strings for the toDoList regarding the checkboxes
     * @param string an arrayList with strings, with the time and deadline for the toDoList
     * @param toDoListFlowPane the FlowPane where the list will appear
     * @param todoListView the controller for the fxml-file where the list will appear
     */

     public final void addToDoListsToPane(final String nameTextField, final String description, final List<String> checklist, final List<String>
             checkboxes, final List<String> string, final FlowPane toDoListFlowPane, final TodoListView todoListView){
         final ToDoListModel toDoListModel = new ToDoListModel(nameTextField, description, string, checklist, checkboxes);

        addToDoListToArrayList(toDoListModel);
        final ListInToDoView listInToDoView = new ListInToDoView(toDoListModel);
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
     */

    public void updateToDoInList(final String nameTextField, final String description, final List<String> checklist, final List<String>
            nCheckboxes, final List<String> string){
         for(final ToDoListModel toDoListModelInList : allToDoLists){
             if(toDoListModelInList.getName().equals(nameTextField)){
                 toDoListModelInList.setName(nameTextField);
                 toDoListModelInList.setDescription(description);
                 toDoListModelInList.setCheckboxes(nCheckboxes);
                 toDoListModelInList.setChecklists(checklist);
                 toDoListModelInList.setTimeAndDeadline(string);
                 saveToDoList(allToDoLists);
             }
         }
    }

    /**
     * This method adds a toDoList to an arrayList
     *
     * @param toDoList the toDoList which will be add to the arrayList
     */

    private void addToDoListToArrayList(final ToDoListModel toDoList){
        allToDoLists.add(toDoList);
    }

    /**
     * This method removes a todo-list from the public arrayList with all the todo-lists
     *
     * @param name the name of the todo-list
     */

    public void removeToDoListFromArrayList(final String name){
        allToDoLists.removeIf(toDoListModel -> toDoListModel.getName().equals(name));
    }

    /**
     * This method checks if there are any duplicates of a list and removes them if that is the case
     */

    public void removeDoubleLists(){
        for (int j = 0; j<allToDoLists.size(); j++){
            for (int i=j+1; i<allToDoLists.size(); i++){
                if(allToDoLists.get(j).getName().equals(allToDoLists.get(i).getName())){
                    allToDoLists.remove(allToDoLists.get(i));
                }
            }
        }
        saveToDoList(allToDoLists);
    }


    /**
     * This method saves all the toDoLists in the arrayList that was sent in the parameter to a .ser file
     *
     * @param toDoLists a list with all the toDoLists which will be saved
     */

    public void saveToDoList(final List<ToDoListModel> toDoLists) {
        try {
            final FileOutputStream fileOut = new FileOutputStream("Models.ToDoLists.ser");
            final ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toDoLists);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            System.out.println("Exception found");
        }
    }

    /**
     * This method reads from the .ser file and writes out the toDoLists on the flowPane given in the parameter
     *
     * @param toDoListFlowPane the FlowPane which the toDoList will be added on
     * @param todoListView the controller class to the fxml-file
     */

    public void writeToDoList(final FlowPane toDoListFlowPane, final TodoListView todoListView) {
        try {
            final FileInputStream fileIn = new FileInputStream("Models.ToDoLists.ser");
            final ObjectInputStream in = new ObjectInputStream(fileIn);
            final ArrayList<ToDoListModel> toDoLists = (ArrayList<ToDoListModel>) in.readObject();
            for (final ToDoListModel toDoList : toDoLists) {
                final String name = toDoList.getName();
                final String description = toDoList.getDescription();
                final List<String> nChecklist = toDoList.getChecklists();
                final List<String> nCheckboxes = toDoList.getCheckboxes();
                final List<String> timeAndDeadline = toDoList.getTimeAndDeadline();
                addToDoListsToPane(name, description, nChecklist, nCheckboxes, timeAndDeadline, toDoListFlowPane, todoListView);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            System.out.println("Exception found");
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }


}