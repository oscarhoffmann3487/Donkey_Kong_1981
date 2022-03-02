package Logic;

import java.io.FileNotFoundException;

import Graphics.*;
import States.GameState;
import States.Menu;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.media.AudioClip;
public class Model {

	private GameState currentState;
	
	public Model() {
		// We start out in the MenuState.
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
