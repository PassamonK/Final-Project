package main;

import gui.SecondPagePane;
import gui.StartPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SecondPage extends Stage {
	
	HBox root = new HBox();
	SecondPagePane scp = new SecondPagePane();
	Scene scene = new Scene(root);
	
	public SecondPage() {
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		root.setPrefHeight(600);
		root.setPrefWidth(600);
		String imagepath = ClassLoader.getSystemResource("bgfstpage.jpg").toString();
		Image image = new Image(imagepath);
		
		BackgroundSize bgSize = new BackgroundSize(600,600,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		root.setBackground(new Background(bgImgA));
		root.getChildren().addAll(scp);
		this.setScene(scene);
		this.setTitle("Happy Fish");		
		this.sizeToScene();
		this.setResizable(false);
		this.show();
	}
}
