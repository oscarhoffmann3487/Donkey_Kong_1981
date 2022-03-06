package States;

import java.io.FileNotFoundException;

import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public class HighScore extends GameState {
	
	private Color bgColor; 
	private Color fontColor1;
	private double counter;

	public HighScore(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor1 = Color.WHITE;
	}

	@Override
	public void update(){
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);
		g.fillText("Press \"b\" to go back to main menu.", 20, 560);
	}

	@Override
	public void keyPressed(KeyEvent key) {
	
		if (key.getCode() == KeyCode.B) {
			model.switchState(new Menu(model));
	}
	
	}
	
	
}
