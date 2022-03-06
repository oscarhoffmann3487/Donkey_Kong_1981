package Level1;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Level2.Level2;
import Logic.*;
import States.GameOverMenu;
import States.GameState;
import States.HasWon;
import States.Menu;
import constants.Animation;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.paint.Color;

public class Level1 extends GameState {

	private Color bgColor;
	private Color fontColor;
	private Floor floors;
	private Ladder ladders;
	private int barrelTimer;
	private Barrels barrel;
	private Mario mario;
	private DonkeyKong donkeyKong;
	private Pauline pauline;
	private PaulinesItem purse;
	private PaulinesItem hat;
	private PaulinesItem umbrella;
	private Level2 level2;
	private Cape cape;
	private Animation animation;
	private int scoreScale = 40;
	private int capeTimer = 400;
	private int score = 0;
	private int bonus = 500;
	private int bonusTimer = 0;
	private ArrayList<Barrels> barrels;
	private ArrayList<Cape> capes;
	private ArrayList<PaulinesItem> paulinesItem;
	private ArrayList<PaulinesItem> mariosItem;

	public Level1(Model model) {
		super(model);
		level2 = new Level2(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder(model);
		floors = new Floor(model);
		purse = new PaulinesItem(model);
		hat = new PaulinesItem(model);
		umbrella = new PaulinesItem(model);
		donkeyKong = new DonkeyKong(model);
		pauline = new Pauline(model);
		cape = new Cape(model);
		animation = new Animation(model);
		this.barrel = new Barrels(model, null);
		barrels = new ArrayList<>();
		paulinesItem = new ArrayList<>();
		mariosItem = new ArrayList<>();
		capes = new ArrayList<>();
		paulinesItem.add(purse);
		paulinesItem.add(umbrella);
		paulinesItem.add(hat);
		capes.add(cape);

		mario = new Mario(model, floors.getFloorBoundaries(), donkeyKong.getDonkeyKongBoundingBox(),
				ladders.getladderBoundaries());
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		// Background
		drawBg(g, bgColor);
		g.setFill(fontColor);

		// Ladders
		ladders.drawLadder(g);
		// Floor
		floors.drawFloor(g);
		// Mario
		mario.drawMario(g);

		// Cape
		Cape();
		if(capes.contains(cape)) {
		cape.drawCape(g);
			}
	

		// Paulines Items
		PaulinesItem(g);

		// Barrels
		for (Barrels barrel : barrels) {
			barrel.drawBarrel(g);
		}

		// BarrelStack
		barrel.drawBarrelStack(g);

		// DonkeyKong
		donkeyKong.drawDonkeyKong(g);
		// Pauline
		pauline.drawPauline(g);
		
		//BonusLevel
		g.drawImage(animation.getBonus(), 100, 50, 100, 100);
		g.setFill(Color.RED);
		g.fillText(String.valueOf(bonus), 100, 50);
		g.fillText(String.valueOf(score), 200, 50);
	}

	public void PaulinesItem(GraphicsContext g) {

		for (PaulinesItem item : paulinesItem) {
			if (item == purse) {
				purse.drawPurse(g);
			} else if (item == hat) {
				hat.drawHat(g);
			} else if (item == umbrella) {
				umbrella.drawUmbrella(g);
			}
		}

		if (mario.getMarioBoundingBox().intersects(purse.getPurseBoundingBox())) {
			g.drawImage(animation.getScore300(), 430.0, 215.0, scoreScale, scoreScale);
			paulinesItem.remove(purse);
			mariosItem.add(purse);
			purse.setPurseBoundingBox(null);
			score += bonus*300;
			
		} else if (mario.getMarioBoundingBox().intersects(hat.getHatBoundingBox())) {
			g.drawImage(animation.getScore200(), 30.0, 320.0, scoreScale, scoreScale);
			paulinesItem.remove(hat);
			mariosItem.add(hat);
			hat.setHatBoundingBox(null);
			
			score += bonus*200;
		
		} else if (mario.getMarioBoundingBox().intersects(umbrella.getUmbrellaBoundingBox())) {
			g.drawImage(animation.getScore100(), 440.0, 405.0, scoreScale, scoreScale);
			paulinesItem.remove(umbrella);
			mariosItem.add(umbrella);
			umbrella.setUmbrellaBoundingBox(null);
			score += bonus*100;
		
		}
	}

	public void Cape() {
		if (mario.getMarioBoundingBox().intersects(cape.getCapeBoundingBox())) {
			capes.remove(cape);
		}
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
		barrelTimer += 1;
		bonusTimer += 1;
		mario.update();
		createBarrels();
		hasWonLevel();
		bonusSystem();
		initiateCapteTimer();

	}

	public void initiateCapteTimer() {
		if (mario.getMarioBoundingBox().intersects(cape.getCapeBoundingBox())) {
			capeTimer = 0;
		} else {
			capeTimer += 1;
		}
	}

	public void hasWonLevel() {
		if (mario.getMarioBoundingBox().intersects(pauline.getPaulineBoundingBox()) && mariosItem.contains(purse)
				&& mariosItem.contains(umbrella) && mariosItem.contains(hat)) {
			model.switchState(level2);
		}
	}

	public void bonusSystem() {

		if (bonus >= 0) {
			if (bonusTimer == 100) {
				bonus -= 10;
				bonusTimer = 0;
			}
		}

	}

	public void createBarrels() {
		for (Barrels barrel : barrels) {
			barrel.update();

			if (capeTimer > 400 && barrel.getBarrelBoundingBox().intersects(mario.getMarioBoundingBox())) {
				model.switchState(new GameOverMenu(model));
			}
		}

		if (barrelTimer > 90 && barrelTimer < 110) {
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 160 && barrelTimer < 190) {
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 240 && barrelTimer < 270) {
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 290 && barrelTimer < 320) {
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 480 && barrelTimer < 510) {
			donkeyKong.setMovement("pickUp");
		} else {
			donkeyKong.setMovement("stand");
		}

		// L�gger till nya barrels i listan med ett visst tidsintervall
		if (barrelTimer == 100) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 170) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 250) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 300) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 490) {
			barrels.add(new Barrels(model, floors.getFloorBoundaries()));
			barrelTimer = 0;
		}
	}
}
