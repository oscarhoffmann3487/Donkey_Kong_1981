package States;

import java.io.FileNotFoundException;

import Level1.Level1;
import Level2.Level2;
import Logic.*;
import constants.Animation;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

/**
 * The first class to be shown. Here the player can choose New Game, Help, Highscores or Exit. 
 * 
 */
public class Menu extends GameState {

	private Level1 level1;
	private Level2 level2;
	private Help help;
	private HighScore highScore;
	private Color bgColor;
	private Color fontColor;
	private AudioClip introSong;
	private Animation animation;

	public Menu(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.WHITE;
		level1 = new Level1(model);
		help = new Help(model);
		level2 = new Level2(model, 0);
		highScore = new HighScore(model);
		animation = new Animation(model);
	}

	/**
	 * Within the draw-method we created different "buttons". Each button has a specific size
	 * and if the player click within the different buttons currentState will be switched. 
	 */
	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor);

		g.setFill(Color.DARKBLUE);
		g.fillRoundRect(150.0, 360.0, 200.0, 60.0, 30.0, 30.0);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("NEW GAME", 180, 400);

		g.setFill(Color.DARKBLUE);
		g.fillRoundRect(150.0, 430.0, 200.0, 60.0, 30.0, 30.0);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("HIGHSCORE", 185, 470);

		g.setFill(Color.DARKBLUE);
		g.fillRoundRect(150.0, 500.0, 200.0, 60.0, 30.0, 30.0);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("HELP", 220, 540);

		g.setFill(Color.DARKBLUE);
		g.fillRoundRect(150.0, 570.0, 200.0, 60.0, 30.0, 30.0);
		g.setFill(Color.WHITE);
		g.setFont(new Font(25));
		g.fillText("EXIT", 225, 610);

		g.getCanvas().setOnMouseClicked(event -> {
			if (event.getX() <= 360 && event.getX() >= 150 && event.getY() >= 360 && event.getY() <= 420) {
				model.switchState(level1);
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 430 && event.getY() <= 490) {
				model.switchState(highScore);
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 500 && event.getY() <= 560) {
				model.switchState(help);
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 570 && event.getY() <= 630) {
				System.exit(0);
			}

		});

		g.drawImage(animation.getMenuImage(), 50, 50, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 400);

	}

	public AudioClip audio() {
		introSong = new AudioClip("intro1.waw");
		introSong.play();
		return introSong;
	}

	@Override
	public void keyPressed(KeyEvent key) {
	}

	@Override
	public void update() {
	}

}
