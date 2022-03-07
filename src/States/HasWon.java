package States;

import java.io.FileNotFoundException;
import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
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

