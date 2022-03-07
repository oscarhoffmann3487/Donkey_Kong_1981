package Level1;

import java.util.ArrayList;

import Level2.Level2;
import Logic.Model;
import States.GameOverMenu;
import constants.Animation;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static constants.Constants.SCREEN_WIDTH;

/**
 * 
 * Here we create Mario, this class will be used both in Level1 and Level2.
 *
 */
public class Mario {
	private int counter = 0;
	private boolean jumping = false;
	private double x = 10.0;
	private double y = 625.0;
	private double speed = 8.0;
	private double climbingSpeed = 5.0;
	private double gravity = 2.0;
	private double scale = 30;
	private Rectangle2D marioBox;
	private Rectangle2D donkeyKong;
	private Model model;
	private Animation animation;
	private String direction = "right";

	private ArrayList<Rectangle2D> floors;
	private ArrayList<Rectangle2D> ladders;

	public Mario(Model model, ArrayList<Rectangle2D> floorBoundaries, Rectangle2D donkeyKong,
			ArrayList<Rectangle2D> ladderBoundaries) {
		this.floors = floorBoundaries;
		this.ladders = ladderBoundaries;
		this.donkeyKong = donkeyKong;
		this.model = model;
		animation = new Animation(model);

		marioBox = new Rectangle2D(x, y, scale, scale);
	}

	/**
	 * This methods allows Mario run around, climb ladders and jump. The ladder큦
	 * placement differ in Level1 and Level2 and therefore we need to check whether
	 * we are in Level1 or 2 and then use different methods.
	 * 
	 * @param key
	 */
	public void keyPressed(KeyEvent key) {
		checkPosition();
		// H철ger
		if (key.getCode() == KeyCode.D) {
			direction = "right";
			if (model.getCurrentState() instanceof Level1) {
				if (marioSpecificLadderAndFloor() && !marioYCoordinate()) {
				} else {
					x += speed;
				}
			} else if (model.getCurrentState() instanceof Level2) {
				if (marioSpecificLadderAndFloor2() && !marioYCoordinate()) {
				} else {
					x += speed;
				}
			}

			// V채nster
		} else if (key.getCode() == KeyCode.A) {
			direction = "left";
			if (model.getCurrentState() instanceof Level1) {
				if (marioSpecificLadderAndFloor() && !marioYCoordinate()) {
				} else {
					x -= speed;
				}
			} else if (model.getCurrentState() instanceof Level2) {
				if (marioSpecificLadderAndFloor2() && !marioYCoordinate()) {
				} else {
					x -= speed;
				}
			}

			// Hoppa
		} else if (key.getCode() == KeyCode.SPACE) {
			if (model.getCurrentState() instanceof Level1) {
				if (onFloor() && !ladderCollision() || marioSpecificLadderAndFloor()) {
					jumping = true;
				}
			} else if (model.getCurrentState() instanceof Level2) {
				if (onFloor() && !ladderCollision() || marioSpecificLadderAndFloor2()) {
					jumping = true;
				}
			}

			// Kl채ttra upp책t
		} else if (key.getCode() == KeyCode.W) {
			if (ladderCollision()) {
				direction = "climb";
				y -= climbingSpeed;
			}
			// kl채ttra ned책t
		} else if (key.getCode() == KeyCode.S) {
			if (model.getCurrentState() instanceof Level1) {
				if (marioSpecificLadderAndFloor() || marioOnlyOnLadder()) {
					direction = "climb";
					y += climbingSpeed;
				}
			} else if (model.getCurrentState() instanceof Level2) {
				if (marioSpecificLadderAndFloor2() || marioOnlyOnLadder()) {
					direction = "climb";
					y += climbingSpeed;
				}
			}
		}
	}

	/**
	 * drawMario() will change the animation of Mario depending on witch direction he
	 * is in. The direction depends on which key is pressed in KeyPressed().
	 * 
	 * @param g
	 */
	public void drawMario(GraphicsContext g) {
		if (direction == "right") {
			g.drawImage(animation.getMarioStandRight(), x, y, scale, scale);
		} else if (direction == "left") {
			g.drawImage(animation.getMarioStandLeft(), x, y, scale, scale);
		} else if (direction == "climb" && ladderCollision()) {
			g.drawImage(animation.getMarioClimb(), x, y, scale, scale);
		} else {
			g.drawImage(animation.getMarioStandRight(), x, y, scale, scale);
		}

	}

	public void update() {
		gravity(ladderCollision(), onFloor());
		marioDonkeyKongCollision();
		marioBox = new Rectangle2D(x, y, scale, scale);
		if (model.getCurrentState() instanceof Level1) {
			marioSpecificLadderAndFloor();
		} else if (model.getCurrentState() instanceof Level2) {
			marioSpecificLadderAndFloor2();
		}
		counter();
	}

	public void counter() {
		if (jumping == true) {
			counter += 1;
			if (counter < 13) {
				y -= 6;
			} else {
				counter = 0;
				jumping = false;
			}
		}

	}
	
