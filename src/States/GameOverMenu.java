package States;

import java.io.FileNotFoundException;

import Level1.Level1;

import Logic.Model;
import constants.Animation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * This will be shown if you loose the game. Here you can decide whether you
 * want to try again, view highscores or return to the menu.
 *
 */
public class GameOverMenu extends GameState {
	private Color bgColor;
	private Color fontColor1;
	private Animation animation;

	public GameOverMenu(Model model) {
		super(model);
		animation = new Animation(model);
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

		g.drawImage(animation.getDonkeyLeft(), 170, 200, 80, 80);
		g.drawImage(animation.getDonkeyRight(), 260, 198, 80, 80);

		g.setFill(Color.DARKRED);
		g.setFont(new Font(70)); // Big letters
		g.fillText("GAME OVER", 60, 150);

		g.setFill(fontColor1);
		g.fillRoundRect(100, 300, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("Retry", 220, 345);

		g.setFill(fontColor1);
		g.fillRoundRect(100, 400, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("Main Menu", 190, 445);

		g.setFill(fontColor1);
		g.fillRoundRect(100, 500, 300, 80, 30, 30);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("HighScores", 190, 545);

		g.getCanvas().setOnMouseClicked(event -> {
			if (event.getX() <= 400 && event.getX() >= 100 && event.getY() >= 300 && event.getY() <= 380) {
				model.switchState(new Level1(model));
			} else if (event.getX() <= 400 && event.getX() >= 100 && event.getY() >= 400 && event.getY() <= 480) {
				model.switchState(new Menu(model));
			} else if (event.getX() <= 400 && event.getX() >= 100 && event.getY() >= 500 && event.getY() <= 580) {
				model.switchState(new HighScore(model));
			}
		});

	}

	@Override
	public void keyPressed(KeyEvent key) {

	}

}
