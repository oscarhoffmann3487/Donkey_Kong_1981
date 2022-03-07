package Level2;

import java.util.ArrayList;

import Logic.Model;
import constants.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Ladder2{

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

	public Ladder2(Model model) {
		//floor0
		Rectangle2D ladder0 = new Rectangle2D(25, floor1Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder1 = new Rectangle2D(450, floor1Y, ladderWidth-5, ladderHeight*2+15);
		//floor1
		Rectangle2D ladder2 = new Rectangle2D(55, floor2Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder3 = new Rectangle2D(420, floor2Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder4 = new Rectangle2D(230, floor2Y, ladderWidth-5, ladderHeight*2+15);
		//floor2
		Rectangle2D ladder5 = new Rectangle2D(85, floor3Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder6 = new Rectangle2D(380, floor3Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder7 = new Rectangle2D(265, floor3Y, ladderWidth-5, ladderHeight*2+15);
		//floor3
		Rectangle2D ladder8 = new Rectangle2D(115, floor4Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder9 = new Rectangle2D(350, floor4Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder10 = new Rectangle2D(190, floor4Y, ladderWidth-5, ladderHeight*2+15);
		//floor4
		Rectangle2D ladder11 = new Rectangle2D(142, floor5Y, ladderWidth-5, ladderHeight*2+15);
		Rectangle2D ladder12 = new Rectangle2D(325, floor5Y, ladderWidth-5, ladderHeight*2+15);
		//floor5
		Rectangle2D ladder13 = new Rectangle2D(175, floor6Y, ladderWidth-5, ladderHeight+15);
		
		
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
		ladderBoundaries.add(ladder8);
		ladderBoundaries.add(ladder9);
		ladderBoundaries.add(ladder10);
		ladderBoundaries.add(ladder11);
		ladderBoundaries.add(ladder12);
		ladderBoundaries.add(ladder13);

	}

	public ArrayList<Rectangle2D> getladderBoundaries() {
		return ladderBoundaries;
	}

	public void drawLadder(GraphicsContext g) {
		
		// Floor0
		g.drawImage(animation.getLadder2(), 20, floor0Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 20, floor0Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 445, floor0Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 445, floor0Y-ladderHeight, ladderWidth, ladderHeight);
		
		// Floor1
		g.drawImage(animation.getLadder2(), 50, floor1Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 50, floor1Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 415, floor1Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 415, floor1Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 225, floor1Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 225, floor1Y-ladderHeight, ladderWidth, ladderHeight);
		
		// Floor2
		g.drawImage(animation.getLadder2(), 80, floor2Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 80, floor2Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 375, floor2Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 375, floor2Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 260, floor2Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 260, floor2Y-ladderHeight, ladderWidth, ladderHeight);
		
		//FLoor3
		g.drawImage(animation.getLadder2(), 110, floor3Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 110, floor3Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 345, floor3Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 345, floor3Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 185, floor3Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 185, floor3Y-ladderHeight, ladderWidth, ladderHeight);
		
		//Floor4
		g.drawImage(animation.getLadder2(), 140, floor4Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 140, floor4Y-ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 325, floor4Y-2*ladderHeight, ladderWidth, ladderHeight);
		g.drawImage(animation.getLadder2(), 325, floor4Y-ladderHeight, ladderWidth, ladderHeight);
		
		//FLoor5
		g.drawImage(animation.getLadder2(), 170, floor5Y-55, ladderWidth, ladderHeight+15);
	}

}
