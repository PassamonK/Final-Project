package Entity;

import Ability.Entity;
import Ability.Interactable;
import Main.GamePage;
import logic.GameControl;
import logic.Sprites;

public class Door extends Entity implements Interactable {
	public int[] getSymbol() {
		if (GamePage.is_pass()) {
			return Sprites.DOOR_OPEN;
		}
		return Sprites.DOOR_CLOSE;
	}

	public boolean interact(Entity e) {
		if(e instanceof Player) {
			if (GamePage.is_pass()) {
				GameControl.setWin(true);
				return true;
			}
		}
		return false;
	}

	
}