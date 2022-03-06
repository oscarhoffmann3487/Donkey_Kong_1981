package Level2;

import java.io.FileNotFoundException;
import java.util.ArrayList;

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
	private HasWon hasWon;
	private Cape2 cape;
	private Animation animation;
	private int scoreScale = 40;
	private int capeTimer = 400;
	private ArrayList<Barrels2> barrels;
	private ArrayList<Cape2> capes;
	private ArrayList<PaulinesItem2> paulinesItem;
	private ArrayList<PaulinesItem2> mariosItem;

	public Level2(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.BLUE;
		ladders = new Ladder2(model);
		floors = new Floor2(model);
		purse = new PaulinesItem2(model);
		hat = new PaulinesItem2(model);
		umbrella = new PaulinesItem2(model);
		donkeyKong = new DonkeyKong2(model);
		pauline = new Pauline2(model);
		hasWon = new HasWon(model);
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
		for (Cape2 c : capes) {
			if (c == cape) {
				cape.drawCape(g);
			}
		}
		
		// Paulines Items
		PaulinesItem(g);
		
		//BarrelStack
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
			// metod som skickar vidare poäng till highscore-klassen
			g.drawImage(animation.getScore300(), 220.0, 215.0, scoreScale, scoreScale);
			paulinesItem.remove(purse);
			mariosItem.add(purse);
		} else if (mario.getMarioBoundingBox().intersects(hat.getHatBoundingBox())) {
			g.drawImage(animation.getScore200(), 100.0, 320.0, scoreScale, scoreScale);
			paulinesItem.remove(hat);
			mariosItem.add(hat);
		} else if (mario.getMarioBoundingBox().intersects(umbrella.getUmbrellaBoundingBox())) {
			g.drawImage(animation.getScore100(), 360.0, 405.0, scoreScale, scoreScale);
			paulinesItem.remove(umbrella);
			mariosItem.add(umbrella);
		}
	}

	public void Cape() {
		if (mario.getMarioBoundingBox().intersects(cape.getCapeBoundingBox())) {
			capes.remove(cape);
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
		barrelTimer += 1;
		capeTimer += 1;
		mario.update();
		createBarrels();
		if (mario.getMarioBoundingBox().intersects(pauline.getPaulineBoundingBox()) && mariosItem.contains(purse)
				&& mariosItem.contains(umbrella) && mariosItem.contains(hat)) {
			model.switchState(hasWon);
		}
		if (mario.getMarioBoundingBox().intersects(cape.getCapeBoundingBox())) {
			capeTimer = 0;
		}
		
	}

	public void createBarrels() {
		for (Barrels2 barrel : barrels) {
			barrel.update();
			
			if (capeTimer > 0 && capeTimer < 400) {
				if (barrel.getBarrelBoundingBox().intersects(mario.getMarioBoundingBox())) {
				}
			} else if (capeTimer > 400 && barrel.getBarrelBoundingBox().intersects(mario.getMarioBoundingBox())) {
				model.switchState(new GameOverMenu(model));
			}
		}
		
		if(barrelTimer > 90 && barrelTimer < 110){
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 160 && barrelTimer < 190) {
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 240 && barrelTimer < 270) {
			donkeyKong.setMovement("pickUp");
		} else if (barrelTimer > 290 && barrelTimer < 320) {
			donkeyKong.setMovement("pickUp");
		}else if (barrelTimer > 480 && barrelTimer < 510) {
				donkeyKong.setMovement("pickUp");
		}else {
			donkeyKong.setMovement("stand");
		}
		
		//Lägger till nya barrels i listan med ett visst tidsintervall
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

