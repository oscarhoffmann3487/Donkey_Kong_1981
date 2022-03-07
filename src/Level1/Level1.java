package Level1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import Level2.Level2;
import Logic.*;
import States.GameOverMenu;
import States.GameState;
import States.Menu;
import constants.Animation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Level1 extends GameState. Read further down for more information about the
 * methods.
 */

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
	private Cape cape;
	private Animation animation;
	private int scoreScale = 40;
	private int capeTimer = 400;
	private int score = 0;
	private int bonus = 500;
	private int bonusTimer = 0;
	private int scoreTimer = 0;
	private boolean takenPurse = false;
	private boolean takenHat = false;
	private boolean takenUmbrella = false;
	private ArrayList<Barrels> barrels;
	private ArrayList<Cape> capes;
	private ArrayList<PaulinesItem> paulinesItem;
	private ArrayList<PaulinesItem> mariosItem;

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

		mario = new Mario(model, floors.getFloorBoundaries(), donkeyKong.getDonkeyKongBox(),
				ladders.getladderBoundaries());
	}

	/**
	 * Within the draw-method every type of item calls for their own draw-method.
	 * Here we also print out bonus and score.
	 */
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
		if (capes.contains(cape)) {
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

		// Bonus and Score
		g.setFill(Color.RED);
		g.setFont(new Font(30));
		g.fillText("BONUS", 70, 35);
		g.fillText("SCORE", 200, 35);

		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText(String.valueOf(bonus), 70, 60);
		g.fillText(String.valueOf(score), 200, 60);
	}

	/**
	 * Pauline´s items are drawn in this method. If mario intersects pauline's items
	 * we will remove the item from the Arraylist paulinesItem and replace it in the
	 * ArrayList marioItem instead. The item will no longer be shown and the player
	 * receives a specific score for each item depending on how fast it is taken.
	 * 
	 * @param g
	 */
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

		if (mario.getMarioBox().intersects(purse.getPurseBox())) {
			takenPurse = true;
			paulinesItem.remove(purse);
			mariosItem.add(purse);
			purse.setPurseBox(null);
			score += bonus * 300;

		} else if (mario.getMarioBox().intersects(hat.getHatBox())) {
			takenHat = true;
			paulinesItem.remove(hat);
			mariosItem.add(hat);
			hat.setHatBox(null);
			score += bonus * 200;

		} else if (mario.getMarioBox().intersects(umbrella.getUmbrellaBox())) {
			takenUmbrella = true;
			paulinesItem.remove(umbrella);
			mariosItem.add(umbrella);
			umbrella.setUmbrellaBox(null);
			score += bonus * 100;

		}
		purseScoreAnimation(g);
		hatScoreAnimation(g);
		umbrellaScoreAnimation(g);
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
				g.drawImage(animation.getScore200(), 120.0, 320.0, scoreScale, scoreScale);
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

	public void Cape() {
		if (mario.getMarioBox().intersects(cape.getCapeBox())) {
			capes.remove(cape);
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
		initiateCapeTimer();
	}

	/**
	 * If mario intersects the cape the capeTimer will start and Mario will be
	 * immune against barrels for a short amount of time.
	 */
	public void initiateCapeTimer() {
		if (mario.getMarioBox().intersects(cape.getCapeBox())) {
			capeTimer = 0;
		} else {
			capeTimer += 1;
		}
		

	}

	/**
	 * If mario intersects pauline and has all of Paulines items we will switch to
	 * level2.
	 */
	public void hasWonLevel() {
		if (mario.getMarioBox().intersects(pauline.getPaulineBox()) && mariosItem.contains(purse)
				&& mariosItem.contains(umbrella) && mariosItem.contains(hat)) {
			model.switchState(new Level2(model, score));
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

	/**
	 * In this method we create the barrels depending on the barrelTimer. When the
	 * barrel is created the barrelTimer will be zero once again.
	 */
	public void createBarrels() {
		for (Barrels barrel : barrels) {
			barrel.update();

			if (capeTimer > 400 && barrel.getBarrelBox().intersects(mario.getMarioBox())) {
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

		/** Lägger till nya barrels i listan med ett visst tidsintervall
		 * 
		 */
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
