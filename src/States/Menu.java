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
		
		
		g.setFill(Color.WHITE);
		g.fillRect(150, 340, 200, 60);
		g.setFill(Color.BLACK);
		g.setFont(new Font(25));
		g.fillText("NEW GAME", 180, 380);
		
		g.setFill(Color.WHITE);
		g.fillRect(150, 420, 200, 60);
		g.setFill(Color.BLACK);
		g.setFont(new Font(25));
		g.fillText("HELP", 220, 460);
		
		g.setFill(Color.WHITE);
		g.fillRect(150, 500, 200, 60);
		g.setFill(Color.BLACK);
		g.setFont(new Font(25));
		g.fillText("EXIT", 225, 540);
		

		g.getCanvas().setOnMouseClicked(event -> {
			if(event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 340 && event.getY() <=400 ) {
					model.switchState(level1);
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 420 && event.getY() <=480 ) {
				model.switchState(help);
			} else if (event.getX() <= 350 && event.getX() >= 150 && event.getY() >= 500 && event.getY() <=560 ) {
				System.exit(0);
			}
		});
	
		g.drawImage(menuImage, 50, 50, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 400);
		
		//Highscoretext
		g.setFill(fontColor2);
		g.setFont(new Font(20)); 
		g.fillText("HIGHSCORE: 0003594932", SCREEN_WIDTH / 2 - 130, 30);
		
		
		g.drawImage(donkeyKong, SCREEN_WIDTH / 2 - 50, 580, 80, 80);
	
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
