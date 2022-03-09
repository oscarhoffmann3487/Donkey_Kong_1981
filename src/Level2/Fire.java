package Level2;

import java.util.ArrayList;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Fire-class creates fire-elements in level2. If mario intersects one of these
 * he dies.
 * 
 * @author Julia
 *
 */

public class Fire {
	private int scale = 10;
	private int x1;
	private int x2;
	private int x3;
	private int counter = 0;
	private int counter1 = 0;
	private int counter2 = 0;
	private Animation animation;
	private Rectangle2D fire0;
	private Rectangle2D fire1;
	private Rectangle2D fire2;

	public Fire(Model model, ArrayList<Rectangle2D> floors, int x1, int x2, int x3) {
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;

		fire0 = new Rectangle2D(x1, 546, scale, scale);
		fire1 = new Rectangle2D(x2, 446, scale, scale);
		fire2 = new Rectangle2D(x3, 346, scale, scale);

		animation = new Animation(model);

	}

	public Rectangle2D getFire0() {
		return fire0;
	}

	public Rectangle2D getFire1() {
		return fire1;
	}

	public Rectangle2D getFire2() {
		return fire2;
	}

	public void rollingFire() {
		counter += 1;
		counter1 += 1;
		counter2 += 1;

		if (counter > 0 && counter < 400) {
			x1 += 1;
		} else if (counter > 400 && counter < 800) {
			x1 -= 1;
		} else if (counter > 800) {
			counter = 0;
		}

		if (counter1 > 0 && counter1 < 300) {
			x2 -= 1;
		} else if (counter1 > 300 && counter1 < 600) {
			x2 += 1;
		} else if (counter1 > 600) {
			counter1 = 0;

		}

		if (counter2 > 0 && counter2 < 150) {
			x3 += 1;
		} else if (counter2 > 150 && counter2 < 300) {
			x3 -= 1;
		} else if (counter2 > 300) {
			counter2 = 0;

		}
	}

	public void update() {
		rollingFire();
		fire0 = new Rectangle2D(x1, 546, scale, scale);
		fire1 = new Rectangle2D(x2, 446, scale, scale);
		fire2 = new Rectangle2D(x3, 346, scale, scale);
	}

	public void drawFire(GraphicsContext g) {
		g.drawImage(animation.getFire(), x1, 530, 25, 25);
		g.drawImage(animation.getFire(), x2, 430, 25, 25);
		g.drawImage(animation.getFire(), x3, 330, 25, 25);
	}

}