package Level1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Logic.Model;
import constants.Animation;
import javafx.geometry.BoundingBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Ladder{

	private ArrayList<Rectangle2D> ladderBoundaries;
	private Animation animation;
	double ladderWidth = 15.0;
	double ladderHeight = 43.0;
	double floor0Y = 655.0;
	double floor1Y = 555.0;
	double floor2Y = 455.0;
	double floor3Y = 355.0;
	double floor4Y = 255.0;
	double floor5Y = 155.0;
	double floor6Y = 100.0;

	public Ladder(Model model) {
		//floor0
		Rectangle2D ladder0 = new Rectangle2D(305, floor1Y, ladderWidth, ladderHeight*2+15);
		//floor1
		Rectangle2D ladder1 = new Rectangle2D(105, floor2Y, ladderWidth, ladderHeight*2+15);
		Rectangle2D ladder2 = new Rectangle2D(225, floor2Y, ladderWidth, ladderHeight*2+15);
		//floor2
		Rectangle2D ladder3 = new Rectangle2D(170, floor3Y, ladderWidth, ladderHeight*2+15);
		//floor3
		Rectangle2D ladder4 = new Rectangle2D(255, floor4Y, ladderWidth, ladderHeight*2+15);
		//floor4
		Rectangle2D ladder5 = new Rectangle2D(185, floor5Y, ladderWidth, ladderHeight*2+15);
		Rectangle2D ladder6 = new Rectangle2D(315, floor5Y, ladderWidth, ladderHeight*2+15);
		//floor5
		Rectangle2D ladder7 = new Rectangle2D(365, floor6Y, ladderWidth, ladderHeight+15);
		
		ladderBoundaries = new ArrayList<>();
		
		animation = new Animation(model);
		
		ladderBoundaries.add(ladder0);
		ladderBoundaries.add(ladder1);
		ladderBoundaries.add(ladder2);
		ladderBoundaries.add(ladder3);
		ladderBoundaries.add(ladder4);
		ladderBoundaries.add(ladder5);
		ladderBoundaries.add(ladder6);
		ladderBoundaries.add(ladder7);

	}

	public ArrayList<Rectangle2D> getladderBoundaries() {
		return ladderBoundaries;
	}

	public void drawLadder(GraphicsContext g) {

		// Floor0
		g.drawImage(animation.getLadder(), 305, floor0Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 305, floor0Y-ladderHeight, ladderWidth, ladderHeight);
		
		// Floor1
		g.drawImage(animation.getLadder(), 105, floor1Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 105, floor1Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 225, floor1Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 225, floor1Y-ladderHeight, ladderWidth, ladderHeight);
		
		// Floor2
		g.drawImage(animation.getLadder(), 170, floor2Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 170, floor2Y-ladderHeight, ladderWidth, ladderHeight);
		
		//FLoor3
		g.drawImage(animation.getLadder(), 255, floor3Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 255, floor3Y-ladderHeight, ladderWidth, ladderHeight);
		
		//Floor4
		g.drawImage(animation.getLadder(), 185, floor4Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 185, floor4Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 315, floor4Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder(), 315, floor4Y-ladderHeight, ladderWidth, ladderHeight);
		
		//FLoor5
		g.drawImage(animation.getLadder(), 365, floor5Y-ladderHeight, ladderWidth, ladderHeight);


	}

}
