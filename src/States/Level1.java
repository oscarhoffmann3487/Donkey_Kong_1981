package States;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Graphics.Barrels;
import Graphics.DonkeyKong;
import Graphics.Floor;
import Graphics.Ladder;
import Graphics.Mario;
import Graphics.Pauline;
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
	private Pauline pauline;
	private Ladder ladders;
	private Barrels barrel;
	private Barrels barrel1;
	private int counter;

	public Level1(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder(model);
		floors = new Floor(model);
		donkeyKong = new DonkeyKong(model);
		pauline = new Pauline(model);
		barrel = new Barrels(model,  floors.getFloorBoundaries());
		barrel1 = new Barrels(model,  floors.getFloorBoundaries());
		mario = new Mario(model, floors.getFloorBoundaries(), donkeyKong.getDonkeyKongBoundingBox(),
				ladders.getladderBoundaries());

	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		// Ritar ut den svarta bakgrundsfärgen
		drawBg(g, bgColor);
		g.setFill(fontColor);

		// Stegar
		ladders.drawLadder(g);

		// Golven
		floors.drawFloor(g);

		// Mario
		mario.drawMario(g);

		// Barrels
		barrel1.drawBarrel(g);
		barrel.drawBarrel(g);
		
		// DonkeyKong
		donkeyKong.drawDonkeyKong(g);

		// Pauline
		pauline.drawPauline(g);

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
		counter += 1;
		
		System.out.println(counter);
		barrel.update();
		barrel1.update();
		mario.update();
		
		if (counter == 100) {
			barrel1 = new Barrels(model,  floors.getFloorBoundaries());
		}
				
		if (barrel.getBarrelBoundingBox().intersects(mario.getMarioBoundingBox())) {
			model.switchState(new GameOverMenu(model));
		}
		
	}
	
}
