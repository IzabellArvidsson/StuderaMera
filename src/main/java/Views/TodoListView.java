package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import Models.ToDoListModel;
import ObserverInterfaces.ToDoListOpenObserver;
import ObserverInterfaces.ToDoListRemoveObservable;
import ObserverInterfaces.ToDoListRemoveObserver;
import ViewModels.ToDoViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;

public class TodoListView implements IOnClickPane, ToDoListRemoveObserver, ToDoListOpenObserver {

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


    OnClickPaneController onClickPaneController = new OnClickPaneController();

    ArrayList<String> timeAndDeadlineStringList = new ArrayList<>();
    private final ArrayList<TextField> nChecklist = new ArrayList<>();
    private final ArrayList<CheckBox> nCheckboxes = new ArrayList<>();
    ToDoViewModel toDoViewModel = new ToDoViewModel();


    /**
     * This method takes the program from the "ToDo"-Pane to the "Overview"-Pane
     */

    public void onClickBackToOverview() {
        onClickPaneController.showOverviewPane();
    }

    /**
     * This method takes the program from the "ToDo"-Pane to the "Help"-Pane
     */

    public void onClickGoToHelp (){
        onClickPaneController.showHelpPane();
    }

    /**
     * This method brings forward the "addToDoList"-pane and calls on a method which creates text fields
     */

    public void openAddToDoList(){
        clearPane();
        addToList.toFront();
        addTextFieldAndCheckbox();
        addTextFieldAndCheckbox();
        addTextFieldAndCheckbox();
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
        onClickPaneController.showFirstViewPane();
    }

    /**
     * This method calls on a method that creates a toTo-list and then closes the "addToDo"-Pane and then clears all
     * text fields.
     */

    @FXML
    private void onClickSaveToDoTask(){
        String id = "toDo";
        toDoViewModel.isTextFieldValid(deadline1);
        toDoViewModel.isTextFieldValid(deadline2);
        toDoViewModel.isTextFieldValid(timeItTakes1);
        toDoViewModel.isTextFieldValid(timeItTakes2);

        if (toDoViewModel.isTextFieldValid(deadline1) && toDoViewModel.isTextFieldValid(deadline2) &&
                toDoViewModel.isTextFieldValid(timeItTakes1) && toDoViewModel.isTextFieldValid(timeItTakes2)){

            timeAndDeadlineStringList.add(deadline1.getText());
            timeAndDeadlineStringList.add(deadline2.getText());
            timeAndDeadlineStringList.add(timeItTakes1.getText());
            timeAndDeadlineStringList.add(timeItTakes2.getText());

            toDoViewModel.addToDoListsToPane(nameTextField.getText(), descriptionTextArea.getText(), nChecklist,
                    nCheckboxes, timeAndDeadlineStringList, toDoListFlowPane, id,this);
            closeAddToCalendar();
            checklistFlowPane.getChildren().clear();
        }
    }

    /**
     * This method creates a text field and a checkbox and adds it to a flowPane and adds it on to an arrayList of text fields
     */

    @FXML
    private void addTextFieldAndCheckbox(){
        TextField textField = new TextField();
        CheckBox checkBox = new CheckBox();
        checklistFlowPane.getChildren().add(checkBox);
        checklistFlowPane.getChildren().add(textField);
        checklistFlowPane.setVgap(7);
        checklistFlowPane.setHgap(9);
        textField.setPrefSize(200,27);
        checklistScrollPane.vvalueProperty().bind(checklistFlowPane.heightProperty());
        nChecklist.add(textField);
        nCheckboxes.add(checkBox);
    }

    /**
     * This method clears all textFields and lists
     */

    private void clearPane(){
        nChecklist.clear();
        nCheckboxes.clear();
        nameTextField.clear();
        descriptionTextArea.clear();
        deadline1.clear();
        deadline2.clear();
        timeItTakes1.clear();
        timeItTakes2.clear();
        timeAndDeadlineStringList.clear();
        checklistFlowPane.getChildren().clear();
    }

    /**
     * This method
     *
     * @param toDoListModel
     */

    @FXML
    private void openToDoList(ToDoListModel toDoListModel){
        clearPane();
        addToList.toFront();
        nameTextField.setText(toDoListModel.getName());
        descriptionTextArea.setText(toDoListModel.getDescription());

        for (int i=0; i < toDoListModel.getChecklists().size(); i++){
            TextField textField = new TextField();
            CheckBox checkBox = new CheckBox();
            checklistFlowPane.getChildren().add(checkBox);
            checklistFlowPane.getChildren().add(textField);
            checklistFlowPane.setVgap(7);
            checklistFlowPane.setHgap(9);
            textField.setPrefSize(200,27);
            textField.setText(toDoListModel.getChecklists().get(i).toString());
            if (toDoListModel.getCheckboxes().get(i).equals("clickOn")){
                checkBox.setSelected(true);
            }
        }
        deadline1.setText(toDoListModel.getTimeAndDeadline().get(0).toString());
        deadline2.setText(toDoListModel.getTimeAndDeadline().get(1).toString());
        timeItTakes1.setText(toDoListModel.getTimeAndDeadline().get(2).toString());
        timeItTakes2.setText(toDoListModel.getTimeAndDeadline().get(3).toString());
    }

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
        toDoViewModel.writeToDoList(toDoListFlowPane, this);
    }

    @Override
    public void update(ToDoListModel toDoList, ToDoListRemoveObservable o) {
        toDoListFlowPane.getChildren().remove(o);
        toDoViewModel.allToDoLists.remove(toDoList);
        toDoViewModel.saveToDoList(toDoViewModel.allToDoLists);
    }

    @Override
    public void updateOpen(ToDoListModel toDoList) {
        openToDoList(toDoList);
    }
}
