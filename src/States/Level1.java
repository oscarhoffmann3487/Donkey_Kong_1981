package States;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

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
<<<<<<< Updated upstream
=======
	private Barrels barrel;
>>>>>>> Stashed changes
	private int counter;
	private ArrayList<Barrels> barrels;

	public Level1(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder(model);
		floors = new Floor(model);
		donkeyKong = new DonkeyKong(model);
		pauline = new Pauline(model);
<<<<<<< Updated upstream
		barrels = new ArrayList<>();
=======
		barrel = new Barrels(model, floors.getFloorBoundaries());
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
		for (Barrels barrel : barrels) {
			barrel.drawBarrel(g);
		}
=======
		barrel.drawBarrel(g);
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
		mario.update();
		createBarrels();

	}

	public void createBarrels() {
		for (Barrels barrel : barrels) {
			barrel.update();
			if (barrel.getBarrelBoundingBox().intersects(mario.getMarioBoundingBox())) {
				model.switchState(new GameOverMenu(model));
			}
		}
		if (counter == 100) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (counter == 170) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (counter == 250) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (counter == 300) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (counter == 490) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));
			counter = 0;
=======

		System.out.println(counter);
		barrel.update();
		mario.update();
		
		if (barrel.getBarrelBoundingBox().intersects(mario.getMarioBoundingBox())) {
			model.switchState(new GameOverMenu(model));
>>>>>>> Stashed changes
		}
	}

}
