package GeneralGraphics;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
/**
 * 
 * DonkeyKong-class decides how DonkeyKong is printed in both level1 and level2.
 * 
 */
public class DonkeyKong {
	private double x;
	private double y;
	private Rectangle2D donkeyKongBox;
	private Animation animation;
	private String movement;

	public DonkeyKong(Model model, double x, double y) {
		this.x = x;
		this.y = y;
		donkeyKongBox = (new Rectangle2D(x, y, 60.0, 60.0));
		animation = new Animation(model);
	}

	/**
	 * Draws DonkeyKong different depending on whether he picks up a barrel or not
	 * 
	 * @param g
	 */
	public void drawDonkeyKong(GraphicsContext g) {
		if (movement == "pickUp") {
			g.drawImage(animation.getDonkeyKongPickUpLeft(), x, y, 60.0, 60.0);
		} else {
			g.drawImage(animation.getDonkeyKongAndBarrel(), x, y, 60.0, 60.0);
		}
	}

	public Rectangle2D getDonkeyKongBox() {
		return donkeyKongBox;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}
}