package Logic;
import java.io.FileNotFoundException;

import Level1.*;
import States.GameOverMenu;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

public class GamePanel extends Canvas {
	private Model model;
	private Mario mario;

    public GamePanel(final Model model, int width, int height) {
        this.model = model;
        this.setWidth(width);
        this.setHeight(height);
    }

    public void repaint() throws FileNotFoundException {
    	model.draw(getGraphicsContext2D());
    }
 
    
  
}
