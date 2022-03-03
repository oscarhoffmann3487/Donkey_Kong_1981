package Level1;


import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cape { 
	private Rectangle2D capeBoundingBox;
	private Animation animation;

	
	public Cape(Model model) {

		capeBoundingBox = new Rectangle2D(20.0, 525.0, 35.0, 35.0);
		animation = new Animation(model);

	}

	public void drawCape(GraphicsContext g) {
		
		 g.drawImage(animation.getCape(), 20.0, 525.0, 35.0, 35.0);
	}
	

	public Rectangle2D getCapeBoundingBox() {
		return capeBoundingBox;
	}
}
