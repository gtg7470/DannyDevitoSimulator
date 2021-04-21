import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane; 
import javafx.scene.control.*; 
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import java.util.Random;
 
public class MyApp extends Application {
	public static String chat = "";
	public static int chatNum = 0;
	
	private Random rand = new Random();
	public String[] quotes = {
		"Im doctor mantis tobaggin",
		"Do you have some sort of donkey brain database?\nJust search for any half man half amphibious creature.",
		"You gotta pay the troll toll",
		"When I die, I'm not gonna be burried in a grave.\nWhen I'm dead, just throw me in the trash",
		"Sew Me Into The Couch",
		"I guess babies can't be trusted.",
		"I'm the trash man, I eat garbage",
		"Would you like a hard boiled egg in these trying times",
		" I've seen many pigs eat many men",
		"I'm a man cheetah!"
	};
	
    public static void main(String[] args) {
        launch(args);
    }
	
	public String getQuote() {
		String quote = quotes[chatNum % quotes.length];
		chatNum++;
		return quote;
	}
    
    @Override
    public void start(Stage primaryStage) {
	    primaryStage.setTitle("Hello World!");
		
		BorderPane root = new BorderPane();
		
		Label heading = new Label("Official Danny Devito Simulator 2021");
		
		Image image = new Image("devito.jpg");
		ImageView iv1 = new ImageView();
		
		TextField input = new TextField();
        Button submit = new Button();
		
		Label chatLog = new Label();
		
		//top
		root.setTop(heading);
		
		//left
		iv1.setImage(image);
		iv1.setFitHeight(600);
		iv1.setPreserveRatio(true);
        root.setLeft(iv1);
	
		//bottom
        submit.setText("Submit");
        submit.setOnAction(e -> {
			String text = input.getText();
			System.out.println(text);
			input.setText("");
			chat += "User: " + text + "\n";
			chat += "Devito: " + getQuote() + "\n";
			
			chatLog.setText(chat);
        });
		HBox hb = new HBox();
		hb.getChildren().add(input);
		hb.getChildren().add(submit);
		root.setBottom(hb);
		
		//center
		root.setCenter(chatLog);
		
		//fancy
		root.setAlignment(heading, Pos.CENTER);
		hb.setAlignment(Pos.CENTER);
		
		input.setFont(Font.font(java.awt.Font.SERIF, 20));
		submit.setFont(Font.font(java.awt.Font.SERIF, 20));
        heading.setFont(Font.font(java.awt.Font.SERIF, 24));
		chatLog.setFont(Font.font(java.awt.Font.SERIF, 24));
		
		root.setStyle("-fx-background-color: #4287f5;");
		
		root.setPadding(new Insets(10, 10, 10, 10));
		input.setStyle("-fx-background-color: #FFFFFF;");
		
		chatLog.setStyle("-fx-background-color: #4075c9;");
		chatLog.setMaxWidth(Double.MAX_VALUE);
		chatLog.setMaxHeight(600);

		
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
    }
}