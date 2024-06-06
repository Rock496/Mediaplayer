
import java.io.File;
//import java.net.URL;
//import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
//import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class sccontrol {
    @FXML private Pane titlepane,mediPane;

     @FXML private ImageView btmin,btclose,btmax;
     private double x,y;
     
     @FXML MediaView mv;

     @FXML 
     private Button play,pause,reset;
    // private File file;
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


   
    @FXML
    void selectfile(ActionEvent event) {
          FileChooser flc=new FileChooser();
          flc.setTitle("select");
          File selectFile=flc.showOpenDialog(null);
          if(selectFile!=null)
          {
            String uri=selectFile.toURI().toString();
            media=new Media(uri);
            mp=new MediaPlayer(media);
            mv.setMediaPlayer(mp);
           
           
            Scene sce=mv.getScene();
            mv.fitWidthProperty().bind(sce.widthProperty());
            mv.fitHeightProperty().bind(sce.heightProperty());
           
          }
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
        if(mp.getStatus()!=MediaPlayer.Status.READY){
        mp.seek(Duration.seconds(0.0));
       }
    }


}

