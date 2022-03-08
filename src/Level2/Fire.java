package Level2;


import java.util.ArrayList;

import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Fire {
	private ArrayList<Rectangle2D> fireBoundaries;
	private int scale = 10;
	private int x1; 
	private int counter = 0;
	private Animation animation;
	private ArrayList<Rectangle2D> floors; 
	private Rectangle2D fire0;
	
	
	
	public Fire(Model model, ArrayList<Rectangle2D> floors, int x1) {
			fire0 = new Rectangle2D(x1, 546, scale, scale);
			
		//	fire2 = new Rectangle2D(285, 345, scale, scale);
		//	fire3 = new Rectangle2D(195, 445, scale, scale);
					
			fireBoundaries = new ArrayList<>();
			this.x1 = x1; 
			
			animation = new Animation(model);
			
			fireBoundaries.add(new Rectangle2D(x1, 546, scale, scale));
		//	fireBoundaries.add(fire2);
		//	fireBoundaries.add(fire3);
	
			this.floors = floors;
			animation = new Animation(model);
		}
	
	public ArrayList<Rectangle2D> getFireBoundaries() {
		return fireBoundaries;
	}
	
	public void rollingFire() {
		if  (fire0.intersects(floors.get(1))) {
			counter +=1; 
			if (counter > 0  && counter < 400) {
				x1 += 1;
			} else if (counter > 400 && counter < 800) {
				x1 -= 1;
			} else if (counter > 800) {
				counter = 0;
			}
		}
	}
	
	public void update() {
		rollingFire();
		System.out.println(x1);
		System.out.println(fire0);
		fire0 = new Rectangle2D(x1, 546, scale, scale);
	}
	

	public void drawFire(GraphicsContext g) {
		g.setFill(Color.WHITE);
		g.fillRect(x1, 546, scale, scale);
	//	g.drawImage(animation.getFire(), x1, 540, 15, 15);
	//	g.drawImage(animation.getFire(), 280, 340, 15, 15);
	//	g.drawImage(animation.getFire(), 190, 440, 15, 15);
	}

	
}