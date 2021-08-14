package virtualkeyboard;

import javafx.scene.control.TextField;

public interface VirtualKeyboard {
    public void show();
    public void hide();
    public void returnText();
    public void setDestination(TextField destination);
}
