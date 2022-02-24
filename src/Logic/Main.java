package Logic;

import java.io.FileNotFoundException;

import Graphics.*;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	
	@Override
	public void start(Stage gameStage) throws Exception {
		gameStage.setTitle("Donkey Kong");
		gameStage.setWidth(600);
		gameStage.setHeight(600);
		Model model = new Model();
		GameFrame frame = new GameFrame(model, 600, 600);
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
						// TODO Auto-generated catch block
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


