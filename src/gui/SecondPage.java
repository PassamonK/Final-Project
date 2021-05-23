package gui;

import Main.FirstPage;
import Main.GamePage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SecondPage extends GridPane {
	
	public static FirstPage fp2;
	public static GamePage gp;
	
	public SecondPage () {
		this.setAlignment(Pos.CENTER);
		this.setVgap(50);
		this.setHgap(40);
		this.setMaxWidth(600);
		this.setMaxHeight(300);
		
		ImageView imageB = new ImageView(new Image("backbutton.png"));
		imageB.setFitHeight(70);
		imageB.setFitWidth(170);
		ImageView imageP = new ImageView(new Image("playbutton.png"));
		imageP.setFitHeight(70);
		imageP.setFitWidth(170);
		
		StartPageButton back = new StartPageButton(imageB);
		StartPageButton play = new StartPageButton(imageP);
		

		this.addRow(1,back,play);	
		
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				StartPagePane.getSp().hide();
				fp2 = new FirstPage();
			}
		});
		play.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				StartPagePane.getSp().hide();
				gp = new GamePage();
				}
			});
		
	} 

}