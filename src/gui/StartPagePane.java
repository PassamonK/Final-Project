package gui;

import Main.HelpPage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import Main.SecondPage;
import Main.Main;

public class StartPagePane extends GridPane{
	static SecondPage sp ;
	private static HelpPage hp;
	
	public static SecondPage getSp() {
		return sp;
	}
	public StartPagePane () {
        this.setVgap(30);
        this.setPrefWidth(600);
        this.setMaxHeight(500);
        this.setAlignment(Pos.BOTTOM_CENTER);

        ImageView imageS = new ImageView(new Image("startbutton.png"));
		imageS.setFitHeight(70);
		imageS.setFitWidth(170);
		ImageView imageH = new ImageView(new Image("helpbutton.png"));
		imageH.setFitHeight(70);
		imageH.setFitWidth(170);
		ImageView imageE = new ImageView(new Image("exitbutton.png"));
		imageE.setFitHeight(70);
		imageE.setFitWidth(170);
		
        StartPageButton start = new StartPageButton(imageS);
        StartPageButton help = new StartPageButton(imageH);
        StartPageButton exit = new StartPageButton(imageE);


        this.add(start,2,1);
        this.add(help,1,2);
        this.add(exit,0,3);

		start.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				sp = new SecondPage();
				Main.getFp().hide();				
			}
		});
		
		help.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Main.getFp().hide();
				hp = new HelpPage();		       
			}
		});
			
		exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.exit(0);
			}
		});
			
		
		}
	public static HelpPage getHp() {
		return hp;
	}
	}
