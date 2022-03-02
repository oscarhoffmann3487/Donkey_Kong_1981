package States;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Help extends GameState{

	private Color bgColor;
	private Color fontColor;
	private Image menuImage;
	private Image donkeyKong;
	
	public Help(Model model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.WHITE;
		try {
			menuImage = new Image(new FileInputStream("donkeyKong.png"));
			donkeyKong = new Image(new FileInputStream("donkeyCenter.png"));

		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}
	}

	@Override
	public void update() throws FileNotFoundException {
	}

	@Override
	public void draw(GraphicsContext g) throws FileNotFoundException {
	
		drawBg(g, bgColor);
		g.setFill(fontColor);
		g.drawImage(menuImage, 50, 50, SCREEN_WIDTH - 100, SCREEN_HEIGHT - 400);
		g.setFont(new Font(20));
		g.fillText("Move around by using the keys A, D, W, S.", 20, 400);
		g.fillText("You can jump by using spacebar.", 20, 440);
		g.fillText("Watch out for barrels and Donkey Kong.", 20, 480);
		g.fillText("Collect all of Pauline¥s items, the faster the better.", 20, 520);
		g.fillText("Press \"b\" to go back to main menu.", 20, 560);
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
			System.out.println("Trycker p√• " + key.getCode() + " i PlayState");

			if (key.getCode() == KeyCode.B)
				model.switchState(new Menu(model));
		}
		

}
