package Graphics;

import Logic.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Window extends VBox{

	private static ArrayList<Button> buttons = new ArrayList<>();
	
	public Window(Model model, int width, int height) throws FileNotFoundException {
	
	}
	
	public static void background () throws FileNotFoundException {
		HBox main = new HBox();
		main.setPrefSize(600, 600);
		
		Image cover = new Image(new FileInputStream("C:\\Users\\Julia\\Desktop\\donkeykong.png")); 
		ImageView image = new ImageView(cover);
		
		VBox lowerMenu = new VBox(); 
		lowerMenu.setPrefSize(600, 262);
		lowerMenu.setStyle("-fx-background-color: #000000;");
		  
		VBox highScore = new VBox(); 
		highScore.setPrefSize(150, 262);
		  
		VBox options = new VBox(); 
		options.setPrefSize(300, 262);
		  
		Button newGame = new Button("NEW GAME"); 
		Button howToPlay = new Button("HELP"); 
		Button highscore = new Button("HIGHSCORES"); 
		Button exit = new Button("EXIT");
		  
		  buttons.add(newGame); 
		  buttons.add(howToPlay); 
		  buttons.add(highscore);
		  buttons.add(exit);
		  
		  for (Button button: buttons) {
			  options.setSpacing(15);
		  options.setAlignment(Pos.CENTER); 
		  button.setFont(Font.font("Times New Roman",FontWeight.BOLD, 26)); 
		  button.setStyle("-fx-background-color: #696969;");
		  button.setTextFill(Color.DODGERBLUE); 
		  }
		  
		  newGame.setOnAction(value -> {
		  
		  });
		  
		  
		  options.getChildren().addAll(newGame, highscore, howToPlay, exit);
		  
		  VBox help = new VBox(); 
		  help.setPrefSize(150,262);
		  
		  newGame.setOnMouseClicked(event -> { 
			  //game-loop 
			  });
		  
		  lowerMenu.getChildren().addAll(highScore, options, help);
		  
		  main.getChildren().addAll(image, lowerMenu);
	}
}
