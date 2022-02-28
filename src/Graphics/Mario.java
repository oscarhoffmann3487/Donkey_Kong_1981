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
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public class Mario {

	private double x = 0.0;
	private double y = 625.0;
	private double speed = 8.0;
	private double climbingSpeed = 5.0;
	private double gravity = 2.0;
	private double jumpHeight = 20;
	private double scale = 15;
	// private boolean isOnLadder = false;

	private Image marioStandLeft;
	private Image marioStandRight;
	private Rectangle2D upperBoundingBox;
	private Rectangle2D lowerBoundingBox;
	private Rectangle2D donkeyKong;

	private ArrayList<Rectangle2D> floors;
	private ArrayList<Rectangle2D> ladders;

	public Mario(Model model, ArrayList<Rectangle2D> floorBoundaries, Rectangle2D donkeyKong,
			ArrayList<Rectangle2D> ladderBoundaries) {
		this.floors = floorBoundaries;
		this.ladders = ladderBoundaries;
		this.donkeyKong = donkeyKong;

		upperBoundingBox = new Rectangle2D(x, y, scale, scale);
		upperBoundingBox = new Rectangle2D(x, y, scale, scale);
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
		upperBoundingBox = new Rectangle2D(x, y, scaleX, scale);

	}

	public void marioDonkeyKongCollision() {
		if (upperBoundingBox.intersects(donkeyKong)) {
			x += speed;

		}
	}

	public void gravity(boolean isOnLadder, boolean isOnFloor) {

		if (isOnLadder || isOnFloor) {
		}else {
		y += gravity;
		}
	}

	public boolean onFloor() {
		for (Rectangle2D floor : floors) {
			if (upperBoundingBox.intersects(floor)) {
				return true;
			}
		}
		return false;
	}

	public boolean ladderCollision() {
		for (Rectangle2D ladder : ladders) {
			if (upperBoundingBox.intersects(ladder)) {
				return true;
			}
		}
		return false;
	}

	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");

		checkPosition();

		if (key.getCode() == KeyCode.D) {

			if (onFloor()) {
				x += speed;
			}

		} else if (key.getCode() == KeyCode.A) {
			if (onFloor()) {
				x -= speed;
			}
		} else if (key.getCode() == KeyCode.SPACE) {

			if (onFloor()) {
				y -= jumpHeight;
			}

		} else if (key.getCode() == KeyCode.W) {

			if (ladderCollision()) {
				y -= climbingSpeed;
			}

		} else if (key.getCode() == KeyCode.S) {

		if(ladderCollision()) {
				y += climbingSpeed;
			}
		}
	}

	public void checkPosition() {
		if (x >= SCREEN_WIDTH - scaleX) {
			x -= speed;
		} else if (x <= 0.0) {
			x += speed;
		}
	}

}