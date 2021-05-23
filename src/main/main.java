package Main;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	static FirstPage fp = new FirstPage();

	public void start(Stage primaryStage) {
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	public static FirstPage getFp() {
		return fp;
	}
	
}