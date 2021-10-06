package javafxapplication2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author aszab
 */
public class JavaFXApplication2 extends Application {
    
    
    @Override
    public void start(Stage stage) throws Exception {
        StackPane pane1 = new StackPane();
        Parent root = FXMLLoader.load(getClass().getResource("View.fxml"));     
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        Stage stage2 = new Stage();
        Scene scene2 = new Scene(FXMLLoader.load(getClass().getResource("Settings.fxml")));
        stage.setScene(scene);
        stage.show();
        
        
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
