package logic;

import java.util.ArrayList;
import Ability.Entity;
import Ability.Interactable;
import Entity.Block;
import Entity.Coin;
import Entity.Door;
import Entity.Lego;
import Entity.Stone;
import Entity.Wall;

public class GameMap {
	private static Cell[][] cellmap;
	private int width;
	private int height;

	public GameMap(String[][] map) {
				
		int column = map[0].length;
		int row = map.length;
		
		width = column;
		height = row ;
		
		cellmap = new Cell[row][column];
		for(int i=0;i<row;i++) {
			for(int j=0;j<column;j++) {
				cellmap[i][j] = new Cell();
				switch(map[i][j]) {
				case "0":
					break;
				case "1":
					addEntity(new Lego(),j,i);
					break;
				case "2":
					addEntity(new Stone(),j,i);
					break;
				case "3":
					addEntity(new Block(),j,i);
					break;
				case "4":
					addEntity(new Coin(),j,i);
					break;
				case "6":
					addEntity(new Door(),j,i);
					break;
				case "7":
					addEntity(new Wall(),j,i);
					break;
				default:
					System.out.println("Error parsing at position x = "+j+" y = "+i+".\nUnknown Object with Symbol "+map[i][j]);
					break;
				
				}
				
				
			}
		}
	}
	
	public Cell[][] getMap(){
		return cellmap;
	}

	public boolean addEntity(Entity e,int x, int y) {		
		e.setX(x);
		e.setY(y);
		boolean b = cellmap[y][x].setEntity(e);
		
		return b;
	}
	
	public Entity getEntity(int x,int y) {
		return cellmap[y][x].getEntity();
	}
	
	public static void removeEntity(int x, int y) {
		
		cellmap[y][x].removeEntity();
	}
	
	public boolean isMovePossible(int targetx,int targety,Entity e) {
		if(cellmap[targety][targetx].isEmpty()) { 
			return true;
		}else {
			Entity target = cellmap[targety][targetx].getEntity();
			if(target instanceof Interactable) {
				Interactable t = (Interactable) target;
				return t.interact(e);
			}else {
				return false;
			}
		}
	}
	
	
	
}