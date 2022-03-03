package constants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Logic.Model;
import javafx.scene.image.Image;

public class Animation {
	private Image marioStandRight;
	private Image marioStandLeft;
	private Image purse;
	private Image pauline;
	private Image donkeyKongAndBarrel;
	private Image floor;
	private Image ladder;
	private Image barrel;
	private Image cape;
	private Image score100;
	private Image score200;
	private Image score300;
	private Image marioClimb;
	
	public Image getPurse() {
		return purse;
	}

	public Image getHat() {
		return hat;
	}

	public Image getUmbrella() {
		return umbrella;
	}

	private Image hat;
	private Image umbrella; 
	

	public Animation(Model model) {
		try {
			marioStandRight = new Image(new FileInputStream("Images/Mario/right/MarioRun1Right.png"));
			marioStandLeft = new Image(new FileInputStream("Images/Mario/left/MarioRun1Left.png"));
			marioClimb = new Image(new FileInputStream("Images/Mario/MarioClimb.png"));
			purse = new Image(new FileInputStream("Images/PaulinesIteams/purse.png"));
			hat = new Image(new FileInputStream("Images/PaulinesIteams/Hatt.png"));
			umbrella = new Image(new FileInputStream("Images/PaulinesIteams/Umbrella.png"));
			pauline = new Image(new FileInputStream("Images/Pauline/Pauline.png"));
			donkeyKongAndBarrel = new Image(new FileInputStream("Images/DonkeyKong/DonkeyKongAndBarrel.png"));
			floor = new Image(new FileInputStream("floor.png"));
			ladder = new Image(new FileInputStream("ladder1.png"));
			barrel = new Image(new FileInputStream("barrel.png"));
			cape = new Image(new FileInputStream("Images/cape.png"));
			score100 = new Image(new FileInputStream("Images/Scores/Score100.png"));
			score200 = new Image(new FileInputStream("Images/Scores/Score200.png"));
			score300 = new Image(new FileInputStream("Images/Scores/Score300.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

	}

	public Image getMarioStandRight() {
		return marioStandRight;
	}

	public Image getMarioStandLeft() {
		return marioStandLeft;
	}

	public Image getPauline() {
		return pauline;
	}

	public Image getDonkeyKongAndBarrel() {
		return donkeyKongAndBarrel;
	}

	public Image getFloor() {
		return floor;
	}

	public Image getLadder() {
		return ladder;
	}

	public Image getBarrel() {
		return barrel;
	}

	public Image getCape() {
		return cape;
	}

	public Image getScore100() {
		return score100;
	}

	public Image getScore200() {
		return score200;
	}

	public Image getScore300() {
		return score300;
	}

	public Image getMarioClimb() {
		return marioClimb;
	}
}
