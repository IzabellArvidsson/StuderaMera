package ViewControllers;

import Factory.IPane;
import ViewModels.ToDoListHandler;
import ViewModels.ToDoViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;

public class TodoController implements IPane {

    @FXML private AnchorPane addToList;
    @FXML private FlowPane toDoListFlowPane;
    @FXML private TextField nameTextField;
    @FXML private FlowPane checklistFlowPane;
    @FXML private ScrollPane checklistScrollPane;

    PaneController paneController = new PaneController();

    private ArrayList<TextField> nChecklist = new ArrayList<>();

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

    public void openAddToCalendar(){
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
        String id = "toDo";
        ToDoViewModel.addToDoLists(nameTextField.getText(), nChecklist, toDoListFlowPane, id);
        closeAddToCalendar();
        nChecklist.clear();
        nameTextField.clear();
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

    /**
     *
     *
     * @param paneController
     */

    @Override
    public void initPane(PaneController paneController) {
        this.paneController = paneController;
        ToDoListHandler.writeToDoList(toDoListFlowPane);
    }
}
