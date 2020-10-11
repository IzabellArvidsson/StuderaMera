package ViewModels;

import Models.ToDoLists;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;

public class ToDoListHandler {

    /**
     * This method saves all the toDoLists in the arrayList that was sent in the parameter to a .ser file
     *
     * @param toDoLists a list with all the toDoLists which will be saved
     */

    public static void saveToDoList(ArrayList<ToDoLists> toDoLists) {
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
     */

    public static void writeToDoList(FlowPane toDoListFlowPane) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.ToDoLists.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<ToDoLists> toDoLists = (ArrayList<ToDoLists>) in.readObject();
            String id = "handler";
            for (int i = 0; i < toDoLists.size(); i++){
                String name = toDoLists.get(i).getName();
                ArrayList<TextField> nChecklist = toDoLists.get(i).getChecklists();
                ToDoViewModel.addToDoLists(name, nChecklist, toDoListFlowPane, id);
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
