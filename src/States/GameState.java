package States;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileNotFoundException;
import Logic.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * An abstract class with a protected model. Every class whom extends from GameState
 * also need to extend all of the abstract methods. 
 * 
 *
 */

public abstract class GameState {

	protected Model model;

	public GameState(Model model) {
		this.model = model;
	}

	public abstract void update() throws FileNotFoundException;

	public abstract void draw(GraphicsContext g) throws FileNotFoundException;

	public abstract void keyPressed(KeyEvent key);

	public void drawBg(GraphicsContext g, Color color) throws FileNotFoundException {

		g.setFill(color);
		g.fillRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
	}

}
