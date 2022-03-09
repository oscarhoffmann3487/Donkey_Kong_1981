package GeneralGraphics;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * This class is used in both level1 and level1. Decides where the cape is
 * placed and which size.
 *
 */
public class Cape {
	private Rectangle2D capeBox;
	private Animation animation;

	public Cape(Model model) {
		capeBox = new Rectangle2D(20.0, 525.0, 35.0, 35.0);
		animation = new Animation(model);
	}

	public void drawCape(GraphicsContext g) {
		g.drawImage(animation.getCape(), 20.0, 525.0, 35.0, 35.0);
	}

	public Rectangle2D getCapeBox() {
		return capeBox;
	}
}
