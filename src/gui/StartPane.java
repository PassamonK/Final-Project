package gui;

import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class StartPane extends GridPane {
	
	public StartPane () {
			
		this.setAlignment(Pos.CENTER);
		this.setVgap(50);
		this.setHgap(40);
		this.setMaxWidth(600);
		this.setMaxHeight(300);
		
		StartButton back = new StartButton("BACK");
		StartButton play = new StartButton("PLAY");
		

		this.addRow(1,back,play);		
		
		
	} 


}
