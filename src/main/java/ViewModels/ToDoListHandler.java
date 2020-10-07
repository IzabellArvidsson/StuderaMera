package ViewModels;

import Models.ToDoLists;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;

public class ToDoListHandler {

    public static void saveToDoList(ArrayList<ToDoLists> toDoLists) {
        try {
            FileOutputStream fileOut = new FileOutputStream("Models.ToDoLists.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toDoLists);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in Models.ToDoLists.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void writeToDoList(FlowPane toDoListFlowPane) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.ToDoLists.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<ToDoLists> toDoLists = (ArrayList<ToDoLists>) in.readObject();
            for (int i = 0; i < toDoLists.size(); i++){
                String name = toDoLists.get(i).getName();
                ArrayList nChecklist = toDoLists.get(i).getChecklists();
                ToDoViewModel.addToDoLists(name, nChecklist, toDoListFlowPane);
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
