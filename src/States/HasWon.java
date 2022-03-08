package States;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HasWon extends GameState {

	private Color bgColor;
	private Color fontColor1;
	private int finalScore;
	private String letter;
	private ArrayList<String> nameList;

	public HasWon(Model model, int finalScore) {
		super(model);
		this.finalScore = finalScore;
		bgColor = Color.BLACK;
		fontColor1 = Color.DARKBLUE;
		nameList = new ArrayList<>();
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
		g.fillText("YOU WON!", 60, 150);

		g.setFill(Color.RED);
		g.setFont(new Font(30)); // Big letters
		g.fillText("YOUR SCORE:", 60, 200);
		g.setFill(Color.WHITE);
		g.fillText(String.valueOf(finalScore), 300, 200);

		g.setFont(new Font(30)); // Big letters
		g.fillText("Please enter your name: ", 80, 300);

		g.setFont(new Font(30)); // Big letters
	
		
		
//		g.fillText(nameList.get(1), 90, 400);
//		g.fillText(nameList.get(2), 100, 400);
//		g.fillText(nameList.get(3), 110, 400);
//		g.fillText(nameList.get(4), 120, 400);
//		g.fillText(nameList.get(5), 130, 400);
//		g.fillText(nameList.get(6), 140, 400);
//		g.fillText(nameList.get(7), 150, 400);
//		g.fillText(nameList.get(8), 160, 400);
//		g.fillText(nameList.get(9), 170, 400);
//		g.fillText(nameList.get(10), 180, 400);
//		g.fillText(nameList.get(11), 190, 400);
//		g.fillText(nameList.get(12), 200, 400);
//		g.fillText(nameList.get(13), 210, 400);
		
		g.setFill(fontColor1);
		g.fillRoundRect(100, 400, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("Main Menu", 190, 450);

		
		g.getCanvas().setOnMouseClicked(event -> {
			if (event.getX() <= 400 && event.getX() >= 100 && event.getY() >= 300 && event.getY() <= 380) {
				model.switchState(new Menu(model));
			}
		});
	}

	public void saveName() {
		try {
			FileWriter writer = new FileWriter(new File("highscores.txt"), true);
			writer.write(letter);
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public void saveScore() {
		try {
			FileWriter writer = new FileWriter(new File("highscores.txt"), true);
			writer.write(String.valueOf(finalScore));
			writer.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public void keyPressed(KeyEvent key) {
		letter = key.getText();
		saveName();
		nameList.add(letter);
		
		if (key.getCode() == KeyCode.ENTER) {
			saveScore();
	//	}else if((key.getCode() == KeyCode.BACK_SPACE){
			//nameList.
		}
	}
}