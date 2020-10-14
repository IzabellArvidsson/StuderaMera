package ViewControllers;

import Factory.IPane;
import Models.ToDoLists;
import ObserverInterfaces.ToDoListOpenObserver;
import ObserverInterfaces.ToDoListRemoveObservable;
import ObserverInterfaces.ToDoListRemoveObserver;
import ViewModels.ToDoViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;

public class TodoController implements IPane, ToDoListRemoveObserver, ToDoListOpenObserver {

    @FXML private AnchorPane addToList;
    @FXML private FlowPane toDoListFlowPane;
    @FXML private TextField nameTextField;
    @FXML private TextField deadline1;
    @FXML private TextField deadline2;
    @FXML private TextField timeItTakes1;
    @FXML private TextField timeItTakes2;
    @FXML private TextArea descriptionTextArea;
    @FXML private FlowPane checklistFlowPane;
    @FXML private ScrollPane checklistScrollPane;


    PaneController paneController = new PaneController();

    ArrayList<String> timeAndDeadlineStringList = new ArrayList<>();
    private ArrayList<TextField> nChecklist = new ArrayList<>();
    ToDoViewModel toDoViewModel = new ToDoViewModel();


    /**
     * This method takes the program from the "ToDo"-Pane to the "Overview"-Pane
     */

    public void onClickBackToOverview() {
        paneController.showOverviewPane();
    }

    /**
     * This method takes the program from the "ToDo"-Pane to the "Help"-Pane
     */

    public void onClickGoToHelp (){
        paneController.showHelpPane();
    }

    /**
     * This method brings forward the "addToDoList"-pane and calls on a method which creates text fields
     */

    public void openAddToDoList(){
        clearPane();
        addToList.toFront();
        addTextField();
        addTextField();
        addTextField();
    }

    /**
     * This method brings back the "addToDoList"-pane so that the "toDo"-pane is in view
     */

    public void closeAddToCalendar(){
        addToList.toBack();
    }

    /**
     * This method takes the program from the "ToDo"-Pane to the "FirstView"-Pane
     */

    @FXML
    private void onClickStuderaMera () {
        paneController.showFirstViewPane();
    }

    /**
     * This method calls on a method that creates a toTo-list and then closes the "addToDo"-Pane and then clears all
     * text fields.
     */

    @FXML
    private void onClickSaveToDoTask(){
        timeAndDeadlineStringList.clear();
        String id = "toDo";
        String id2 = "yes";

        if (!toDoViewModel.isTextFieldValid(deadline1.getText())){
            deadline1.setStyle(" -fx-border-color: RED;");
        }
        if(!toDoViewModel.isTextFieldValid(deadline2.getText())){
            deadline2.setStyle(" -fx-border-color: RED;");
        }
        if(!toDoViewModel.isTextFieldValid(timeItTakes1.getText())){
            timeItTakes1.setStyle(" -fx-border-color: RED;");
        }
        if(!toDoViewModel.isTextFieldValid(timeItTakes2.getText())){
            timeItTakes2.setStyle(" -fx-border-color: RED;");
        }
        else{
            timeItTakes2.setStyle(" -fx-border-color: white;");
            timeItTakes1.setStyle(" -fx-border-color: white;");
            deadline2.setStyle(" -fx-border-color: white;");
            deadline1.setStyle(" -fx-border-color: white;");
            timeAndDeadlineStringList.add(deadline1.getText());
            timeAndDeadlineStringList.add(deadline2.getText());
            timeAndDeadlineStringList.add(timeItTakes1.getText());
            timeAndDeadlineStringList.add(timeItTakes2.getText());

            toDoViewModel.addToDoLists(nameTextField.getText(), descriptionTextArea.getText(), nChecklist, timeAndDeadlineStringList, toDoListFlowPane, id, id2,this);
            closeAddToCalendar();
        }
    }

    /**
     * This method creates a text field and adds it to a flowPane and adds it on to an arrayList of text fields
     */

    @FXML
    private void addTextField(){
        TextField textField = new TextField();
        checklistFlowPane.getChildren().add(textField);
        checklistFlowPane.setVgap(7);
        textField.setPrefSize(229,27);
        checklistScrollPane.vvalueProperty().bind(checklistFlowPane.heightProperty());
        nChecklist.add(textField);
    }

    private void clearPane(){
        nChecklist.clear();
        nameTextField.clear();
        descriptionTextArea.clear();
        deadline1.clear();
        deadline2.clear();
        timeItTakes1.clear();
        timeItTakes2.clear();
        timeAndDeadlineStringList.clear();
    }

    @FXML
    private void openToDoList(ToDoLists toDoLists){
        clearPane();
        System.out.print(toDoLists.getTimeAndDeadline());
        addToList.toFront();
        nameTextField.setText(toDoLists.getName());
        descriptionTextArea.setText(toDoLists.getDescription());
        deadline1.setText(toDoLists.getTimeAndDeadline().get(0).toString());
        deadline2.setText(toDoLists.getTimeAndDeadline().get(1).toString());
        timeItTakes1.setText(toDoLists.getTimeAndDeadline().get(2).toString());
        timeItTakes2.setText(toDoLists.getTimeAndDeadline().get(3).toString());
    }



    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
        String id = "yes";
        toDoViewModel.writeToDoList(toDoListFlowPane, id, this);
    }

    @Override
    public void update(ToDoLists toDoList, ToDoListRemoveObservable o) {
        toDoListFlowPane.getChildren().remove(o);
        toDoViewModel.allToDoLists.remove(toDoList);
        toDoViewModel.saveToDoList(toDoViewModel.allToDoLists);
    }

    @Override
    public void updateOpen(ToDoLists toDoList) {
        openToDoList(toDoList);
    }
}
