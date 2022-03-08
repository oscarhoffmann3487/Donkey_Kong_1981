package Level1;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Pauline is used in both level1 and level2. Her coordinates remain the same
 * during the game but differ from level1 and level2.
 *
 *
 */
public class Pauline {
	private double x;
	private double y;
	private Animation animation;
	private Rectangle2D paulineBox;

	public Pauline(Model model, double x, double y) {
		this.x = x;
		this.y = y;
		animation = new Animation(model);
		paulineBox = new Rectangle2D(x, y, 30.0, 30.0);

	}

	public void drawPauline(GraphicsContext g) {
		g.drawImage(animation.getPauline(), x, y, 50.0, 50.0);
	}

	public Rectangle2D getPaulineBox() {
		return paulineBox;
	}

}