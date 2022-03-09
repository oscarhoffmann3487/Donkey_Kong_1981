package GeneralGraphics;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * PaulinesItem-class is used in both level1 and level2. Prints out all of
 * Paulines items.
 */
public class PaulinesItem {
	private Rectangle2D purseBox;
	private Rectangle2D hatBox;
	private Rectangle2D umbrellaBox;
	private Animation animation;

	public PaulinesItem(Model model) {

		purseBox = new Rectangle2D(220.0, 235.0, 25.0, 25.0);
		hatBox = new Rectangle2D(140.0, 342.0, 40.0, 40.0);
		umbrellaBox = new Rectangle2D(340.0, 435.0, 35.0, 35.0);
		animation = new Animation(model);

	}

	public void setUmbrellaBox(Rectangle2D umbrellaBoundingBox) {
		this.umbrellaBox = umbrellaBoundingBox;
	}

	public void setHatBox(Rectangle2D hatBoundingBox) {
		this.hatBox = hatBoundingBox;
	}

	public void setPurseBox(Rectangle2D purseBoundingBox) {
		this.purseBox = purseBoundingBox;
	}

	public Rectangle2D getPurseBox() {
		return purseBox;
	}

	public Rectangle2D getUmbrellaBox() {
		return umbrellaBox;
	}

	public void drawPurse(GraphicsContext g) {
		g.drawImage(animation.getPurse(), 220.0, 235.0, 25.0, 25.0);
	}

	public void drawHat(GraphicsContext g) {
		g.drawImage(animation.getHat(), 140.0, 342.0, 40.0, 40.0);
	}

	public void drawUmbrella(GraphicsContext g) {
		g.drawImage(animation.getUmbrella(), 340.0, 435.0, 35.0, 35.0);
	}

	public Rectangle2D getHatBox() {
		return hatBox;
	}

}
