package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import models.ToDoLists;

import java.io.IOException;

public class TodoController {

    @FXML private AnchorPane addToList;
    @FXML private FlowPane toDoListFlowPane;
    @FXML private TextField nameTextField;

    //String name = "Handlarlista";
    int task = 3;

    public void onClickBackToOverview(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent backToOverviewParent = FXMLLoader.load(getClass().getResource("/fxml_files/PlanOverview.fxml"));
        Scene backToOverviewScene = new Scene(backToOverviewParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(backToOverviewScene);
        window.show();
    }

    public void onClickGoToHelp (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent toDoParent = FXMLLoader.load(getClass().getResource("/fxml_files/HelpView.fxml"));
        Scene toDoScene = new Scene(toDoParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(toDoScene);
        window.show();
    }

    public void openAddToCalendar(){
        addToList.toFront();
    }

    public void closeAddToCalendar(){
        addToList.toBack();
    }

    @FXML
    private void onClickStuderaMera (javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Parent toDoParent = FXMLLoader.load(getClass().getResource("/fxml_files/firstSideView.fxml"));
        Scene toDoScene = new Scene(toDoParent);

        Stage window = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
        window.setScene(toDoScene);
        window.show();
    }

    @FXML
    private void addToDoList(ActionEvent event){
        ToDoLists toDoLists = new ToDoLists(nameTextField.getText(), task);
        toDoListFlowPane.getChildren().add(new listInToDoController(toDoLists));
        closeAddToCalendar();
    }


}
