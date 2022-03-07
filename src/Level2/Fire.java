package Level2;


import java.util.ArrayList;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;


public class Fire {
	private ArrayList<Rectangle2D> fireBoundaries;
	private double x = 225;
	private double y = 115.0;
	private int scale = 20;
	private Animation animation;
	
	
	
	public Fire(Model model) {
			Rectangle2D fire0 = new Rectangle2D(120, 535, scale, scale);
			Rectangle2D fire1 = new Rectangle2D(300, 535, scale, scale);
			Rectangle2D fire2 = new Rectangle2D(280, 335, scale, scale);
			Rectangle2D fire3 = new Rectangle2D(190, 435, scale, scale);
			Rectangle2D fire4 = new Rectangle2D(270, 235,scale, scale);
			

			fireBoundaries = new ArrayList<>();
			
			animation = new Animation(model);
			
			fireBoundaries.add(fire0);
			fireBoundaries.add(fire1);
			fireBoundaries.add(fire2);
			fireBoundaries.add(fire3);
			fireBoundaries.add(fire4);
	
			
			animation = new Animation(model);
		}
	
	public ArrayList<Rectangle2D> getFireBoundaries() {
		return fireBoundaries;
	}

	public void drawFire(GraphicsContext g) {
		g.drawImage(animation.getFire(), 120, 535, scale, scale);
		g.drawImage(animation.getFire(), 300, 535, scale, scale);
		g.drawImage(animation.getFire(), 280, 335, scale, scale);
		g.drawImage(animation.getFire(), 190, 435, scale, scale);
		g.drawImage(animation.getFire(), 270, 235, scale, scale);
	}

	
}