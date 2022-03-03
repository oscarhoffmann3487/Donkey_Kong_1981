package Logic;
import java.io.FileNotFoundException;

import Level1.*;

import javafx.scene.layout.HBox;

public class GameFrame extends HBox {
	private GamePanel g;

	public GameFrame(Model model, int width, int height) {
		// Create a new GamePanel and add's it to the frame   
		g = new GamePanel(model, width, height);
		this.getChildren().add(g);
	}

	public void repaint() throws FileNotFoundException {
		g.repaint();
	}
}
