package Level1;


import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;


public class DonkeyKong {
	private double x = 30.0;
	private double y = 115.0;
	private Rectangle2D donkeyKongBoundingBox;
	private Animation animation;
	private String movement;
	
	
	public DonkeyKong(Model model) {
			setDonkeyKongBoundingBox(new Rectangle2D(x, y, 60.0, 60.0));
			animation = new Animation(model);
		}
	
	public void drawDonkeyKong(GraphicsContext g) {
		if (movement == "pickUp") {
			g.drawImage(animation.getDonkeyKongPickUpLeft(), x, y, 60.0, 60.0);
		}else {
			g.drawImage(animation.getDonkeyKongAndBarrel(), x, y, 60.0, 60.0);
		}
		
	}

	public Rectangle2D getDonkeyKongBoundingBox() {
		return donkeyKongBoundingBox;
	}

	public void setDonkeyKongBoundingBox(Rectangle2D donkeyKongBoundingBox) {
		this.donkeyKongBoundingBox = donkeyKongBoundingBox;
	}

	public String getMovement() {
		return movement;
	}

	public void setMovement(String movement) {
		this.movement = movement;
	}
}