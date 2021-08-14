package virtualkeyboard;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class LetterPane extends Pane{
    
    private final VirtualKeyboard parent;
    
    private final double paneWidth;
    private final VBox vbox;
    private final HBox[] hbox;
    private final TextField txtTemp;
//    private TextField destination;
    private final Button[] buttons;
    
    private final char[] line1 = "qwertyuiop".toCharArray();
    private final char[] line2 = "asdfghjkl".toCharArray();
    private final char[] line3 = "zxcvbnm".toCharArray();
    
    private boolean isLower = false;
    
    private final int DOT = 26;
    private final int DASH = 27;
    private final int SLASH = 28;
    private final int SPACE = 29;
    private final int COMMA = 30;
    private final int EXCLAIM = 31;
    private final int QUESTION = 32;
    private final int BACK_SLASH = 33;
    private final int SHIFT = 34;
    private final int BACK = 35;
    private final int ENTER = 36;
    
    private final int NUM_OF_BUTTONS = 37;
    
    public LetterPane(FullKeyBoard parent, double width, TextField tempText){
        
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
            buttons[i].setPrefWidth(paneWidth/10);
        }
        buttons[SPACE].setPrefWidth(6*paneWidth/10);
        buttons[ENTER].setPrefWidth(paneWidth/10*1.5);
        
        for(int i=0 ; i<26 ; i++){
            buttons[i].setText((char)('A'+i)+"");
        }
        for(int i=0 ; i<SHIFT ; i++){
            buttons[i].setOnAction(e->{
                press(((Button)e.getSource()).getText());
            });
        }
        
        buttons[SHIFT].setOnAction(e->{
            isLower = !isLower;
            if(isLower){
                buttons[SHIFT].setText("△");
                for(int i=0 ; i<26 ; i++){
                    buttons[i].setText((char)('a'+i)+"");
                }
            }else{
                buttons[SHIFT].setText("▲");
                for(int i=0 ; i<26 ; i++){
                    buttons[i].setText((char)('A'+i)+"");
                }
            }
            
        });
        buttons[BACK].setOnAction(e->{
            String s = txtTemp.getText();
            int l = s.length();
            if(l > 0){
                txtTemp.setText(s.substring(0, l-1));
            }
        });
        buttons[ENTER].setOnAction(e->{
            returnText();
        });
        
        buttons[DOT].setText(".");
        buttons[DASH].setText("-");
        buttons[SLASH].setText("/");
        buttons[BACK_SLASH].setText("\\");
        buttons[SPACE].setText(" ");
        buttons[COMMA].setText(",");
        buttons[EXCLAIM].setText("!");
        buttons[QUESTION].setText("?");
        buttons[SHIFT].setText("▲");
        buttons[BACK].setText("←");
        buttons[ENTER].setText("⏎");
        
        getChildren().add(vbox);
//        vbox.getChildren().add(txtTemp);
        for(int i=0 ; i<4 ; i++){
            vbox.getChildren().add(hbox[i]);
        }
        setButtonsOrder();
    }
    
    public void press(String text){
        txtTemp.setText(txtTemp.getText() + text);
    }
    
    private void setButtonsOrder(){
        for(int i=0 ; i<line1.length ; i++){
            hbox[0].getChildren().add(buttons[(int)line1[i]-'a']);
        }
        hbox[0].getChildren().add(buttons[BACK]);
        
        Label l = new Label();
        l.setPrefWidth(paneWidth/20);
        hbox[1].getChildren().add(l);
        for(int i=0 ; i<line2.length ; i++){
            hbox[1].getChildren().add(buttons[(int)line2[i]-'a']);
        }
        hbox[1].getChildren().add(buttons[ENTER]);
        
        hbox[2].getChildren().add(buttons[COMMA]);
        for(int i=0 ; i<line3.length ; i++){
            hbox[2].getChildren().add(buttons[(int)line3[i]-'a']);
        }
        hbox[2].getChildren().add(buttons[EXCLAIM]);
        hbox[2].getChildren().add(buttons[QUESTION]);
        hbox[2].getChildren().add(buttons[SHIFT]);
        
        hbox[3].getChildren().add(buttons[BACK_SLASH]);
        hbox[3].getChildren().add(buttons[SLASH]);
        hbox[3].getChildren().add(buttons[SPACE]);
        hbox[3].getChildren().add(buttons[DASH]);
        hbox[3].getChildren().add(buttons[DOT]);
        
    }
    
    public void returnText(){
        parent.returnText();
    }
}
