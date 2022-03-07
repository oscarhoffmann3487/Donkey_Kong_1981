package Level1;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class DonkeyKong {
	private double x = 30.0;
	private double y = 115.0;
	private Rectangle2D donkeyKongBox;
	private Animation animation;
	private String movement;

	public DonkeyKong(Model model) {
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