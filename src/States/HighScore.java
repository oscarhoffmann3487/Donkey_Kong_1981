package States;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HighScore extends GameState {
	
	private Color bgColor; 
	private Color fontColor1;
	private Scanner scanner;
	private String score;
	private HashMap<String, Integer> highScoreMap;

	public HighScore(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor1 = Color.WHITE;
		highScoreMap = new HashMap<>();
		
		try {
			
		Scanner scanner = new Scanner(new File("highscores.txt"));
		this.scanner = scanner;
	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while (scanner.hasNext()) {
			 score = scanner.next();
			
		}
		scanner.close(); 	
	}

	@Override
	public void update(){
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);
		g.setFont(new Font(20)); // Big letters
	
		g.fillText(score, 350, 300);
		
		
		
		g.fillText("Press \"b\" to go back to main menu.", 20, 560);
	}

	@Override
	public void keyPressed(KeyEvent key) {
		
		if (key.getCode() == KeyCode.B) {
			model.switchState(new Menu(model));
	}
	
	}
	
	
}
