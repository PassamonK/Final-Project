package Entity;

import Ability.Entity;
import logic.Sprites;

public class Wall extends Entity {
	public int[] getSymbol() {
		return Sprites.WALL;
	}
	
}