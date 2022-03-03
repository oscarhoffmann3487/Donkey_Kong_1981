package Level1;

import java.util.ArrayList;

import Logic.Model;
import States.GameOverMenu;
import constants.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static constants.Constants.SCREEN_WIDTH;

public class Mario {

	private double x = 10.0;
	private double y = 625.0;
	private double speed = 8.0;
	private double climbingSpeed = 5.0;
	private double gravity = 2.0;
	private double jumpHeight = 40;
	private double scale = 30;
	private Rectangle2D marioBoundingBox;
	private Rectangle2D donkeyKong;
	private Model model;
	private Animation animation;


	private ArrayList<Rectangle2D> floors;
	private ArrayList<Rectangle2D> ladders;

	public Mario(Model model, ArrayList<Rectangle2D> floorBoundaries, Rectangle2D donkeyKong,
			ArrayList<Rectangle2D> ladderBoundaries) {
		this.floors = floorBoundaries;
		this.ladders = ladderBoundaries;
		this.donkeyKong = donkeyKong;
		this.model = model;
		animation = new Animation(model);

		marioBoundingBox = new Rectangle2D(x, y, scale, scale);

	}

	public void drawMario(GraphicsContext g) {
		g.drawImage(animation.getMarioStandRight(), x, y, scale, scale);
		
	}
	

	public void update() {
		gravity(ladderCollision(), onFloor());
		marioDonkeyKongCollision();
		marioBoundingBox = new Rectangle2D(x, y, scale, scale);
		marioSpecificLadderAndFloor();

	}

	public void marioDonkeyKongCollision() {
		if (marioBoundingBox.intersects(donkeyKong)) {
			model.switchState(new GameOverMenu(model));
		}
	}

	public void gravity(boolean isOnLadder, boolean isOnFloor) {

		if (isOnLadder || isOnFloor) {
		} else {
			y += gravity;
		}
	}

	public boolean onFloor() {
		for (Rectangle2D floor : floors) {
			if (marioBoundingBox.intersects(floor)) {
				return true;
			}
		}
		return false;
	}

	public boolean ladderCollision() {
		for (Rectangle2D ladder : ladders) {
			if (marioBoundingBox.intersects(ladder)) {
				return true;
			}
		}
		return false;
	}

	public boolean marioOnlyOnLadder() {
		if (ladderCollision() && !onFloor()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean marioSpecificLadderAndFloor() {
		if (marioBoundingBox.intersects(ladders.get(0)) && marioBoundingBox.intersects(floors.get(1))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(1)) && marioBoundingBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(2)) && marioBoundingBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(3)) && marioBoundingBox.intersects(floors.get(3))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(4)) && marioBoundingBox.intersects(floors.get(4))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(5)) && marioBoundingBox.intersects(floors.get(5))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(6)) && marioBoundingBox.intersects(floors.get(5))) {
			return true;
		} else if (marioBoundingBox.intersects(ladders.get(7)) && marioBoundingBox.intersects(floors.get(6))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean marioYCoordinate() {
		double yRef1 = y + 28.0;
		double yRef2 = y + 29.0;
		double floor1Y = 555;
		double floor2Y = 455;
		double floor3Y = 355;
		double floor4Y = 255;
		double floor5Y = 155;
		double floor6Y = 100;

		if (yRef1 == floor1Y || yRef2 == floor1Y) {
			return true;
		} else if (yRef1 == floor2Y || yRef2 == floor2Y) {
			return true;
		} else if (yRef1 == floor3Y || yRef2 == floor3Y) {
			return true;
		} else if (yRef1 == floor4Y || yRef2 == floor4Y) {
			return true;
		} else if (yRef1 == floor5Y || yRef2 == floor5Y) {
			return true;
		} else if (yRef1 == floor6Y || yRef2 == floor6Y) {
			return true;
		} else {
			return false;
		}
	}

	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");
		checkPosition();
		// Höger
		if (key.getCode() == KeyCode.D) {
			if (marioSpecificLadderAndFloor() && !marioYCoordinate()) {
			} else {
				x += speed;
			}

			// Vänster
		} else if (key.getCode() == KeyCode.A) {
			if (marioSpecificLadderAndFloor() && !marioYCoordinate()) {
			} else {
				x -= speed;
			}

			// Hoppa
		} else if (key.getCode() == KeyCode.SPACE) {
			if (onFloor()) {
				y -= jumpHeight;
			}

			// Klättra uppåt
		} else if (key.getCode() == KeyCode.W) {
			if (ladderCollision()) {
				y -= climbingSpeed;
			}

			// klättra nedåt
		} else if (key.getCode() == KeyCode.S) {
			if (marioSpecificLadderAndFloor() || marioOnlyOnLadder()) {
				y += climbingSpeed;
			}
		}
	}

	public void checkPosition() {
		if (x >= SCREEN_WIDTH - scale) {
			x -= speed;
		} else if (x <= 0.0) {
			x += speed;
		}
	}

	public void marioBarrelCollision() {
		y -= 5;
	}

	public Rectangle2D getMarioBoundingBox() {
		return marioBoundingBox;
	}

}