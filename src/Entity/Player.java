package Entity;


import Ability.Entity;
import Ability.Interactable;
import gui.CharacterPane;
import javafx.scene.media.AudioClip;
import logic.Direction;
import logic.GameControl;
import logic.Sprites;

public class Player extends Entity implements Interactable{

    private AudioClip deathSound = new AudioClip(ClassLoader.getSystemResource("Death_Sound.wav").toString());
    boolean everplay = false;
    
    public Player(Direction dir) {
        this.setDirection(dir);
    }
    
    public int[] getSymbol() {
        if(CharacterPane.getPlayerselect()=="player1") {
            return Sprites.PLAYER_1FORWARD;
        } else if(CharacterPane.getPlayerselect()=="player2") {
            return Sprites.PLAYER_2FORWARD;
        }
        return Sprites.PLAYER_3FORWARD;
    }

    public boolean interact(Entity e) {
        if ((e instanceof Enemy) && (!everplay)) {
            GameControl.setGameover(false);
            deathSound.play();
            everplay = true;

        } else if ((e instanceof EnemyLR) && (!everplay)) {
            GameControl.setGameover(false);
            deathSound.play();
            everplay = true;
        } else if ((e instanceof Thanos) && (!everplay)) {
            GameControl.setGameover(false);
            deathSound.play();
            everplay = true;
        }
        return false;
    }

}