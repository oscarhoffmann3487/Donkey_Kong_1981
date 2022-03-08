package Level1;

import java.util.ArrayList;

import Logic.Model;
import constants.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * 
 * Barrels-class decides how the barrels and the stack of barrels will be
 * printed in both level1 and level2.The class has methods to control where the
 * barrels are located and according to this decide how they should roll.
 *
 */
public class Barrels {

	private double x;
	private double y;
	private double stackX;
	private double stackY;

	private double scale = 20.0;
	private Rectangle2D barrelBox;
	private ArrayList<Rectangle2D> floors;
	private Animation animation;

	public Barrels(Model model, ArrayList<Rectangle2D> floorBoundaries, double x, double y, double stackX,
			double stackY) {
		this.x = x;
		this.y = y;
		this.stackX = stackX;
		this.stackY = stackY;
		this.floors = floorBoundaries;
		barrelBox = new Rectangle2D(x, y, scale, scale);
		animation = new Animation(model);

	}

	public void drawBarrel(GraphicsContext g) {
		g.drawImage(animation.getBarrel(), x, y, scale, scale);
	}

	public void drawBarrelStack(GraphicsContext g) {
		g.drawImage(animation.getBarrelStack(), stackX, stackY, 45, 45);
	}

	/**
	 * This method returns true if the barrelBox is on floor 1, 3 or 5
	 * 
	 * @return
	 */
	public boolean barrelFloorRight() {
		if (barrelBox.intersects(floors.get(1))) {
			return true;
		} else if (barrelBox.intersects(floors.get(3))) {
			return true;
		} else if (barrelBox.intersects(floors.get(5))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method returns true if the barrelBox is on floor 0, 2, 4
	 * 
	 * @return
	 */
	public boolean barrelFloorLeft() {
		if (barrelBox.intersects(floors.get(0))) {
			return true;
		} else if (barrelBox.intersects(floors.get(2))) {
			return true;
		} else if (barrelBox.intersects(floors.get(4))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * rollingBarrels controls if the barrel should move left or right, otherwise
	 * fall down.
	 */
	public void rollingBarrels() {
		if (barrelFloorRight()) {
			x += 2;
		} else if (barrelFloorLeft()) {
			x -= 2;
		} else {
			y += 2;
		}
	}

	public Rectangle2D getBarrelBox() {
		return barrelBox;
	}

	public void setBarrelBox(Rectangle2D barrelBoundingBox) {
		this.barrelBox = barrelBoundingBox;
	}

	public void update() {
		rollingBarrels();
		barrelBox = new Rectangle2D(x, y, scale, scale);
	}
}
