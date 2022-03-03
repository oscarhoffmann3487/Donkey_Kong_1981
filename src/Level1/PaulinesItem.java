package Level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class PaulinesItem { 
	private Rectangle2D purseBoundingBox;
	private Rectangle2D hatBoundingBox;
	private Rectangle2D umbrellaBoundingBox;
	private Animation animation;

	public Rectangle2D getPurseBoundingBox() {
		return purseBoundingBox;
	}

	public Rectangle2D getUmbrellaBoundingBox() {
		return umbrellaBoundingBox;
	}

	public PaulinesItem(Model model) {

		purseBoundingBox = new Rectangle2D(440.0, 235.0, 25.0, 25.0);
		hatBoundingBox = new Rectangle2D(30.0, 342.0, 40.0, 40.0);
		umbrellaBoundingBox = new Rectangle2D(450.0, 435.0, 35.0, 35.0);

		animation = new Animation(model);

	}

	public void drawPurse(GraphicsContext g) {
		 g.drawImage(animation.getPurse(), 440.0, 235.0, 25.0, 25.0);
	}
	
	public void drawHat(GraphicsContext g) {	
		 g.drawImage(animation.getHat(), 30.0, 342.0, 40.0, 40.0);
	}
	
	public void drawUmbrella(GraphicsContext g) {
		 g.drawImage(animation.getUmbrella(), 450.0, 435.0, 35.0, 35.0);
	}

	public Rectangle2D getHatBoundingBox() {
		return hatBoundingBox;
	}
	
	

}
