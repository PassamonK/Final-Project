package logic;

import Ability.Entity;

public class Cell {
	private Entity myEntity;
	private boolean isEmpty;
	
	public Cell() {
		isEmpty = true;
	}
	
	public boolean isEmpty() {
		return isEmpty;
	}


	public boolean setEntity(Entity e) {
		if(isEmpty) {
			myEntity = e;
			isEmpty = false;
		}
		return true;
	}
	
	public Entity getEntity() {
		return myEntity;
	}
	
	public void removeEntity() {
		myEntity = null;
		isEmpty = true;
	}
	
	public int[] getSymbol() {
		if(isEmpty) {
			int[] a = new int[2];
			return a;
		}
		return myEntity.getSymbol();
	}
	
	
}