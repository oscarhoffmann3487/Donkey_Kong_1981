package States;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Highschore-class presents the highest score in the game. This will be updated
 * if a player receives a better score than current highscore.
 * 
 * @author
 *
 */
public class HighScore extends GameState {

	private Color bgColor;
	private Color fontColor1;
	private Scanner scanner;
	private String score;

	public HighScore(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor1 = Color.DARKBLUE;

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
	public void update() {
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);

		g.setFill(Color.RED);
		g.setFont(new Font(50));
		g.fillText("HIGHSCORE", 100, 150);
		g.setFill(Color.WHITE);
		g.setFont(new Font(30));
		g.fillText(score, 100, 200);

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

	@Override
	public void keyPressed(KeyEvent key) {
	}
}
