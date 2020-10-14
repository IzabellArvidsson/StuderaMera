package ViewModels;

import Models.ToDoLists;
import ViewControllers.TodoController;
import ViewControllers.listInToDoController;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;


public class ToDoViewModel  {

    public ArrayList<ToDoLists> allToDoLists = new ArrayList<>();

     public void addToDoLists(String nameTextField, String description, ArrayList<TextField> checklist, ArrayList<String>
             string, FlowPane toDoListFlowPane, String id, String id2, TodoController todoController){
         ToDoLists toDoLists = new ToDoLists(nameTextField, description, string);

        if(id.equals("handler")){
            toDoLists.setChecklists(checklist);
            if(id2.equals("yes")){
                addToDoList(toDoLists);
            }
        }
        else{
            toDoLists.setChecklists(checkListEmpty(checklist));
            addToDoList(toDoLists);
        }
        listInToDoController listInToDoController = new listInToDoController(toDoLists);
        listInToDoController.add(todoController);
        listInToDoController.addOpen(todoController);
        toDoListFlowPane.getChildren().add(listInToDoController);
        saveToDoList(allToDoLists);
    }
    
    private ArrayList<String> checkListEmpty(ArrayList<TextField> checklist){
        ArrayList<String> noEmptyChecklist = new ArrayList<>();
        for (TextField textField: checklist) {
            if(!textField.getText().equals("")){
                noEmptyChecklist.add(textField.getText());
            }
        }
        return noEmptyChecklist;
    }

    private void addToDoList(ToDoLists toDoLists){
        allToDoLists.add(toDoLists);
    }

    public boolean isTextFieldValid(String deadline){
        String onlyDigits = deadline.replaceAll("[^0-9]+", "");
        if (onlyDigits.length()==2){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * This method saves all the toDoLists in the arrayList that was sent in the parameter to a .ser file
     *
     * @param toDoLists a list with all the toDoLists which will be saved
     */

    public void saveToDoList(ArrayList<ToDoLists> toDoLists) {
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
     * @param todoController
     */

    public void writeToDoList(FlowPane toDoListFlowPane, String yesOrNo, TodoController todoController) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.ToDoLists.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<ToDoLists> toDoLists = (ArrayList<ToDoLists>) in.readObject();
            String id = "handler";
            for (int i = 0; i < toDoLists.size(); i++){
                String name = toDoLists.get(i).getName();
                String description = toDoLists.get(i).getDescription();
                ArrayList<TextField> nChecklist = toDoLists.get(i).getChecklists();
                ArrayList<String> timeAndDeadline = toDoLists.get(i).getTimeAndDeadline();
                addToDoLists(name, description, nChecklist, timeAndDeadline, toDoListFlowPane, id, yesOrNo, todoController);
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