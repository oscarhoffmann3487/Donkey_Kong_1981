package Level2;
import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class PaulinesItem2 { 
	private Rectangle2D purseBoundingBox;
	private Rectangle2D hatBoundingBox;
	private Rectangle2D umbrellaBoundingBox;
	private Animation animation;

	public PaulinesItem2(Model model) {
		purseBoundingBox = new Rectangle2D(220.0, 235.0, 25.0, 25.0);
		hatBoundingBox = new Rectangle2D(120.0, 342.0, 40.0, 40.0);
		umbrellaBoundingBox = new Rectangle2D(340.0, 435.0, 35.0, 35.0);
		animation = new Animation(model);

	}

	public Rectangle2D getPurseBoundingBox() {
		return purseBoundingBox;
	}

	public Rectangle2D getUmbrellaBoundingBox() {
		return umbrellaBoundingBox;
	}
	
	public void drawPurse(GraphicsContext g) {
		 g.drawImage(animation.getPurse(), 220.0, 235.0, 25.0, 25.0);
	}
	
	public void drawHat(GraphicsContext g) {	
		 g.drawImage(animation.getHat(), 120.0, 342.0, 40.0, 40.0);
	}
	
	public void drawUmbrella(GraphicsContext g) {
		 g.drawImage(animation.getUmbrella(), 340.0, 435.0, 35.0, 35.0);
	}

	public Rectangle2D getHatBoundingBox() {
		return hatBoundingBox;
	}
	
}
