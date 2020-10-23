package Views;

import Factory.IOnClickPane;
import Factory.OnClickPaneController;
import ObserverInterfaces.ToDoListOpenObserver;
import ObserverInterfaces.ToDoListRemoveObservable;
import ObserverInterfaces.ToDoListRemoveObserver;
import ViewModels.TodoViewModels.CheckTodoValid;
import ViewModels.TodoViewModels.ToDoViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import java.util.ArrayList;

/**
 * This class updates the todoView for the user
 *
 * Uses: CheckTodoValid and ToDoViewModel
 *
 * Author: Julia
 */

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
    @FXML private Button addButton;
    @FXML private Button saveButton;

    private OnClickPaneController onClickPaneController = new OnClickPaneController();

    private final ArrayList<String> timeAndDeadlineStringList = new ArrayList<>();
    private final ArrayList<TextField> nChecklist = new ArrayList<>();
    private final ArrayList<CheckBox> nCheckboxes = new ArrayList<>();
    private final ToDoViewModel toDoViewModel = new ToDoViewModel();
    private final CheckTodoValid checkTodoValid = new CheckTodoValid();

    /**
     * This method takes the program from the ToDoPane to the "Help"-Pane
     */

    public void onClickGoToHelp (){
        onClickPaneController.showHelpPane();
    }

    /**
     * This method brings forward the "addToDoList"-pane and calls on a method which creates text fields
     */

    public void openAddToDoList(){
        clearPane();
        showAddButton();
        addToList.toFront();
        addTextFieldAndCheckbox();
        addTextFieldAndCheckbox();
        addTextFieldAndCheckbox();
    }

    /**
     * This method brings back the "addToDoList"-pane so that the toDoPane is in view
     */

    public void closeAddToDoList(){
        addToList.toBack();
    }

    /**
     * This method takes the program from the ToDoPane to the "FirstView"-Pane
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
    private void onClickAddToDoTask(){
        isTextFieldValid(deadline1);
        isTextFieldValid(deadline2);
        isTextFieldValid(timeItTakes1);
        isTextFieldValid(timeItTakes2);

        if (isTextFieldValid(deadline1) && isTextFieldValid(deadline2) && isTextFieldValid(timeItTakes1) && isTextFieldValid(timeItTakes2)){

            timeAndDeadlineStringList.add(deadline1.getText());
            timeAndDeadlineStringList.add(deadline2.getText());
            timeAndDeadlineStringList.add(timeItTakes1.getText());
            timeAndDeadlineStringList.add(timeItTakes2.getText());

            toDoViewModel.addToDoListsToPane(nameTextField.getText(), descriptionTextArea.getText(), checklistsToString(nChecklist),
                    checkboxesToString(nCheckboxes), timeAndDeadlineStringList, toDoListFlowPane,this);
            closeAddToDoList();
            checklistFlowPane.getChildren().clear();
        }
    }

    /**
     *  This method calls on other methods
     */

    @FXML
    private void onClickSaveToDoTask() {
        toDoViewModel.removeDoubleLists();
        timeAndDeadlineStringList.add(deadline1.getText());
        timeAndDeadlineStringList.add(deadline2.getText());
        timeAndDeadlineStringList.add(timeItTakes1.getText());
        timeAndDeadlineStringList.add(timeItTakes2.getText());

        toDoViewModel.updateToDoInList(nameTextField.getText(), descriptionTextArea.getText(), checklistsToString(nChecklist),
                checkboxesToString(nCheckboxes), timeAndDeadlineStringList);
        toDoListFlowPane.getChildren().clear();
        toDoViewModel.writeToDoList(toDoListFlowPane, this);
        closeAddToDoList();
        timeAndDeadlineStringList.clear();
    }

    /**
     * This method converts an arrayList with textField to an arrayList with strings
     *
     * @param nChecklist a list with the checklist that will be converted
     * @return an arrayList with no empty fields
     */

    private ArrayList<String> checklistsToString(ArrayList<TextField> nChecklist){
        ArrayList<String> checklistsString = new ArrayList<>();
        for (TextField textField: nChecklist){
            checklistsString.add(textField.getText());
        }
        return checkTodoValid.checkListEmpty(checklistsString);
    }

    /**
     * This method converts an arrayList with checkboxes to an arrayList with string
     *
     * @param nCheckboxes a list with the checkboxes that will be converted
     * @return an arrayList with the status of the checkboxes
     */

    private ArrayList<String> checkboxesToString(ArrayList<CheckBox> nCheckboxes){
        ArrayList<Boolean> checkboxesBool = new ArrayList<>();
        for (CheckBox checkBox: nCheckboxes){
            checkboxesBool.add(checkBox.isSelected());
        }
        return checkTodoValid.isCheckboxClicked(checkboxesBool);
    }

    /**
     * This method checks if a text field is valid or not
     *
     * @param textField the text field which will be tested
     * @return the return value is a boolean which indicates if the text field is valid or not.
     */

    private boolean isTextFieldValid(TextField textField){
        String onlyDigits = textField.getText().replaceAll("[^0-9]+", "");
        if (onlyDigits.length()==2){
            textField.setStyle(" -fx-border-color: white;");
            return true;
        }
        else {
            textField.setStyle(" -fx-border-color: RED;");
            return false;
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
        checklistFlowPane.getChildren().clear();
    }

    /**
     * This method shows the saveButton
     */

    private void showSaveButton(){
        addButton.setVisible(false);
        saveButton.setVisible(true);
    }

    /**
     * This method shows the addButton
     */

    private void showAddButton(){
        addButton.setVisible(true);
        saveButton.setVisible(false);
    }



    /**
     * This method sets all the textFields and checkboxes with there values from the list
     *
     * @param checklists the arrayList with the checklist that will be set
     * @param checkboxes the arrayList with the checkboxes that will be set
     */

    private void setTextFieldsAndCheckboxes (ArrayList<String> checklists, ArrayList<String>  checkboxes){
        for (int i=0; i < checklists.size(); i++){
            TextField textField = new TextField();
            CheckBox checkBox = new CheckBox();
            checklistFlowPane.getChildren().add(checkBox);
            checklistFlowPane.getChildren().add(textField);
            checklistFlowPane.setVgap(7);
            checklistFlowPane.setHgap(9);
            textField.setPrefSize(200,27);
            textField.setText(checklists.get(i));
            nChecklist.add(textField);
            nCheckboxes.add(checkBox);
            if (checkboxes.get(i).equals("clickOn")){
                checkBox.setSelected(true);
            }
        }
    }

    /**
     * This method opens up a ToDoList
     *
     * @param name the name of the List
     * @param description the description of the list
     * @param timeAndDeadline the arrayList with the timeline and deadline for the list
     * @param checklists the arrayList with the checklists of the list
     * @param checkboxes the arrayList with the checkboxes of the list
     */

    @FXML
    private void openToDoList(String name, String description, ArrayList<String > timeAndDeadline, ArrayList<String> checklists,
                              ArrayList<String> checkboxes){
        showSaveButton();
        clearPane();
        addToList.toFront();
        nameTextField.setText(name);
        descriptionTextArea.setText(description);
        setTextFieldsAndCheckboxes(checklists, checkboxes);

        deadline1.setText(timeAndDeadline.get(0));
        deadline2.setText(timeAndDeadline.get(1));
        timeItTakes1.setText(timeAndDeadline.get(2));
        timeItTakes2.setText(timeAndDeadline.get(3));
    }

    /**
     * The method for the factory design pattern
     *
     * @param onClickPaneController Initializes the paneController
     */

    @Override
    public void initPane(OnClickPaneController onClickPaneController) {
        this.onClickPaneController = onClickPaneController;
        toDoViewModel.writeToDoList(toDoListFlowPane, this);
        toDoViewModel.removeDoubleLists();
        toDoListFlowPane.getChildren().clear();
        toDoViewModel.writeToDoList(toDoListFlowPane, this);
    }

    /**
     * This method updates the view that a list shall be removed
     *
     * @param name the name of the toDoList
     * @param o the observable of the list
     */

    @Override
    public void update(String name, ToDoListRemoveObservable o) {
        toDoListFlowPane.getChildren().remove(o);
        toDoViewModel.removeToDoListFromArrayList(name);
        toDoViewModel.saveToDoList(toDoViewModel.allToDoLists);
    }

    /**
     * This method updates the view that the information about a toDoLit shall be shown
     *
     * @param name the name of the list
     * @param description the description of the list
     * @param timeAndDeadline the arrayList with the values for the timeline and deadline
     * @param checklists the arrayList with the checklists
     * @param checkboxes the arrayList with the checkboxes
     */

    @Override
    public void updateOpen(String name, String description, ArrayList<String > timeAndDeadline, ArrayList<String> checklists,
                           ArrayList<String>  checkboxes) {
        openToDoList(name, description, timeAndDeadline, checklists, checkboxes);
    }
}
