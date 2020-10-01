import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class ToDoListHandler {

    private ArrayList<ToDoLists> allToDoLists = new ArrayList<>();
    private ToDoLists toDoLists;


    private void saveProducts() {
        try {
            FileOutputStream fos = new FileOutputStream(this.TodoListsFile());
            OutputStreamWriter osw = new OutputStreamWriter(fos, "ISO-8859-1");
            String line = "";
            line = this.toDoLists.getName() + "\n";
            osw.write(line);
            line = this.toDoLists.getChecklists() + "\n";
            osw.write(line);
            osw.flush();
            osw.close();;
        } catch (IOException var6) {
            var6.printStackTrace();
        }

    }
    private String courseDirectory() {
        return System.getProperty("user.home") + File.separatorChar + ".tda367";
    }

    public String StuderaMeraDirectory() {
        return this.courseDirectory() + File.separatorChar + "studeraMera";
    }

    private String TodoListsFile() {
        return this.StuderaMeraDirectory() + File.separatorChar + "toDoLists.txt";
    }
}
