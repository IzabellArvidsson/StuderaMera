package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

import java.io.IOException;

public class listInToDoController extends Node {


    public listInToDoController(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/listInToDo.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Node getStyleableNode() {
        return null;
    }
}
