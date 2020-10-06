import ObserverInterfaces.ToDoObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class TodoController {

    @FXML private AnchorPane addToList;
    @FXML private FlowPane toDoListFlowPane;
    @FXML private TextField nameTextField;
    @FXML private FlowPane checklistFlowPane;
    @FXML private ScrollPane checklistScrollPane;


    private ArrayList<String> nChecklist = new ArrayList<>();

    public void onClickBackToOverview(MouseEvent mouseEvent) throws IOException {
        Parent backToOverviewParent = FXMLLoader.load(getClass().getResource("/fxml_files/PlanOverview.fxml"));
        Scene backToOverviewScene = new Scene(backToOverviewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(backToOverviewScene);
        window.show();
    }

    public void onClickGoToHelp (MouseEvent mouseEvent) throws IOException {
        Parent toDoParent = FXMLLoader.load(getClass().getResource("/fxml_files/HelpView.fxml"));
        Scene toDoScene = new Scene(toDoParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(toDoScene);
        window.show();
    }

    public void openAddToCalendar(){
        addToList.toFront();
        addTextField();
        addTextField();
        addTextField();
    }

    public void closeAddToCalendar(){
        addToList.toBack();
    }

    @FXML
    private void onClickStuderaMera (MouseEvent mouseEvent) throws IOException {
        Parent toDoParent = FXMLLoader.load(getClass().getResource("/fxml_files/firstSideView.fxml"));
        Scene toDoScene = new Scene(toDoParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(toDoScene);
        window.show();
    }

    @FXML
    private void onClickSaveToDoTask(){
       // writingSavedToDoLists();
        ToDoViewModel.addToDoLists(nameTextField.getText(), nChecklist, toDoListFlowPane);
        closeAddToCalendar();
        nChecklist.clear();
        nameTextField.clear();
    }

    @FXML
    private void addTextField(){
        TextField textField = new TextField();
        checklistFlowPane.getChildren().add(textField);
        checklistFlowPane.setVgap(7);
        textField.setPrefSize(229,27);
        checklistScrollPane.vvalueProperty().bind(checklistFlowPane.heightProperty());
        nChecklist.add(textField.toString());
    }


    @FXML
    public void writingSavedToDoLists(){
        ToDoViewModel.writeToDoList(toDoListFlowPane);
    }

}
