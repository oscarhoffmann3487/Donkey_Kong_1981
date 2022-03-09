package Main;

import static constants.Constants.SCREEN_HEIGHT;
import static constants.Constants.SCREEN_WIDTH;
import java.io.FileNotFoundException;
import Logic.GameFrame;
import Logic.Model;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * Here we create the Model, GameFram and Scene with specific sizes. This class
 * starts the method handle which will send model.update() and frame.repaint()
 */

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage gameStage) throws Exception {
		gameStage.setTitle("Donkey Kong");
		gameStage.setWidth(SCREEN_WIDTH);
		gameStage.setHeight(SCREEN_HEIGHT);
		Model model = new Model();
		GameFrame frame = new GameFrame(model, SCREEN_WIDTH, SCREEN_HEIGHT);
		Scene gameScene = new Scene(frame);

		final double targetFps = 50.0;

		final double nanoPerUpdate = 1000000000.0 / targetFps;

		gameStage.setScene(gameScene);

		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent event) {
				model.keyPressed(event);
			}
		});

		new AnimationTimer() {
			long lastUpdate = 0;

			public void handle(long now) {
				if ((now - lastUpdate) > nanoPerUpdate) {
					try {
						model.update();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
					try {
						frame.repaint();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					lastUpdate = now;
				}
			}
		}.start();
		gameStage.show();
	}
}
