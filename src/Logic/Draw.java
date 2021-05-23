package logic;

import Main.GamePage;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Draw {

    private static String image_path = ClassLoader.getSystemResource("spritessssss.png").toString();
    private static Image mainsprites = new Image(image_path);

    private static String image_path2 = ClassLoader.getSystemResource("gameover.png").toString();
    private static Image gameover = new Image(image_path2);

    private static String image_path3 = ClassLoader.getSystemResource("congrats.png").toString();
    private static Image congratswithn = new Image(image_path3);
    
    private static String image_path4 = ClassLoader.getSystemResource("cg.png").toString();
    private static Image congrats = new Image(image_path4);
     
    public static void drawSprite(GraphicsContext gc,int x,int y,int[] index) {
        WritableImage img = new WritableImage(mainsprites.getPixelReader(),index[0]*40,index[1]*40,40,40);
        gc.drawImage(img, x, y);
    }

    public static void drawGameover(GraphicsContext gc,int x,int y) {
        gc.drawImage(gameover, x, y);
    }

    public static void drawCongrats(GraphicsContext gc,int x,int y) {
    	if(GamePage.numPage== 7) {
    		gc.drawImage(congrats, x, y);
    	}
    	else {
        gc.drawImage(congratswithn, x, y);
    	}
    }
    
  

}