package States;

import java.io.FileInputStream;
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileNotFoundException;

import Logic.GameFrame;
import Logic.GamePanel;
import Logic.Model;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HasWon extends GameState {

	private Color bgColor;
	private Color fontColor1;
	private int finalScore;
	
	public HasWon(Model model, int finalScore) {
		super(model);
		this.finalScore = finalScore;
		bgColor = Color.BLACK;
		fontColor1 = Color.DARKBLUE;	
	}
	
	
	@Override
	public void update() throws FileNotFoundException {		
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);
		
	
		g.setFill(Color.RED);
		g.setFont(new Font(30)); // Big letters
		g.fillText("YOU WON", 60, 150);
		
		g.setFill(Color.RED);
		g.setFont(new Font(30)); // Big letters
		g.fillText("YOUR SCORE: ", 60, 200);
		g.fillText(String.valueOf(finalScore), 300, 200);
				
		g.setFill(fontColor1);
		g.fillRoundRect(100, 300, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("Main Menu", 190, 345);
		
		g.setFill(fontColor1);
		g.fillRoundRect(100, 400, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("HighScores", 190, 445);
		

		g.getCanvas().setOnMouseClicked(event -> {
			if(event.getX() <= 400 && event.getX() >= 100 && event.getY() >=300 && event.getY() <=380 ) {
					model.switchState(new Menu(model));
			}
		});
	
	}


	@Override
	public void keyPressed(KeyEvent key) {
			
	}
	
}

