package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Pauline {
	private double x = 400.0;
	private double y = 55.0;
	private Image pauline;
	private Rectangle2D paulineBoundingBox;
	
	
	public Pauline(Model model) {
		
			setPaulineBoundingBox(new Rectangle2D(x, y, 30.0, 30.0));
			try {
				pauline = new Image(new FileInputStream("pauline.png"));
				
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find image-files!");
			}
		}
	
	public void drawPauline(GraphicsContext g) {
		g.drawImage(pauline, x, y, 50.0, 50.0);
		
	}

	public Rectangle2D getPaulineBoundingBox() {
		return paulineBoundingBox;
	}

	public void setPaulineBoundingBox(Rectangle2D paulineBoundingBox) {
		this.paulineBoundingBox = paulineBoundingBox;
	}
}