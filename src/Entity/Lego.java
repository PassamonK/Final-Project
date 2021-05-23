package Entity;

import Ability.Entity;
import Ability.Interactable;
import logic.Sprites;

public class Lego extends Entity implements Interactable{
	
	public int[] getSymbol() {
		return Sprites.LEGO;
	}
	
	public boolean interact(Entity e) {
		if (e instanceof Enemy) {
			return false;
		}
		if (e instanceof EnemyLR) {
			return false;
		}
		return true;
	}

}
