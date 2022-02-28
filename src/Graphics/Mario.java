package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import Logic.Model;
import States.Level1;
import States.Menu;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public class Mario {
	private double x;
	private double y;
	private Image marioStandLeft;
	private Image marioStandRight;

	public Mario(Model model) {
		this.x = 0;
		this.y = 625;
		try {
			marioStandLeft = new Image(new FileInputStream("marioStand.png"));
			marioStandRight = new Image(new FileInputStream("marioStand.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

	}

	public void drawMario(GraphicsContext g) {

		g.drawImage(marioStandRight, x, y, 30, 30);
	}

	public void update() {

		// Here one would probably instead move the player and any
		// enemies / moving obstacles currently active.
		// tester.update();
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
}