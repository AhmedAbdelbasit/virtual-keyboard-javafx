package virtualkeyboard;

import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class FullKeyBoard extends Pane implements VirtualKeyboard{
    private final TextField txt;
    private TextField destination;
    private final LetterPane k;
    private final NumberPane n;
        
    public FullKeyBoard(){
        txt = new TextField();
        k = new LetterPane(this, 500, txt);
        n = new NumberPane(this, 120, txt);
        
        VBox layout = new VBox();
        HBox panes = new HBox();
        
        layout.getChildren().add(txt);
        layout.getChildren().add(panes);
        layout.setPadding(new Insets(10));
        layout.setSpacing(10);
        
        panes.setSpacing(10);
        panes.getChildren().add(k);
        panes.getChildren().add(n);
        
        getChildren().add(layout);
        hide();
    }
    
    @Override
    public void setDestination(TextField destination){
        this.destination = destination;
    }
    
    @Override
    public void show(){
        this.setOpacity(1);
    }
    
    @Override
    public void hide(){
        this.setOpacity(0);
    }
    
    @Override
    public void returnText(){
        destination.setText(txt.getText());
        txt.setText("");
        hide();
    }
}
