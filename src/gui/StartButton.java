package gui;

import main.FirstPage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class StartButton extends Button{
    public StartButton(String buttonName){
        this.setText(buttonName);
        this.setPadding(new Insets(10));
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.DASHED,CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setPrefWidth(250);
        this.setPrefHeight(50);
        this.setFont(new Font(30));
        if (this.getText() == "BACK") {
            this.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    StartPagePane.getSp().hide();
                    new FirstPage();
                }
            });
        }
    }
}

