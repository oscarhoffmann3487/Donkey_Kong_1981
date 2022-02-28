package Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import States.Level1;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Floor{

	private Image floor;
	public Floor(Model model) {
		

		try {
			floor = new Image(new FileInputStream("floor.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

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