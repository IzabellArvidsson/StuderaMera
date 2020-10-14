package Models;

import ViewModels.ToDoViewModel;
import javafx.scene.layout.FlowPane;

import java.io.*;
import java.util.ArrayList;

public class CalendarHandlerModel {

    public void saveEvent (ArrayList<CalendarEventModel> calendarEventModel, String fileName){
        try{
            FileOutputStream fileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(calendarEventModel);
            out.close();
            fileOut.close();
            System.out.println("Sparat listan Bitches!!");
        }catch (IOException i){
            i.printStackTrace();
        }
    }

    public static void writeToDoList(FlowPane daysFlowPane) {
        try {
            FileInputStream fileIn = new FileInputStream("Models.ToDoLists.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            ArrayList<CalendarEventModel> calendarEventModelArrayList = (ArrayList<CalendarEventModel>) in.readObject();


            //TODO: Write a method so the events shows!


            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Models.ToDoLists class not found");
            c.printStackTrace();
        }
    }



    //public void

}
