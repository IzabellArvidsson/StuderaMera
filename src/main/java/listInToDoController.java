import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

public class listInToDoController extends AnchorPane {

    @FXML Text nameText;
    @FXML Text numberOfChecklistsText;


    public listInToDoController(ToDoLists toDoLists){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/listInToDo.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        nameText.setText(toDoLists.getName());
        numberOfChecklistsText.setText("0/" + toDoLists.getChecklists());
    }


}
