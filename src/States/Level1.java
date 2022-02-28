package States;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Graphics.DonkeyKong;
import Graphics.Floor;
import Graphics.Ladder;
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
	private DonkeyKong donkeyKong;
	private Ladder ladders;


	public Level1(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder(model);
		floors = new Floor(model);
		donkeyKong = new DonkeyKong(model);
		mario = new Mario(model, floors.getFloorBoundaries(), donkeyKong.getDonkeyKongBoundingBox(), ladders.getladderBoundaries());
		
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		// Ritar ut den svarta bakgrundsfärgen
		drawBg(g, bgColor);
		g.setFill(fontColor);

		//Stegar
		ladders.drawLadder(g);
		
		// Golven
		floors.drawFloor(g);

		// Mario
		mario.drawMario(g);
		
		//DonkeyKong
		donkeyKong.drawDonkeyKong(g);
		
		

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
