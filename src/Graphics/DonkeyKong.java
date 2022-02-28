package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class DonkeyKong {
	private double x = 30.0;
	private double y = 105.0;
	private Image donkeyCenter;
	private Rectangle2D donkeyKongBoundingBox;
	
	
	public DonkeyKong(Model model) {
		
			
			setDonkeyKongBoundingBox(new Rectangle2D(x, y, 50.0, 50.0));
			try {
				donkeyCenter = new Image(new FileInputStream("donkeyCenter.png"));
				
			} catch (FileNotFoundException e) {
				System.out.println("Unable to find image-files!");
			}
		}
	
	public void drawDonkeyKong(GraphicsContext g) {
		g.drawImage(donkeyCenter, x, y, 50.0, 50.0);
		
	}

	public Rectangle2D getDonkeyKongBoundingBox() {
		return donkeyKongBoundingBox;
	}

	public void setDonkeyKongBoundingBox(Rectangle2D donkeyKongBoundingBox) {
		this.donkeyKongBoundingBox = donkeyKongBoundingBox;
	}
}