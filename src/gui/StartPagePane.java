package gui;

import main.FirstPage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import main.SecondPage;
import main.main;

public class StartPagePane extends GridPane{
	private ObservableList<StartPageButton> startPageButtonList = FXCollections.observableArrayList();
	public static SecondPage sp ;
	
	public StartPagePane () {
		// TODO implements the ItemPane's constructor
		this.setAlignment(Pos.CENTER);
        this.setVgap(30);
        this.setHgap(30);
        this.setPrefWidth(600);



        StartPageButton start = new StartPageButton("START");
        StartPageButton help = new StartPageButton("HELP");
        StartPageButton exit = new StartPageButton("EXIT");
        startPageButtonList.add(start);
        startPageButtonList.add(help);
        startPageButtonList.add(exit);

        String imagepath = ClassLoader.getSystemResource("logo.png").toString();
        ImageView image = new ImageView(imagepath);
        image.setFitHeight(250);
        image.setFitWidth(250);

        this.addRow(0, image);
        this.addRow(1,start);
        this.addRow(2,help);
        this.addRow(3,exit);

		for (StartPageButton eachButton:startPageButtonList) {
			if (eachButton.getText()=="START") {
				eachButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						main.getFp().hide();
						sp = new SecondPage();
					}
				});
			}
			if (eachButton.getText()=="HELP") {
				eachButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						new FirstPage();
					}
				});
			}
			if (eachButton.getText()=="EXIT") {
				eachButton.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						main.getFp().hide();;
					}
				});
			}
		}
		
	}

	public static SecondPage getSp() {
		return sp;
	}
}