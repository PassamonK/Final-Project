package gui;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class SecondPagePane extends GridPane{
	
	public SecondPagePane () {
		
		this.setAlignment(Pos.CENTER);
		this.setVgap(50);
		this.setHgap(40);
		this.setMaxWidth(600);
		this.setMaxHeight(600);
		
		StartPane start = new StartPane();
		CharacterPane cp = new CharacterPane();
		
		Label label = new Label("Please select your charactor");
		label.setFont(new Font(36));
		label.setAlignment(Pos.CENTER);
		
		this.addRow(0,label);
		this.addRow(1,cp);
		this.addRow(2,start);
		
		
	} 

}
