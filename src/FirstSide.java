import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class FirstSide {

    @FXML private Button startstudybutton;
    @FXML private Button startplanbutton;
    @FXML private Text newuser;
    @FXML private ImageView pens;

    public FirstSide(Button startstudybutton, Button startplanbutton, Text newuser, ImageView pens) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("helloWorld.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }

        this.startstudybutton = startstudybutton;
        this.startplanbutton = startplanbutton;
        this.newuser = newuser;
        this.pens = pens;
    }

}
