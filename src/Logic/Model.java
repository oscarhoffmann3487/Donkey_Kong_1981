package Logic;

import java.io.FileNotFoundException;
import States.GameState;
import States.Menu;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

/**
 * 
 * Here we create a private GameState called currentState. 
 * This one is for example use when we want to switch GameState. 
 * Here you'll find KeyPressed, Update and Draw as well. 
 * 
 */

public class Model {

	private GameState currentState;

	public GameState getCurrentState() {
		return currentState;
	}

	public Model() {
		this.currentState = new Menu(this);
	}

	public void switchState(GameState nextState) {
		currentState = nextState;
	}

	public void keyPressed(KeyEvent key) {
		currentState.keyPressed(key);
	}

	public void update() throws FileNotFoundException {
		currentState.update();
	}

	public void draw(GraphicsContext g) throws FileNotFoundException {
		currentState.draw(g);
	}

}
