package States;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;

import Logic.*;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

public class Menu extends GameState {

	private Level1 level1;
	private Help help;
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
		g.setFont(new Font(30)); // Big letters
		g.fillText("Press \"Enter\" to start a new game", 40, 400);
		g.fillText("Press \"h\" for help", 130, 440);
		g.fillText("Press \"Esc\" to exit", 130, 480);
	
		g.drawImage(menuImage, 50, 50, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 400);
		
		//Highscoretext
		g.setFill(fontColor2);
		g.setFont(new Font(20)); 
		g.fillText("HIGHSCORE: 0003594932", SCREEN_WIDTH / 2 - 130, 30);
		
		
		g.drawImage(donkeyKong, SCREEN_WIDTH / 2 - 50, 500, 80, 80);
	
	}

	public AudioClip audio() {
		 introSong = new AudioClip("intro1.waw");
		 introSong.play(); 
		return introSong;
	}
	
	
	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getText() + " i Menu");

		if (key.getCode() == KeyCode.ENTER) {
			model.switchState(level1);
		} else if (key.getCode() == KeyCode.ESCAPE) {
			System.exit(0);
		}else if (key.getCode() == KeyCode.A) {
			//audio();	
		}else if(key.getCode() == KeyCode.H) {
		
			model.switchState(help);
		}

	}
	
	
	@Override
	public void activate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
