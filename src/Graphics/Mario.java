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

	private double x = 100.0;
	private double y = 50.0;
	private double speed = 8.0;
	private double climbingSpeed = 5.0;
	private double gravity = 2.0;
	private double jumpHeight = 20;
	private double scale = 30;

	private Image marioStandLeft;
	private Image marioStandRight;
	private Rectangle2D marioBoundingBox;
	private Rectangle2D donkeyKong;

	private ArrayList<Rectangle2D> floors;

	public Mario(Model model, ArrayList<Rectangle2D> floorBoundaries, Rectangle2D donkeyKong) {
		this.floors = floorBoundaries;
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
		gravitation();
		floorCollision();
		marioDonkeyKongCollision();
		marioBoundingBox = new Rectangle2D(x, y, scale, scale);
		
	}
	public void marioDonkeyKongCollision() {
		if(marioBoundingBox.intersects(donkeyKong)) {
			x += speed;
			
		}
	}

	public void gravitation() {
		y += gravity;
	}

	public void floorCollision() {
		for (Rectangle2D floor : floors) {
			if (marioBoundingBox.intersects(floor)) {
				y -= gravity;
			}
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
	
	
	public boolean onLadder() {
		return false;
		/*
		 * for (Rectangle2D floor : floors) { if (marioBoundingBox.intersects(floor)) {
		 * return true; } } return false;
		 */
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

			if (onLadder()) {
				y -= climbingSpeed;
			}

		} else if (key.getCode() == KeyCode.S) {

			if (onLadder()) {
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