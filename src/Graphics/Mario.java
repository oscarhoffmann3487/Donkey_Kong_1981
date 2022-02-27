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

public class Mario extends Level1 {

	public class Point {
		double x;
		double y;

		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	private Point position;
	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	private Image marioStandLeft;
	private Image marioStandRight;

	public Mario(Model model) {
		super(model);
		position = new Point(0, 635);
		
		try {
			marioStandLeft = new Image(new FileInputStream("marioStand.png"));
			marioStandRight = new Image(new FileInputStream("marioStand.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

		
		
	}

	public void drawMario(GraphicsContext g) {
		
		g.drawImage(marioStandRight, position.x, position.y, 20, 20);
	}
	
	public void update() {
		

		// Here one would probably instead move the player and any
		// enemies / moving obstacles currently active.
		// tester.update();
	}
	
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.ESCAPE) {
	} else if (key.getCode() == KeyCode.D) {
		position.x += 2;
	} else if (key.getCode() == KeyCode.A) {
		position.x -= 2;
	}
	}
}
