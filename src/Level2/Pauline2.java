package Level2;


import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Pauline2{
	private double x = 260.0;
	private double y = 55.0;
	private Animation animation;
	private Rectangle2D paulineBoundingBox;
	
	
	public Pauline2(Model model) {
			animation = new Animation(model);
			paulineBoundingBox = new Rectangle2D(x, y, 30.0, 30.0);
			
		}
	
	public void drawPauline(GraphicsContext g) {
		g.drawImage(animation.getPauline(), x, y, 50.0, 50.0);
	}

	public Rectangle2D getPaulineBoundingBox() {
		return paulineBoundingBox;
	}

}
