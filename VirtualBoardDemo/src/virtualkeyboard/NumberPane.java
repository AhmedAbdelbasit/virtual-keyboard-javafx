package virtualkeyboard;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class NumberPane extends Pane{
    
    private VirtualKeyboard parent;
    
    private double paneWidth;
    private final VBox vbox;
    private final HBox[] hbox;
    private final TextField txtTemp;
//    private TextField destination;
    private final Button[] buttons;
    
    private final char[] line1 = "789".toCharArray();
    private final char[] line2 = "456".toCharArray();
    private final char[] line3 = "123".toCharArray();
        
    private final int DOT = 10;
    private final int ZERO = 0;
        
    private final int NUM_OF_BUTTONS = 11;
    
    public NumberPane(FullKeyBoard parent, double width, TextField tempText){
        this.parent = parent;
        paneWidth = width;
        
        vbox = new VBox();
        hbox = new HBox[4];
        for (int i=0 ; i<4 ; i++){
            hbox[i] = new HBox();
        }
        
        txtTemp = tempText;
                
        buttons = new Button[NUM_OF_BUTTONS];
        for(int i=0 ; i<NUM_OF_BUTTONS ; i++){
            buttons[i] = new Button();
            buttons[i].setPrefWidth(paneWidth/3);
        }
        buttons[ZERO].setPrefWidth(2*paneWidth/3);
        
        for(int i=0 ; i<10; i++){
            buttons[i].setText(i+"");
        }
        for(int i=0 ; i<NUM_OF_BUTTONS ; i++){
            buttons[i].setOnAction(e->{
                press(((Button)e.getSource()).getText());
            });
        }
               
        buttons[DOT].setText(".");
        
        getChildren().add(vbox);
//        vbox.getChildren().add(txtTemp);
        for(int i=0 ; i<4 ; i++){
            vbox.getChildren().add(hbox[i]);
        }
        setButtonsOrder();
    }
    
    public void press(String text){
        // handle backspace
        txtTemp.setText(txtTemp.getText() + text);
    }
    
//    public void setDestination(TextField textField){
//        this.destination = textField;
//    }
    
    private void setButtonsOrder(){
        for(int i=0 ; i<line1.length ; i++){
            hbox[0].getChildren().add(buttons[(int)line1[i]-'0']);
        }
        for(int i=0 ; i<line2.length ; i++){
            hbox[1].getChildren().add(buttons[(int)line2[i]-'0']);
        }
        for(int i=0 ; i<line3.length ; i++){
            hbox[2].getChildren().add(buttons[(int)line3[i]-'0']);
        }
        
        hbox[3].getChildren().add(buttons[ZERO]);
        hbox[3].getChildren().add(buttons[DOT]);
    }
    
    public void returnText(TextField dest){
        parent.returnText();
    }
}
