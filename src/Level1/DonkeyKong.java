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
	
	
	public DonkeyKong(Model model) {
			
			setDonkeyKongBoundingBox(new Rectangle2D(x, y, 60.0, 60.0));
			animation = new Animation(model);
		}
	
	public void drawDonkeyKong(GraphicsContext g) {
		g.drawImage(animation.getDonkeyKongAndBarrel(), x, y, 60.0, 60.0);
		
	}

	public Rectangle2D getDonkeyKongBoundingBox() {
		return donkeyKongBoundingBox;
	}

	public void setDonkeyKongBoundingBox(Rectangle2D donkeyKongBoundingBox) {
		this.donkeyKongBoundingBox = donkeyKongBoundingBox;
	}
}