package Logic;
import java.io.FileNotFoundException;

import Graphics.*;
import States.GameOverMenu;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.HBox;

public class GamePanel extends Canvas {
	private Model model;

    public GamePanel(final Model model, int width, int height) {
        this.model = model;
        this.setWidth(width);
        this.setHeight(height);
    }

    public void repaint() throws FileNotFoundException {
    	model.draw(getGraphicsContext2D());
    }
 
    
  
}
