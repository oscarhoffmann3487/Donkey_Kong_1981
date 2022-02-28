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
	private double x;
	private double y;
	private Image marioStandLeft;
	private Image marioStandRight;
	private BoundingBox mario_2D;

	public Mario(Model model) {
		this.x = 0;
		this.y = 625;
		mario_2D = new BoundingBox(getX(), getY(), 30, 30);
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
		g.drawImage(marioStandRight, x, y, 30, 30);
	}

	public void update() {
		y += 0.5;
	}

	public void dontUpdate() {
	}

	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");
		checkPosition();
		if (key.getCode() == KeyCode.D) {
			x += 5;
		} else if (key.getCode() == KeyCode.A) {
			x -= 5;
		} else if (key.getCode() == KeyCode.SPACE) {
			y -= 10;

		}
		// } else if (key.getCode() == KeyCode.W) {
		// y += 5;
		// } else if (key.getCode() == KeyCode.S) {
		// y -= 5;
	}

	public void checkPosition() {
		if (x >= SCREEN_WIDTH - 30) {
			x -= 5;
		} else if (x <= 0) {
			x += 5;
		}
	}

	public BoundingBox getMario_2D() {
		return mario_2D;
	}

	public void setMario_2D(BoundingBox mario_2d) {
		mario_2D = mario_2d;
	}
}