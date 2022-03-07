package Logic;

import java.io.FileNotFoundException;
import javafx.scene.layout.HBox;

/**
 * Creates a new GamePanel and places it within the Frame. Calls for the repaint-method in GamePanel.
 */
public class GameFrame extends HBox {
	private GamePanel g;

	public GameFrame(Model model, int width, int height) {
		g = new GamePanel(model, width, height);
		this.getChildren().add(g);
	}

	public void repaint() throws FileNotFoundException {
		g.repaint();
	}
}
