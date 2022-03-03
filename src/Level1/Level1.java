package Level1;

import static constants.Constants.SCREEN_HEIGHT; 
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import Logic.*;
import States.GameOverMenu;
import States.GameState;
import States.HasWon;
import States.Menu;
import constants.Animation;
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
	private PaulinesItem purse;
	private PaulinesItem hat;
	private PaulinesItem umbrella;
	private HasWon hasWon;
	private Cape cape;
	private int counter;
	private ArrayList<Barrels> barrels;
	private ArrayList<PaulinesItem> paulinesItem;
	

	public Level1(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder(model);
		floors = new Floor(model);
		purse = new PaulinesItem(model);
		hat = new PaulinesItem(model);
		umbrella = new PaulinesItem(model);
		donkeyKong = new DonkeyKong(model);
		pauline = new Pauline(model);
		hasWon = new HasWon(model);
		cape = new Cape(model);
		barrels = new ArrayList<>();
		paulinesItem = new ArrayList<>();
		paulinesItem.add(purse);
		paulinesItem.add(umbrella);
		paulinesItem.add(hat);
		mario = new Mario(model, floors.getFloorBoundaries(), donkeyKong.getDonkeyKongBoundingBox(),
				ladders.getladderBoundaries());
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		// Ritar ut den svarta bakgrundsfÃ¤rgen
		drawBg(g, bgColor);
		g.setFill(fontColor);

		// Stegar
		ladders.drawLadder(g);

		// Golven
		floors.drawFloor(g);

		// Mario
		mario.drawMario(g);
		
		//Cape
		cape.drawCape(g);

		// Paulines Items
		PaulinesItem();
		for (PaulinesItem item : paulinesItem) {
			if (item == purse) {
				purse.drawPurse(g);
			} else if (item == hat) {
				hat.drawHat(g);
			} else if (item == umbrella) {
				umbrella.drawUmbrella(g);
			}
		}

		// Barrels
		for (Barrels barrel : barrels) {
			barrel.drawBarrel(g);
		}

		// DonkeyKong
		donkeyKong.drawDonkeyKong(g);

		// Pauline
		pauline.drawPauline(g);

	}
	
	public void PaulinesItem() {
		
		if (mario.getMarioBoundingBox().intersects(purse.getPurseBoundingBox())) {
			//bonuspoäng
			paulinesItem.remove(purse);
		} else if (mario.getMarioBoundingBox().intersects(hat.getHatBoundingBox())) {
			//bonuspoäng
			paulinesItem.remove(hat);
		} else if (mario.getMarioBoundingBox().intersects(umbrella.getUmbrellaBoundingBox())) {
			//bonuspoäng
			paulinesItem.remove(umbrella);
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker pï¿½ " + key.getCode() + " i PlayState");
		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(new Menu(model));
		} else {
			mario.keyPressed(key);
			
		}
	}

	@Override
	public void update() {
		counter += 1;
		mario.update();
		createBarrels();
		if (mario.getMarioBoundingBox().intersects(pauline.getPaulineBoundingBox())) {
			model.switchState(hasWon);
		}
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
		}
	}
}
