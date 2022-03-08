package Level1;

import java.util.ArrayList;

import Logic.Model;
import constants.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.paint.Color;

/**
 * This class takes care of all the floors in level1. Every floor has a
 * Rectangle2D surrounding them.
 *
 */
public class Floor {

	private ArrayList<Rectangle2D> floorBoundaries;
	private Animation animation;

	public Floor(Model model) {
		Rectangle2D floor0 = new Rectangle2D(0.0, 655.0, 500.0, 15.0);
		Rectangle2D floor1 = new Rectangle2D(0.0, 555.0, 400.0, 15.0);
		Rectangle2D floor2 = new Rectangle2D(100.0, 455.0, 400.0, 15.0);
		Rectangle2D floor3 = new Rectangle2D(0.0, 355.0, 300.0, 15.0);
		Rectangle2D floor4 = new Rectangle2D(100.0, 255.0, 400.0, 15.0);
		Rectangle2D floor5 = new Rectangle2D(0.0, 155.0, 400.0, 15.0);
		Rectangle2D floor6 = new Rectangle2D(350.0, 100.0, 150.0, 15.0);

		floorBoundaries = new ArrayList<>();

		floorBoundaries.add(floor0);
		floorBoundaries.add(floor1);
		floorBoundaries.add(floor2);
		floorBoundaries.add(floor3);
		floorBoundaries.add(floor4);
		floorBoundaries.add(floor5);
		floorBoundaries.add(floor6);

		animation = new Animation(model);

	}

	public ArrayList<Rectangle2D> getFloorBoundaries() {
		return floorBoundaries;
	}

	public void drawFloor(GraphicsContext g) {
		int floorHeight = 15;
		int floorWidth = 300;
		g.setFill(Color.WHITE);

		// Floor0
		g.drawImage(animation.getFloor(), 0, 655, floorWidth, floorHeight);
		g.drawImage(animation.getFloor(), 250, 655, floorWidth, floorHeight);
		// Floor1
		g.drawImage(animation.getFloor(), 0, 555, floorWidth, floorHeight);
		g.drawImage(animation.getFloor(), 100, 555, floorWidth, floorHeight);
		// Floor2
		g.drawImage(animation.getFloor(), 100, 455, floorWidth, floorHeight);
		g.drawImage(animation.getFloor(), 250, 455, floorWidth, floorHeight);
		// Floor3
		g.drawImage(animation.getFloor(), 0, 355, floorWidth, floorHeight);
		// Floor4
		g.drawImage(animation.getFloor(), 100, 255, floorWidth, floorHeight);
		g.drawImage(animation.getFloor(), 250, 255, floorWidth, floorHeight);
		// Floor5
		g.drawImage(animation.getFloor(), 0, 155, floorWidth, floorHeight);
		g.drawImage(animation.getFloor(), 100, 155, floorWidth, floorHeight);
		// Floor6
		g.drawImage(animation.getFloor(), 350, 100, floorWidth, floorHeight);

	}

}