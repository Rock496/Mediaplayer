
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class sccontrol implements Initializable {
    @FXML private Pane titlepane;

     @FXML private ImageView btmin,btclose,btmax;
     private double x,y;
     
     @FXML MediaView mv;

     @FXML 
     private Button play,pause,reset;
     private File file;
     private Media media;
     private MediaPlayer mp;
     
    

     public void init(Stage st) {
        titlepane.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        titlepane.setOnMouseDragged(mouseEvent -> {
            st.setX(mouseEvent.getScreenX()-x);
            st.setY(mouseEvent.getScreenY()-y);
        });

        btclose.setOnMouseClicked(mouseEvent -> st.close());
        btmin.setOnMouseClicked(mouseEvent -> st.setIconified(true));
        btmax.setOnMouseClicked(mouseEvent -> st.setFullScreen(true));
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'initialize'");
        file=new File("C:\\Users\\Rehan\\Documents\\ved.mp4");
        media =new Media(file.toURI().toString());
        mp=new MediaPlayer(media);

        
    }

    @FXML
    void playmd(ActionEvent event) {
         mp.play();
    }

    @FXML
    void pausemd(ActionEvent event) {
        mp.pause();
    }

    @FXML
    void resetmd(ActionEvent event) {
      //  mp.set();
    }


}

