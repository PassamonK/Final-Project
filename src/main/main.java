package main;

import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
	public static FirstPage Fp = new FirstPage();
	@Override
	public void start(Stage primaryStage) {
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	public static FirstPage getFp() {
		return Fp;
	}
	
}