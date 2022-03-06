package Level2;


import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;


public class Cape2 { 
	private Rectangle2D capeBoundingBox;
	private Animation animation;

	
	public Cape2(Model model) {

		capeBoundingBox = new Rectangle2D(170.0, 525.0, 35.0, 35.0);
		animation = new Animation(model);

	}

	public void drawCape(GraphicsContext g) {
		
		 g.drawImage(animation.getCape(), 170.0, 525.0, 35.0, 35.0);
	}
	

	public Rectangle2D getCapeBoundingBox() {
		return capeBoundingBox;
	}
}
