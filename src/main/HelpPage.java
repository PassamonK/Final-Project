package Main;

import gui.StartPageButton;
import gui.StartPagePane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HelpPage extends Stage{
	
	HBox root = new HBox();
	private FirstPage fp2;
	
	public HelpPage() {
		root.setSpacing(10);
		root.setPadding(new Insets(10));
		root.setPrefHeight(600);
		root.setPrefWidth(600);
		String imagepath = ClassLoader.getSystemResource("htp.png").toString();
		Image image = new Image(imagepath);
		
		ImageView imageB = new ImageView(new Image("backbutton.png"));
		imageB.setFitHeight(70);
		imageB.setFitWidth(170);
		StartPageButton back = new StartPageButton(imageB);
		
		root.getChildren().add(back);
		root.setAlignment(Pos.BOTTOM_CENTER);
		
		BackgroundSize bgSize = new BackgroundSize(600,600,false,false,false,false);
		BackgroundImage bgImg = new BackgroundImage(image, null, null, null, bgSize);
		BackgroundImage[] bgImgA = {bgImg};
		root.setBackground(new Background(bgImgA));
		Scene scene = new Scene(root);
		this.setScene(scene);
		this.setTitle("Help");	
		this.setResizable(false);
		this.sizeToScene();
		this.show();
	
			
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				StartPagePane.getHp().hide();
				fp2 = new FirstPage();
			}
		});
		
		
	} 
	
	
	
	}
