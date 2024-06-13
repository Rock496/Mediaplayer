
import java.io.File;
//import java.net.URL;
//import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.util.Duration;

public class sccontrol {

    
     
     @FXML MediaView mv;

     @FXML 
     private Button btplay,btpause,btreset;
    // private File file;
     private Media media;
     private MediaPlayer mp;
     
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
    void pausemd(MouseEvent event) {
      mp.pause();
    }

    @FXML
    void playmd(MouseEvent event) {
      mp.play();
    }

    @FXML
    void resetmd(MouseEvent event) {
        if(mp.getStatus()!=MediaPlayer.Status.READY){
            mp.seek(Duration.seconds(0.0));
    }


}

}
