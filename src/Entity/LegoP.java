package Entity;

import Ability.Entity;
import Ability.Interactable;
import gui.CharacterPane;
import logic.GameControl;
import logic.Sprites;

public class LegoP extends Entity implements Interactable{

    public int[] getSymbol() {
        if(CharacterPane.getPlayerselect()=="player1") {
            return Sprites.LEGOP1;
        } else if(CharacterPane.getPlayerselect()=="player2") {
            return Sprites.LEGOP2;
        }
        return Sprites.LEGOP3;
    }

    public boolean interact(Entity e) {
        if(e instanceof Thanos) {
            GameControl.setGameover(false);
            return false;
        }
        if (e instanceof Enemy) {
            return false;
        }
        if (e instanceof EnemyLR) {
            return false;
        }
        return true;
    }


}