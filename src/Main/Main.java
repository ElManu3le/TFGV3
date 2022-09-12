package Main;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author elman
 */
public class Main extends Application {

    public static void main(String[] args) {

        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("/Vista/Login2.fxml"));
            Scene scene = new Scene(parent);
            primaryStage.setScene(scene);
            primaryStage.show();
            

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        
        }
       
    }


}