	/**
	 * If mario intersects DonkeyKong the game is over. 
	 */

	public void marioDonkeyKongCollision() {
		if (marioBox.intersects(donkeyKong)) {
			model.switchState(new GameOverMenu(model));
		}
	}

	/**
	 * If Mario is on a Ladder or on the Floor there is no gravity, but if he is
	 * jumping the gravity will force him down.
	 * 
	 * @param isOnLadder
	 * @param isOnFloor
	 */
	public void gravity(boolean isOnLadder, boolean isOnFloor) {

		if (isOnLadder || isOnFloor) {
		} else {
			y += gravity;
		}
	}

	public boolean onFloor() {
		for (Rectangle2D floor : floors) {
			if (marioBox.intersects(floor)) {
				return true;
			}
		}
		return false;
	}

	public boolean ladderCollision() {
		for (Rectangle2D ladder : ladders) {
			if (marioBox.intersects(ladder)) {
				return true;
			}
		}
		return false;
	}

	public boolean marioOnlyOnLadder() {
		if (ladderCollision() && !onFloor()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This is used in KeyPressed and decides whether Mario can move in a certain
	 * direction or not depending on which floor and ladder he stands upon. 
	 * 
	 * @return
	 */
	public boolean marioSpecificLadderAndFloor() {
		if (marioBox.intersects(ladders.get(0)) && marioBox.intersects(floors.get(1))) {
			return true;
		} else if (marioBox.intersects(ladders.get(1)) && marioBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBox.intersects(ladders.get(2)) && marioBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBox.intersects(ladders.get(3)) && marioBox.intersects(floors.get(3))) {
			return true;
		} else if (marioBox.intersects(ladders.get(4)) && marioBox.intersects(floors.get(4))) {
			return true;
		} else if (marioBox.intersects(ladders.get(5)) && marioBox.intersects(floors.get(5))) {
			return true;
		} else if (marioBox.intersects(ladders.get(6)) && marioBox.intersects(floors.get(5))) {
			return true;
		} else if (marioBox.intersects(ladders.get(7)) && marioBox.intersects(floors.get(6))) {
			return true;
		} else {
			return false;
		}
	}

	public boolean marioSpecificLadderAndFloor2() {
		if (marioBox.intersects(ladders.get(0)) && marioBox.intersects(floors.get(1))) {
			return true;
		} else if (marioBox.intersects(ladders.get(1)) && marioBox.intersects(floors.get(1))) {
			return true;
		} else if (marioBox.intersects(ladders.get(2)) && marioBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBox.intersects(ladders.get(3)) && marioBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBox.intersects(ladders.get(4)) && marioBox.intersects(floors.get(2))) {
			return true;
		} else if (marioBox.intersects(ladders.get(5)) && marioBox.intersects(floors.get(3))) {
			return true;
		} else if (marioBox.intersects(ladders.get(6)) && marioBox.intersects(floors.get(3))) {
			return true;
		} else if (marioBox.intersects(ladders.get(7)) && marioBox.intersects(floors.get(3))) {
			return true;
		} else if (marioBox.intersects(ladders.get(8)) && marioBox.intersects(floors.get(4))) {
			return true;
		} else if (marioBox.intersects(ladders.get(9)) && marioBox.intersects(floors.get(4))) {
			return true;
		} else if (marioBox.intersects(ladders.get(10)) && marioBox.intersects(floors.get(4))) {
			return true;
		} else if (marioBox.intersects(ladders.get(10)) && marioBox.intersects(floors.get(5))) {
			return true;
		} else if (marioBox.intersects(ladders.get(11)) && marioBox.intersects(floors.get(6))) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is use in KeyPressed and controls Marios Y-coordinate. 
	 * @return
	 */
	public boolean marioYCoordinate() {
		double yRef1 = y + 28.0;
		double yRef2 = y + 29.0;
		double floor1Y = 555;
		double floor2Y = 455;
		double floor3Y = 355;
		double floor4Y = 255;
		double floor5Y = 155;
		double floor6Y = 100;

		if (yRef1 == floor1Y || yRef2 == floor1Y) {
			return true;
		} else if (yRef1 == floor2Y || yRef2 == floor2Y) {
			return true;
		} else if (yRef1 == floor3Y || yRef2 == floor3Y) {
			return true;
		} else if (yRef1 == floor4Y || yRef2 == floor4Y) {
			return true;
		} else if (yRef1 == floor5Y || yRef2 == floor5Y) {
			return true;
		} else if (yRef1 == floor6Y || yRef2 == floor6Y) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Tells Mario that he cannot move outside the screen. 
	 */
	public void checkPosition() {
		if (x >= SCREEN_WIDTH - scale) {
			x -= speed;
		} else if (x <= 0.0) {
			x += speed;
		}
	}

	public Rectangle2D getMarioBox() {
		return marioBox;
	}

}