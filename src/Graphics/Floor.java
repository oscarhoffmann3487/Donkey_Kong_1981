package Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Logic.Model;
import States.Level1;
import javafx.geometry.BoundingBox;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Floor{

	private Image floor;
	private Rectangle2D floor1;
	
			
	public Floor(Model model) { 
		floor1 = new Rectangle2D(0.0, 655.0, 500.0, 15.0);
		//Rectangle2D floor2 = new Rectangle2D(250, 655, 15, 300);
	//	Rectangle2D floor3 = new Rectangle2D(0, 555, 15, 300);
		
		try {
			floor = new Image(new FileInputStream("floor.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

	}

	public Rectangle2D getFloor1() {
		return floor1;
	}

	public void setFloor1(Rectangle2D floor1) {
		this.floor1 = floor1;
	}

	public void drawFloor(GraphicsContext g) {
				
		int floorHeight = 15; 
		int floorWidth = 300;
		
		g.drawImage(floor, 0, 655, floorWidth, floorHeight);
		g.drawImage(floor, 250, 655, floorWidth, floorHeight);
		g.drawImage(floor, 0, 555, floorWidth, floorHeight);
		g.drawImage(floor, 100, 555, floorWidth, floorHeight);
		g.drawImage(floor, 100, 455, floorWidth, floorHeight);
		g.drawImage(floor, 250, 455, floorWidth, floorHeight);
		g.drawImage(floor, 0, 355, floorWidth, floorHeight);
		g.drawImage(floor, 100, 255, floorWidth, floorHeight);
		g.drawImage(floor, 100, 255, floorWidth, floorHeight);
		g.drawImage(floor, 250, 255, floorWidth, floorHeight);
		
	}

}