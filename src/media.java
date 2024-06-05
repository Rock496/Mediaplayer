import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
//import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class media extends Application{
       
    public void run() {
        launch();
    }
   @Override
   public void start(Stage st)throws  IOException
   {
    try{
    FXMLLoader loader=new FXMLLoader(getClass().getResource("media.fxml"));
    //Object loder;
  //  Group root=new Group();
     Scene sc=new Scene(loader.load());
     sc.setFill(Color.WHITESMOKE);
    ((sccontrol)loader.getController()).init(st);
    st.initStyle(StageStyle.TRANSPARENT);
        st.setResizable(false);






     st.setScene(sc);
     st.show();
    }
    catch(Exception e) {
        e.printStackTrace();

    }
   }

  
}
