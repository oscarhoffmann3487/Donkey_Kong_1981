package States;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;

import Logic.*;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public class Menu extends GameState {

	private Level1 level1;
	private Help help;
	private GameOverMenu gameOverMenu;
	private HighScore highScore;
	private Color bgColor;
	private Color fontColor1;
	private Color fontColor2;
	private Image menuImage;
	private Image donkeyKong;
	private AudioClip introSong;

	public Menu(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor1 = Color.WHITE;
		fontColor2 = Color.RED;
		level1 = new Level1(model);
		help = new Help(model);
		highScore = new HighScore(model);
		
		gameOverMenu = new GameOverMenu(model);
					
		try {
			menuImage = new Image(new FileInputStream("donkeyKong.png"));
			donkeyKong = new Image(new FileInputStream("donkeyCenter.png"));

		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
		drawBg(g, bgColor);
		g.setFill(fontColor1);
		
		
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
			if(event.getX() <= 360 && event.getX() >= 150 && event.getY() >= 360 && event.getY() <= 420 ) {
					model.switchState(level1);
			}else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 430 && event.getY() <= 490 ) {
				model.switchState(highScore);			
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 500 && event.getY() <= 560 ) {
				model.switchState(help);
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 570 && event.getY() <= 630 ) {
				System.exit(0);
			}
		
		});
	
		g.drawImage(menuImage, 50, 50, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 400);
		
		
	//	g.drawImage(donkeyKong, SCREEN_WIDTH / 2 - 50, 580, 80, 80);
	
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
		// TODO Auto-generated method stub

	}

}
