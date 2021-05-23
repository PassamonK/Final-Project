package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class CharacterPane extends GridPane{
	
	public static String playerselect;
	
	public CharacterPane () {
		this.setAlignment(Pos.BASELINE_CENTER);
		this.setVgap(50);
		this.setHgap(40);
		this.setPrefWidth(600);
		this.setMaxHeight(300);
		
		ImageView image1 = new ImageView(new Image("c1_front.png"));
		image1.setFitHeight(125);
		image1.setFitWidth(125);
		
		ImageView image2 = new ImageView(new Image("c2_front.png"));
		image2.setFitHeight(125);
		image2.setFitWidth(125);
		
		ImageView image3 = new ImageView(new Image("c3_front.png"));
		image3.setFitHeight(125);
		image3.setFitWidth(125);
		
		ImageView image1selected = new ImageView(new Image("choose1.png"));
		image1selected.setFitHeight(120);
		image1selected.setFitWidth(120);
		
		ImageView image2selected = new ImageView(new Image("choose2.png"));
		image2selected.setFitHeight(120);
		image2selected.setFitWidth(120);
		
		ImageView image3selected = new ImageView(new Image("choose3.png"));
		image3selected.setFitHeight(120);
		image3selected.setFitWidth(120);
		
		CharacterButton character1 = new CharacterButton(image1);
		CharacterButton character2 = new CharacterButton(image2);
		CharacterButton character3 = new CharacterButton(image3);
		
		character1.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				character1.setGraphic(image1selected);
				character2.setGraphic(image2);
				character3.setGraphic(image3);
				playerselect = "player1";
			}
		});
		
		
		
		character2.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				character2.setGraphic(image2selected);
				character1.setGraphic(image1);
				character3.setGraphic(image3);
				playerselect = "player2";
			}
		});
		
		
		character3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				character3.setGraphic(image3selected);
				character1.setGraphic(image1);
				character2.setGraphic(image2);
				playerselect = "player3";
			}
		});
		
		
		Label label = new Label("Please select your charactor");
		label.setFont(new Font(20));
		label.setMinWidth(600);
		

		this.addRow(1,character1,character2,character3);
		
	}

	public static String getPlayerselect() {
		return playerselect;
	} 
	
}