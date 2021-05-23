package Ability;

import Entity.Block;
import Entity.Lego;
import Entity.LegoP;
import Entity.Player;
import javafx.scene.media.AudioClip;
import logic.Direction;
import logic.GameControl;

public abstract class Entity {
	private int x;
	private int y;
	
	private Direction direction;
	
	AudioClip glassSound = new AudioClip(ClassLoader.getSystemResource("Glass_Sound.wav").toString());
	AudioClip placeSound = new AudioClip(ClassLoader.getSystemResource("Place_Block.wav").toString());
	
	
	public abstract int[] getSymbol();
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean broke() {
        switch(direction) {
        case LEFT:
            if (GameControl.getGameMap().getEntity(x-1, y) instanceof Block) {
                GameControl.getGameMap().removeEntity(x-1,y);
                glassSound.play();
                return true;
            }
            return false;
        case UP:
            if (GameControl.getGameMap().getEntity(x, y-1) instanceof Block) {
                GameControl.getGameMap().removeEntity(x,y-1);
                glassSound.play();
                return true;
            }
            return false;
        case RIGHT:
            if (GameControl.getGameMap().getEntity(x+1, y) instanceof Block) {
                GameControl.getGameMap().removeEntity(x+1,y);
                glassSound.play();
                return true;
            }
            return false;
        case DOWN:
            if (GameControl.getGameMap().getEntity(x, y+1) instanceof Block) {
                GameControl.getGameMap().removeEntity(x,y+1);
                glassSound.play();
                return true;
            }
            return false;
        default:
            return false;
        }

    }
	
	public boolean spit() {
        switch(direction) {
        case LEFT:
            if(GameControl.getGameMap().getEntity(x-1, y)==null) { 
                GameControl.getGameMap().addEntity(new Block(),x-1, y);
                placeSound.play();
                return true;
            }else {
                return false;
            }
        case UP:
            if(GameControl.getGameMap().getEntity(x, y-1)==null) { 
                GameControl.getGameMap().addEntity(new Block(),x, y-1);
                placeSound.play();
                return true;
            }else {
                return false;
            }
        case RIGHT:
            if(GameControl.getGameMap().getEntity(x+1, y)==null) { 
                GameControl.getGameMap().addEntity(new Block(),x+1, y);
                placeSound.play();
                return true;
        }else {
            return false;
        }
        case DOWN:
            if(GameControl.getGameMap().getEntity(x, y+1)==null) { 
                GameControl.getGameMap().addEntity(new Block(),x, y+1);
                placeSound.play();
                return true;
        }
		default:
			break;
            }
        return false;
    }

	
	public boolean move(Direction dir) {

        int targetx = x;
        int targety = y;

        direction = dir;

        switch(dir) {
        case LEFT:
            targetx -= 1;
            break;
        case UP:
            targety -= 1;
            break;
        case RIGHT:
            targetx += 1;
            break;
        case DOWN:
            targety += 1;
            break;
        default:
            break;
        }


        if(GameControl.getGameMap().isMovePossible(targetx, targety,this)) {
            if((GameControl.getGameMap().getEntity(targetx, targety) instanceof Lego) &&(this instanceof Player)) {
                GameControl.getGameMap().removeEntity(targetx, targety);
                if(GameControl.getGameMap().getEntity(x, y) instanceof LegoP) {
                    GameControl.getGameMap().removeEntity(x,y);
                    GameControl.getGameMap().addEntity(new Lego(), x, y);
                }
                else {
                    GameControl.getGameMap().removeEntity(x,y);
                }
                GameControl.getGameMap().addEntity(new LegoP(), targetx, targety);
                GameControl.getGameMap().addEntity(this, targetx, targety);

                return true;
            }else if((GameControl.getGameMap().getEntity(x, y) instanceof LegoP)&&(this instanceof Player)){
                GameControl.getGameMap().removeEntity(x,y);
                GameControl.getGameMap().addEntity(new Lego(), x, y);
                GameControl.getGameMap().addEntity(this, targetx, targety);
                return true;
            }else {
                GameControl.getGameMap().removeEntity(targetx, targety);
                GameControl.getGameMap().removeEntity(x,y);
                GameControl.getGameMap().addEntity(this, targetx, targety);
                return true;
            }
        }
        return false;
    }
	
	public void remove() {
		GameControl.getGameMap().removeEntity(x,y);
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}


}