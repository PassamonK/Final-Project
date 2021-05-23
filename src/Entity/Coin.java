package Entity;

import Ability.Entity;
import Ability.Interactable;
import Main.GamePage;
import javafx.scene.media.AudioClip;
import logic.Sprites;

public class Coin extends Entity implements Interactable{

    private AudioClip coinSound = new AudioClip(ClassLoader.getSystemResource("Coin_Sound.wav").toString());

    public int[] getSymbol() {
        return Sprites.COIN;
    }

    public boolean interact(Entity e) {
        if(e instanceof Player) {
            remove();
            GamePage.addCoinCount(1);
            GamePage.setCoinText();
            coinSound.play();
        }
        else {
            remove();
        }
        return true;
    }


}