package Level2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Logic.*;
import States.GameOverMenu;
import States.GameState;
import States.HasWon;
import States.HighScore;
import States.Menu;
import constants.Animation;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Level2 extends GameState {

	private Color bgColor;
	private Color fontColor;
	private Floor2 floors;
	private Ladder2 ladders;
	private int barrelTimer;
	private Barrels2 barrel;
	private Mario2 mario;
	private DonkeyKong2 donkeyKong;
	private Pauline2 pauline;
	private PaulinesItem2 purse;
	private PaulinesItem2 hat;
	private PaulinesItem2 umbrella;
	private Cape2 cape;
	private Animation animation;
	private int scoreScale = 40;
	private int capeTimer = 400;
	private int bonus = 500;
	private int finalScore;
	private int bonusTimer = 0;
	private int scoreTimer = 0;
	private boolean takenPurse = false;
	private boolean takenHat = false;
	private boolean takenUmbrella = false;
	private ArrayList<Barrels2> barrels;
	private ArrayList<Cape2> capes;
	private ArrayList<PaulinesItem2> paulinesItem;
	private ArrayList<PaulinesItem2> mariosItem;

	public Level2(Model model, int finalScore) {
		super(model);
		this.finalScore = finalScore;
		System.out.println(finalScore);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder2(model);
		floors = new Floor2(model);
		purse = new PaulinesItem2(model);
		hat = new PaulinesItem2(model);
		umbrella = new PaulinesItem2(model);
		donkeyKong = new DonkeyKong2(model);
		pauline = new Pauline2(model);
		cape = new Cape2(model);
		animation = new Animation(model);
		this.barrel = new Barrels2(model, null);
		barrels = new ArrayList<>();
		paulinesItem = new ArrayList<>();
		mariosItem = new ArrayList<>();
		capes = new ArrayList<>();
		paulinesItem.add(purse);
		paulinesItem.add(umbrella);
		paulinesItem.add(hat);
		capes.add(cape);

		mario = new Mario2(model, floors.getFloorBoundaries(), donkeyKong.getDonkeyKongBoundingBox(),
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

		// Barrels
		for (Barrels2 barrel : barrels) {
			barrel.drawBarrel(g);
		}

		// Cape
		Cape();
		if (capes.contains(cape)) {
			cape.drawCape(g);
		}
		// Bonus and Score
		g.setFill(Color.RED);
		g.setFont(new Font(25));
		g.fillText("BONUS", 40, 35);
		g.fillText("SCORE", 300, 35);

		g.setFill(Color.WHITE);
		g.fillText(String.valueOf(bonus), 135, 35);
		g.fillText(String.valueOf(finalScore), 390, 35);

		// Paulines Items
		PaulinesItem(g);

		// BarrelStack
		barrel.drawBarrelStack(g);

		// DonkeyKong
		donkeyKong.drawDonkeyKong(g);
		// Pauline
		pauline.drawPauline(g);
	}

	public void PaulinesItem(GraphicsContext g) {

		for (PaulinesItem2 item : paulinesItem) {
			if (item == purse) {
				purse.drawPurse(g);
			} else if (item == hat) {
				hat.drawHat(g);
			} else if (item == umbrella) {
				umbrella.drawUmbrella(g);
			}
		}

		if (mario.getMarioBoundingBox().intersects(purse.getPurseBoundingBox())) {
			takenPurse = true;
			paulinesItem.remove(purse);
			mariosItem.add(purse);
			purse.setPurseBoundingBox(null);
			finalScore += bonus * 300;
		} else if (mario.getMarioBoundingBox().intersects(hat.getHatBoundingBox())) {
			takenHat = true;
			paulinesItem.remove(hat);
			mariosItem.add(hat);
			hat.setHatBoundingBox(null);
			finalScore += bonus * 200;
		} else if (mario.getMarioBoundingBox().intersects(umbrella.getUmbrellaBoundingBox())) {
			takenUmbrella = true;
			paulinesItem.remove(umbrella);
			mariosItem.add(umbrella);
			umbrella.setUmbrellaBoundingBox(null);
			finalScore += bonus * 100;
		}
		purseScoreAnimation(g);
		hatScoreAnimation(g);
		umbrellaScoreAnimation(g);
	}

	public void Cape() {
		if (mario.getMarioBoundingBox().intersects(cape.getCapeBoundingBox())) {
			capes.remove(cape);
		}
	}

	public void purseScoreAnimation(GraphicsContext g) {

		if (takenPurse == true) {
			scoreTimer += 1;
			if (scoreTimer < 50) {
				g.drawImage(animation.getScore300(), 220.0, 215.0, scoreScale, scoreScale);
			} else {
				takenPurse = false;
				scoreTimer = 0;
			}
		}
	}

	public void hatScoreAnimation(GraphicsContext g) {

		if (takenHat == true) {
			scoreTimer += 1;
			if (scoreTimer < 50) {
				g.drawImage(animation.getScore200(), 100.0, 320.0, scoreScale, scoreScale);
			} else {
				takenHat = false;
				scoreTimer = 0;
			}
		}
	}

	public void umbrellaScoreAnimation(GraphicsContext g) {
		if (takenUmbrella == true) {
			scoreTimer += 1;
			if (scoreTimer < 50) {
				g.drawImage(animation.getScore100(), 350.0, 405.0, scoreScale, scoreScale);
			} else {
				takenUmbrella = false;
				scoreTimer = 0;
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
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
			model.switchState(new HasWon(model, finalScore));
		
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
		for (Barrels2 barrel : barrels) {
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

		// Lägger till nya barrels i listan med ett visst tidsintervall
		if (barrelTimer == 100) {
			barrels.add(new Barrels2(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 170) {
			barrels.add(new Barrels2(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 250) {
			barrels.add(new Barrels2(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 300) {
			barrels.add(new Barrels2(model, floors.getFloorBoundaries()));

		} else if (barrelTimer == 490) {
			barrels.add(new Barrels2(model, floors.getFloorBoundaries()));
			barrelTimer = 0;
		}
	}
}
