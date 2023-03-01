package virtualboarddemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import virtualkeyboard.FullKeyBoard;

public class VirtualBoardDemo extends Application {
    private TextField d;
    @Override
    public void start(Stage primaryStage) {
        d = new TextField();
        FullKeyBoard keyboard = new FullKeyBoard();
        
        d.setOnMouseClicked(e->{
            keyboard.setDestination(d);
            keyboard.setKeyboardWidth(d.getScene().getWindow().getWidth()*.9);
            keyboard.show();
        });
        
        
        VBox root = new VBox();
        root.getChildren().addAll(d,keyboard);
        
        Scene scene = new Scene(root);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
