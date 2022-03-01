package States;

import java.io.FileNotFoundException;

import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverMenu extends GameState {

	private Menu menu;
	private Color bgColor;
	private Color fontColor1;
	
	public GameOverMenu(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor1 = Color.WHITE;
		
	//	menu = new Menu(model);
		
	}
	@Override
	public void update() throws FileNotFoundException {
			
	}
	
	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);
		g.setFont(new Font(30)); // Big letters
		g.fillText("GAME OVER", 40, 400);
		
	}
	@Override
	public void keyPressed(KeyEvent key) {
		if (key.getCode() == KeyCode.ESCAPE) {
			model.switchState(menu);
		}
		
	}

}
