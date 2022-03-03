package Level1;

import java.util.ArrayList;

import Logic.Model;
import constants.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;


public class Barrels {

	private double x = 35.0;
	private double y = 135.0;
	public double getY() {
		return y;
	}

	private double scale = 20.0;
	private Rectangle2D barrelBoundingBox;
	private ArrayList<Rectangle2D> floors;
	private Animation animation; 

	
	public Barrels(Model model, ArrayList<Rectangle2D> floorBoundaries) {
		this.floors = floorBoundaries;
		barrelBoundingBox = new Rectangle2D(x, y, scale, scale);
		animation = new Animation(model);
		
	}
	
	
	public void drawBarrel(GraphicsContext g) {
		g.drawImage(animation.getBarrel(), x, y, scale, scale);
	}
		
	public boolean barrelFloorRight() {
		if (barrelBoundingBox.intersects(floors.get(1))) {
			return true;
		} else if (barrelBoundingBox.intersects(floors.get(3))) {
			return true;
		} else if (barrelBoundingBox.intersects(floors.get(5))) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean barrelFloorLeft() {
		if (barrelBoundingBox.intersects(floors.get(0))) {
			return true;
		} else if (barrelBoundingBox.intersects(floors.get(2))) {
			return true;
		} else if (barrelBoundingBox.intersects(floors.get(4))) {
			return true;
		}else {
			return false;
		}
	}
	
	public void rollingBarrels() {
		if (barrelFloorRight()) {
			x += 2;
		} else if  (barrelFloorLeft()) {
			x -= 2;
		} else {
			y += 2;
		}
	}
		
	public Rectangle2D getBarrelBoundingBox() {
		return barrelBoundingBox;
	}

	public void setBarrelBoundingBox(Rectangle2D barrelBoundingBox) {
		this.barrelBoundingBox = barrelBoundingBox;
	}

	public void update() {
		rollingBarrels();
		barrelBoundingBox = new Rectangle2D(x, y, scale, scale);
		
	}
}