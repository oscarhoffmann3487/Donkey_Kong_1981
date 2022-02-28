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

public class Floor {

	private Image floor;
	private ArrayList<Rectangle2D> floorBoundaries;

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


		// Inläsning av bildfilen
		try {
			floor = new Image(new FileInputStream("floor.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

	}

	public ArrayList<Rectangle2D> getFloorBoundaries() {
		return floorBoundaries;
	}

	public void drawFloor(GraphicsContext g) {
		int floorHeight = 15;
		int floorWidth = 300;
		g.setFill(Color.WHITE);
		
		/*
		 * g.fillRect(0.0, 655.0, 500.0, 15.0); g.fillRect(0.0, 555.0, 400.0, 15.0);
		 * g.fillRect(100.0, 455.0, 400.0, 15.0); g.fillRect(0.0, 355.0, 300.0, 15.0);
		 * g.fillRect(100.0, 255.0, 400.0, 15.0); g.fillRect(0.0, 155.0, 400.0, 15.0);
		 * g.fillRect(350.0, 100.0, 150.0, 15.0);
		 */
		
		// Floor0
		g.drawImage(floor, 0, 655, floorWidth, floorHeight);
		g.drawImage(floor, 250, 655, floorWidth, floorHeight);
		// Floor1
		g.drawImage(floor, 0, 555, floorWidth, floorHeight);
		g.drawImage(floor, 100, 555, floorWidth, floorHeight);
		// Floor2
		g.drawImage(floor, 100, 455, floorWidth, floorHeight);
		g.drawImage(floor, 250, 455, floorWidth, floorHeight);
		// Floor3
		g.drawImage(floor, 0, 355, floorWidth, floorHeight);
		// Floor4
		g.drawImage(floor, 100, 255, floorWidth, floorHeight);
		g.drawImage(floor, 250, 255, floorWidth, floorHeight);
		// Floor5
		g.drawImage(floor, 0, 155, floorWidth, floorHeight);
		g.drawImage(floor, 100, 155, floorWidth, floorHeight);
		// Floor6
		g.drawImage(floor, 350, 100, floorWidth, floorHeight);

	}

}