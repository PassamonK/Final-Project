package Entity;

import Ability.Entity;
import logic.Direction;
import logic.Sprites;

public class EnemyLR extends Entity {
	
	public EnemyLR(Direction dir) {
		super();
		this.setDirection(dir);
	}
	
	
	public int[] getSymbol() {
		if (this.getDirection()==Direction.LEFT) {
			return Sprites.ENEMY_2LEFT;
		}
		return Sprites.ENEMY_2RIGHT;	
	}
	
	
}