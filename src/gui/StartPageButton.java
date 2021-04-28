package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.geometry.Insets;

public class StartPageButton extends Button{
	public StartPageButton(String buttonName){
	    this.setText(buttonName);
	    this.setPadding(new Insets(10));
	    this.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		this.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DASHED,CornerRadii.EMPTY, BorderWidths.DEFAULT)));
	    this.setFont(new Font(30));
		this.setPrefWidth(250);
	    this.setPrefHeight(50);
	  }
}
