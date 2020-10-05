import javafx.scene.layout.FlowPane;
import java.io.*;
import java.util.ArrayList;


public class ToDoViewModel {

    private static ArrayList<ToDoLists> allToDoLists = new ArrayList<>();

     public static void addToDoLists(String nameTextField, ArrayList<String> checklist, FlowPane toDoListFlowPane){
        ToDoLists toDoLists = new ToDoLists(nameTextField, checkListEmpty(checklist));
        toDoListFlowPane.getChildren().add(new listInToDoController(toDoLists));
        addToDoList(toDoLists);
        saveToDoList(allToDoLists);
    }
    
    private static ArrayList<String> checkListEmpty(ArrayList<String> checklist){
        ArrayList<String> noEmptyChecklist = new ArrayList<>();
        for (String string: checklist) {
            if(!string.equals("")){
                noEmptyChecklist.add(string);
            }
        }
        return noEmptyChecklist;
    }

    private static void addToDoList(ToDoLists toDoLists){
        allToDoLists.add(toDoLists);
    }










    public static void saveToDoList(ArrayList<ToDoLists> toDoLists) {
        try {
            FileOutputStream fileOut = new FileOutputStream("ToDoLists.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(toDoLists);
            out.close();
            fileOut.close();
            System.out.print("Serialized data is saved in ToDoLists.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void writeToDoList(FlowPane toDoListFlowPane) {
        try {
            FileInputStream fileIn = new FileInputStream("ToDoLists.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<ToDoLists> toDoLists = (ArrayList<ToDoLists>) in.readObject();
            for (int i = 0; i < toDoLists.size(); i++){
                String name = toDoLists.get(i).getName();
                ArrayList nChecklist = toDoLists.get(i).getChecklists();
                addToDoLists(name, nChecklist, toDoListFlowPane);
            }
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("ToDoLists class not found");
            c.printStackTrace();
        }
    }

}