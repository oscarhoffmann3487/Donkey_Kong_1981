package Logic;

import java.io.FileNotFoundException;
import javafx.scene.canvas.Canvas;

/**
 * GamePanel extends Canvas which let us send getGraphicsContext2D() to the
 * draw-method in model.
 */

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
