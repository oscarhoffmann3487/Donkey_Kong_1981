package States;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import Logic.Model;
import constants.Animation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HasWon extends GameState {

	private Color bgColor;
	private Color fontColor1;
	private int finalScore;
	private Scanner scanner;
	private int currentHighscore;
	private Animation animation;
	
	public HasWon(Model model, int finalScore) {
		super(model);
		this.finalScore = finalScore;
		bgColor = Color.BLACK;
		fontColor1 = Color.DARKBLUE;
		animation = new Animation(model);
		
	}

	@Override
	public void update() throws FileNotFoundException {

	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);

		g.drawImage(animation.getYouWin(), 30, 0, 400, 400);
		g.setFill(Color.RED);
		g.setFont(new Font(30)); // Big letters
		g.fillText("YOUR SCORE:", 100, 300);
		g.setFill(Color.WHITE);
		g.fillText(String.valueOf(finalScore), 340, 300);
	
		g.setFill(fontColor1);
		g.fillRoundRect(100, 400, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("Main Menu", 190, 450);

		
		g.getCanvas().setOnMouseClicked(event -> {
			if (event.getX() <= 400 && event.getX() >= 100 && event.getY() >= 400 && event.getY() <= 480) {
				model.switchState(new Menu(model));
			}
		});

	}
	
	public boolean checkIfNewHighscore(int finalscore) {
		
		try {
			scanner = new Scanner(new File("highscores.txt"));
			while (scanner.hasNext()) {
				 currentHighscore = scanner.nextInt();
			}
			scanner.close(); 	
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		if(finalscore > currentHighscore) {
			System.out.println("yes");
			return true;
		}else {
	
		return false;
		}
	}
		
	public void saveScore(int finalScores) {
		try {
			FileWriter writer = new FileWriter(new File("highscores.txt"));
			writer.write(String.valueOf(finalScores));
			writer.close();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}


	@Override
	public void keyPressed(KeyEvent key) {

		}
	}
