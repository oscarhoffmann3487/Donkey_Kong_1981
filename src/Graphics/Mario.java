package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Mario{
	private double x = 0.0;
	private double y = 610.0;
	private Image marioStandLeft;
	private Image marioStandRight;
	private Rectangle2D marioBoundingBox;
	private Rectangle2D floor;

	public Mario(Model model, Rectangle2D floor1) {
	this.floor = floor1;
		
		marioBoundingBox = new Rectangle2D(x, y, 30.0, 30.0);
		try {
			marioStandLeft = new Image(new FileInputStream("marioStand.png"));
			marioStandRight = new Image(new FileInputStream("marioStand.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public void drawMario(GraphicsContext g) {
		g.drawImage(marioStandRight, x, y, 30.0, 30.0);
		
	}

	public void update() {
	marioFall();
	marioFloorCollision();
	marioBoundingBox = new Rectangle2D(x, y, 30, 30);
	
		
	}
	
	public void marioFall() {
	y += 2.0;
	}
	
	
	public void marioFloorCollision() {
	if(marioBoundingBox.intersects(floor)) {
	y -= 2.0;
	}
	
	}
	
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker p� " + key.getCode() + " i PlayState");
		checkPosition();
		if (key.getCode() == KeyCode.D) {
			x += 5.0;
		} else if (key.getCode() == KeyCode.A) {
			x -= 5.0;
		} else if (key.getCode() == KeyCode.SPACE) {
			if(marioBoundingBox.intersects(floor)) {
			y -= 20.0;
			}

		 } else if (key.getCode() == KeyCode.W) {
		 y -= 5.0;
		 } else if (key.getCode() == KeyCode.S) {
		 y += 5.0;
		}
	}

	public void checkPosition() {
		if (x >= SCREEN_WIDTH - 30.0) {
			x -= 5.0;
		} else if (x <= 0.0) {
			x += 5.0;
		}
	}

}