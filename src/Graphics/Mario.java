package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Logic.Model;
import States.Level1;
import States.Menu;
import javafx.geometry.BoundingBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public class Mario {

	private double x = 0.0;
	private double y = 625.0;
	private double speed = 8.0;
	private double climbingSpeed = 5.0;
	private double gravity = 2.0;
	private double jumpHeight = 40;
	private double scale = 30;
	// private boolean isOnLadder = false;

	private Image marioStandLeft;
	private Image marioStandRight;
	private Rectangle2D marioBoundingBox;
	private Rectangle2D donkeyKong;
	private Rectangle2D barrel;

	private ArrayList<Rectangle2D> floors;
	private ArrayList<Rectangle2D> ladders;

	public Mario(Model model, ArrayList<Rectangle2D> floorBoundaries, Rectangle2D donkeyKong,
			ArrayList<Rectangle2D> ladderBoundaries, Rectangle2D barrelBoundaries) {
		this.barrel = barrelBoundaries; 
		this.floors = floorBoundaries;
		this.ladders = ladderBoundaries;
		this.donkeyKong = donkeyKong;

		marioBoundingBox = new Rectangle2D(x, y, scale, scale);

		try {
			marioStandLeft = new Image(new FileInputStream("marioStand.png"));
			marioStandRight = new Image(new FileInputStream("marioStand.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}
	}

	public void drawMario(GraphicsContext g) {
		g.drawImage(marioStandRight, x, y, scale, scale);

	}

	public void update() {
		gravity(ladderCollision(), onFloor());
		marioDonkeyKongCollision();
		marioBarrelCollision();
		marioBoundingBox = new Rectangle2D(x, y, scale, scale);
		marioLadder();
	}

	public void marioDonkeyKongCollision() {
		if (marioBoundingBox.intersects(donkeyKong)) {
			x += speed;
		}
	}
	
	public void marioBarrelCollision() {
		if (marioBoundingBox.intersects(barrel)) {
			y -= speed;
			System.out.println("barrel");
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

	public boolean marioLadder2() {
		if (ladderCollision() && !onFloor()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean marioLadder() {
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

	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");

		checkPosition();
		// Höger
		if (key.getCode() == KeyCode.D) {
			x += speed;

			// Vänster
		} else if (key.getCode() == KeyCode.A) {
			x -= speed;

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

			if (marioLadder() || marioLadder2()) {
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

}