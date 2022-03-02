package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PaulinesItem {
	private double x = 400.0;
	private double y = 55.0;
	private Image pauline;
	private Rectangle2D purse;
	
	
	public PaulinesItem(Model model) {
		
			purse = new Rectangle2D(x, y, 30.0, 30.0);
			/*
			 * try { purse = new Image(new FileInputStream("pauline.png"));
			 * 
			 * } catch (FileNotFoundException e) {
			 * System.out.println("Unable to find image-files!"); }
			 */
		}
	
	public void drawPauline(GraphicsContext g) {
	//	g.drawImage(purse, 0, 0, 25.0, 25.0);
		
	}

	public Rectangle2D getPurseBoundingBox() {
		return purse;
	}

}
