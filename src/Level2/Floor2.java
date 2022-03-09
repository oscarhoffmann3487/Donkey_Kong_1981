package Level2;

import java.util.ArrayList;
import Logic.Model;
import constants.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

/**
 * Creates floors in the same way as in the Floor-class. The difference is that
 * level2 has a different animation and the floors are not placed the same.
 */
public class Floor2 {

	private ArrayList<Rectangle2D> floorBoundaries;
	private Animation animation;

	public Floor2(Model model) {
		Rectangle2D floor0 = new Rectangle2D(0.0, 655.0, 500.0, 15.0);
		Rectangle2D floor1 = new Rectangle2D(20.0, 555.0, 440.0, 15.0);
		Rectangle2D floor2 = new Rectangle2D(50.0, 455.0, 380.0, 15.0);
		Rectangle2D floor3 = new Rectangle2D(80.0, 355.0, 310.0, 15.0);
		Rectangle2D floor4 = new Rectangle2D(110.0, 255.0, 250.0, 15.0);
		Rectangle2D floor5 = new Rectangle2D(140.0, 155.0, 200.0, 15.0);
		Rectangle2D floor6 = new Rectangle2D(170.0, 100.0, 140.0, 15.0);

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

		// Floor0
		g.drawImage(animation.getFloor2(), 0, 655, floorWidth, floorHeight);
		g.drawImage(animation.getFloor2(), 250, 655, floorWidth, floorHeight);

		// Floor1
		g.drawImage(animation.getFloor2(), 20, 555, floorWidth, floorHeight);
		g.drawImage(animation.getFloor2(), 160, 555, floorWidth, floorHeight);

		// Floor2
		g.drawImage(animation.getFloor2(), 50, 455, floorWidth, floorHeight);
		g.drawImage(animation.getFloor2(), 130, 455, floorWidth, floorHeight);

		// Floor3
		g.drawImage(animation.getFloor2(), 80, 355, floorWidth + 10, floorHeight);

		// Floor4
		g.drawImage(animation.getFloor2(), 110, 255, floorWidth - 50, floorHeight);

		// Floor5
		g.drawImage(animation.getFloor2(), 140, 155, floorWidth - 100, floorHeight);
		// Floor6
		g.drawImage(animation.getFloor2(), 170, 100, floorWidth - 160, floorHeight);

	}

}