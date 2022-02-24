package Graphics;

import java.io.FileNotFoundException;

import Logic.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public abstract class GameState {

	protected Model model;

	public GameState(Model model) {
		this.model = model;
	}

	public abstract void update() throws FileNotFoundException;

	public abstract void draw(GraphicsContext g) throws FileNotFoundException;

	public abstract void keyPressed(KeyEvent key);

	public void drawBg(GraphicsContext g, Color color) throws FileNotFoundException { 
		// Here we can draw a background
						// if we so desire.
		g.setFill(color);
		g.fillRect(0, 0, 600, 600);
	}

	public abstract void activate();

	public abstract void deactivate();

}
