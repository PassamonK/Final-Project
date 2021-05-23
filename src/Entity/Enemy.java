package Entity;

import Ability.Entity;
import logic.Direction;
import logic.Sprites;

public class Enemy extends Entity {
	
	public Enemy(Direction dir) {
		this.setDirection(dir);
	}
	
	
	public int[] getSymbol() {
		return Sprites.ENEMY_2FORWARD;
	}
	
	
}