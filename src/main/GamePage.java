package Main;

import Entity.Enemy;
import Entity.EnemyLR;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.CSV;
import logic.Cell;
import logic.Direction;
import logic.Draw;
import logic.GameControl;

public class GamePage extends Stage{
	
	public static boolean win = false;
	private Scene scene;
	public static GraphicsContext gc;
	public static Label coinlabel = new Label();
	private String[][] gameMap;
	private static int coin_count;
	public static int coin = 20;
	
	public static int numPage = 1;
	
	public GamePage() {
		
		GridPane p = new GridPane();
        StackPane root = new StackPane();

        scene = new Scene(p, 600,600);

        Canvas canvas = new Canvas(600,600);
        gc = canvas.getGraphicsContext2D();
        
        root.getChildren().add(canvas);
        root.setAlignment(Pos.BASELINE_CENTER);
        GameControl.intializeCoin(gc);


        coinlabel.setFont(new Font(15));
        coinlabel.setPrefHeight(40);
        coinlabel.setPrefWidth(80);
        coinlabel.setAlignment(Pos.CENTER);
        coinlabel.setTextFill(Color.YELLOW);
        coinlabel.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        p.getChildren().add(0, coinlabel);
        p.getChildren().add(0, root);
        p.setHalignment(coinlabel, HPos.RIGHT);
        p.setValignment(coinlabel, VPos.TOP);

        addEventListener(scene,gc);
       
		gameMap = CSV.readCSV("csv1.csv");
		
		GameControl.intializeMap(gameMap, 7,10);
        setCoinText();
        gc.clearRect(0, 0, 600, 600);
		drawGameBoard(gc);
		GameControl.moveEnemy(gc);
		
		

        this.setTitle("Map");
        this.setScene(scene);
        this.show();
		
	}
	
	
	public static void setCoinCount(int coincount) {
		coin_count = coincount;
	}
	
	public static void addCoinCount(int coincount) {
		coin_count += coincount;
		setCoinCount(coin_count);
	}

	 public static boolean is_pass() {
	        if (coin_count >= coin) {
	            return true;
	        }
	        return false;
	 }
	 
	public static void setCoinText() {
        coinlabel.textProperty().setValue("Coin:" +coin_count+"/"+coin);
    
	}
	public static void drawGameBoard(GraphicsContext gc) {
		
		gc.setFill(Color.rgb(21,24,31));
		gc.fillRect(0, 0, 600, 600);
		
		gc.setFill(Color.LIGHTGOLDENRODYELLOW);
		gc.fillRect(0, 0, 600, 600);
		
		Cell[][] gameBoard = GameControl.getGameMap().getMap();
		
		int x = 0;
		int y = 0;
		
		for(Cell[] row:gameBoard) {
			x = 0;
			for(Cell c:row) {
				if(!c.isEmpty()) {
					Draw.drawSprite(gc,x*40,y*40,c.getSymbol());
				if (c.getEntity() instanceof Enemy ) {
				}else if(c.getEntity() instanceof EnemyLR ) {
				}
				}
				x+=1;
			}
			y+=1;
		}
		
		
		if(!GameControl.getGameover()) {
			gc.setGlobalAlpha(0.8);
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, 600, 600);
			gc.setGlobalAlpha(1);
			Draw.drawGameover(gc, 50, 135);		
		}
		
        if(GameControl.isWin()) {
            gc.setGlobalAlpha(0.8);
            gc.setFill(Color.BLACK);
            gc.fillRect(0, 0, 600, 600);
            gc.setGlobalAlpha(1);
            Draw.drawCongrats(gc, 50, 145);
        }
	}
	public void addEventListener(Scene s,GraphicsContext gc) {
		
		s.setOnKeyReleased((event) -> {
			KeyCode keycode = event.getCode();
			switch(keycode) {
			case LEFT:
				GameControl.movePlayer(Direction.LEFT);
				break;
			case RIGHT:
				GameControl.movePlayer(Direction.RIGHT);
				break;
			case UP:
				GameControl.movePlayer(Direction.UP);
				break;
			case DOWN:
				GameControl.movePlayer(Direction.DOWN);
				break;
			case F:
				GameControl.spit();
				break;
			case E:
				GameControl.broke();
				break;
			case R:
				GameControl.setWin(false);
				setCoinCount(0);
				setCoinText();
				if (numPage==1) {
					GameControl.intializeMap(gameMap, 7,10);
					}
				else if (numPage==2) {
					GameControl.intializeMap(gameMap, 3,4);
					}
				else if (numPage==3) {
					GameControl.intializeMap(gameMap, 2, 12);
					}
				else if (numPage==4) {
					GameControl.intializeMap(gameMap, 2, 12);
					}
				else if (numPage==5) {
					GameControl.intializeMap(gameMap, 1, 13);
					}
				else if (numPage==6) {
					GameControl.intializeMap(gameMap, 1, 12);
					}
				else if (numPage==7) {
					GameControl.intializeMap(gameMap, 7,7);
					}
					
				GameControl.setGameover(true);
				break;
			case N:
				if(GameControl.isWin()) {
					numPage += 1 ;
					GameControl.thread1.interrupt();
					GameControl.thread2.interrupt();
					if (numPage==2) {
						gameMap = CSV.readCSV("csv2.csv");
						GameControl.intializeMap(gameMap, 3,4);
						coin = 25;
						}
					else if (numPage==4) {
						gameMap = CSV.readCSV("csv3.csv");
						GameControl.intializeMap(gameMap, 2, 12);
						coin = 30;
						}
					else if (numPage==3) {
						gameMap = CSV.readCSV("csv4.csv");
						GameControl.intializeMap(gameMap, 2, 12);
						coin = 35;
						}
					else if (numPage==5) {
						gameMap = CSV.readCSV("csv5.csv");
						GameControl.intializeMap(gameMap, 1, 13);
						coin = 40;
						}
					else if (numPage==6) {
						gameMap = CSV.readCSV("csv6.csv");
						GameControl.intializeMap(gameMap, 1, 12);
						coin = 40;
						}
					else if (numPage==7) {
						gameMap = CSV.readCSV("csv7.csv");
						GameControl.intializeMap(gameMap, 7,7);
						coin = 99;
						}
					
					GameControl.intializeCoin(gc);
					Platform.runLater(new Runnable() {
                        public void run() {
                        gc.clearRect(0, 0, 600, 600);
                        GamePage.drawGameBoard(gc);
                        }
                    });
					GameControl.moveEnemy(gc);
					
					GameControl.setWin(false);
					setCoinCount(0);
					setCoinText();
				}
			break;
			case X:
                System.exit(0);
			default:
				System.out.println("Invalid Key.");
				break;
			}
			Platform.runLater(new Runnable() {
                public void run() {
                gc.clearRect(0, 0, 600, 600);
                GamePage.drawGameBoard(gc);
                }
            });
		});
	}
}
	