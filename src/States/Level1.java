package States;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Graphics.Floor;
import Graphics.Mario;
import Logic.*;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Level1 extends GameState {

	private Color bgColor;
	private Color fontColor;
	private Mario mario;
	private Floor floors;


	public Level1(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		floors = new Floor(model);
		mario = new Mario(model, floors.getFloor1());
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		// Ritar ut den svarta bakgrundsfärgen
		drawBg(g, bgColor);
		g.setFill(fontColor);

		// Golven
		floors.drawFloor(g);

		// Mario
		mario.drawMario(g);

	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");
		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new Menu(model));
		} else {
			mario.keyPressed(key);
		}
	}

	@Override
	public void update() {
		mario.update();
		
	}

	@Override
	public void activate() {

	}

	@Override
	public void deactivate() {

	}

}
