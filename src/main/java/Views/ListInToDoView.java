package Views;

import Models.ToDoListModel;
import ObserverInterfaces.ToDoListOpenObservable;
import ObserverInterfaces.ToDoListOpenObserver;
import ObserverInterfaces.ToDoListRemoveObservable;
import ObserverInterfaces.ToDoListRemoveObserver;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *  This class handles the functionality of the ListInToDoView
 *  Used by: ToDoViewModel
 *
 *  Author: Julia
 */

public class ListInToDoView extends AnchorPane implements ToDoListRemoveObservable, ToDoListOpenObservable {

    @FXML private Text nameText;
    @FXML private Text numberOfChecklistsText;
    private final ToDoListModel toDoList;

    private final List<ToDoListRemoveObserver> observerArrayList = new ArrayList<>();
    private final List<ToDoListOpenObserver> openObserverArrayList = new ArrayList<>();

    /**
     * This method...
     *
     * @param toDoListModel the todoList the ListInToDoView is connected to
     */

    public ListInToDoView(ToDoListModel toDoListModel){
        final FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml_files/listInToDo.fxml"));
        fxmlLoader.setController(this);
        fxmlLoader.setRoot(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        nameText.setText(toDoListModel.getName());
        numberOfChecklistsText.setText(toDoListModel.getNOfCheckboxesClicked() + "/" + toDoListModel.getNOfChecklists());
        toDoList = toDoListModel;
    }

    /**
     * This method calls on another method, which notify observers, when someone clicks on the delete button
     */

    @FXML
    private void onDeleteButtonClick(){
        notifyObservers(); }

    /**
     * This method calls on another method, which notify observers, when someone clicks on the listInToDo
     */

    @FXML
    private void onTodoListClicked(){
        notifyOpenObservers();}


    /**
     * This method adds an observer to the arrayList with all the remove observers
     *
     * @param o is a TodoListRemoveObserver
     */
    @Override
    public void add(final ToDoListRemoveObserver o) {
        observerArrayList.add(o);
    }

    /**
     * This method adds an observer to the arrayList with all the open observers
     *
     * @param o is a ToDoListOpenObserver
     */

    @Override
    public void addOpen(final ToDoListOpenObserver o) {
        openObserverArrayList.add(o);
    }

    /**
     * The method that notifies the openObservers that an update has happened and needs to be taken care of
     */

    @Override
    public void notifyOpenObservers() {
        for (final ToDoListOpenObserver o: openObserverArrayList) {
            o.updateOpen(toDoList.getName(), toDoList.getDescription(), toDoList.getTimeAndDeadline(), toDoList.getChecklists(),
                    toDoList.getCheckboxes());
        }
    }

    /**
     * The method that notifies the removeObservers that an update has happened and needs to be taken care of
     */

    @Override
    public void notifyObservers() {
        for (final ToDoListRemoveObserver o: observerArrayList) {
            o.update(toDoList.getName(),this);
        }
    }
}
