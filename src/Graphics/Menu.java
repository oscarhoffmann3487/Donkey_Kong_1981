package Graphics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Logic.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Menu extends GameState {

	
	 private Level1 level1;

	private String informationText;
	private Color bgColor;
	private Color fontColor;

	public Menu(Model model) {
		super(model);
		informationText = "Press Enter To Play\nEscape to exit";
		bgColor = Color.BLACK;
		fontColor = Color.WHITE;
		level1 = new Level1(model);

	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor);
		g.setFont(new Font(30)); // Big letters
	    g.fillText(informationText, 600/2, 400);
	
	    
		Image cover = new Image(new FileInputStream("Images\\donkeykong.png")); 		
		g.drawImage(cover, 0, 0);		
	}
	

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getText() + " i Menu");

		if (key.getCode() == KeyCode.ENTER) {
			model.switchState(level1);
		} else if (key.getCode() == KeyCode.ESCAPE) {
			System.exit(0);
		}

	}

	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
