package Level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Pauline {
	private double x = 400.0;
	private double y = 55.0;
	private Animation animation;
	private Rectangle2D paulineBoundingBox;
	
	
	public Pauline(Model model) {
			animation = new Animation(model);
			setPaulineBoundingBox(new Rectangle2D(x, y, 30.0, 30.0));
			
		}
	
	public void drawPauline(GraphicsContext g) {
		g.drawImage(animation.getPauline(), x, y, 50.0, 50.0);
	}

	public Rectangle2D getPaulineBoundingBox() {
		return paulineBoundingBox;
	}

	public void setPaulineBoundingBox(Rectangle2D paulineBoundingBox) {
		this.paulineBoundingBox = paulineBoundingBox;
	}
}