package logic;

import java.util.ArrayList;
import java.lang.NullPointerException;
import Entity.Coin;
import Entity.Enemy;
import Entity.EnemyLR;
import Entity.Player;
import Entity.Thanos;
import Main.GamePage;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import java.lang.InternalError;
import java.lang.ClassCastException;

public class GameControl {

	private static GameMap gameMap;

	private static Player player;

	
	private static boolean is_win;
	
	private static boolean is_gameover;
	
	public static Thread thread1;
	public static Thread thread2;

	public static int numpage;

	private static Coin c;
	private static ArrayList<Enemy> allEnemy = new ArrayList<>() ;
	private static ArrayList<EnemyLR> allEnemyLR = new ArrayList<>() ;
	private static ArrayList<Thanos> allEnemyTN = new ArrayList<>() ;
	
	public static void intializeMap(String[][] map,int px,int py) {
		player = new Player(Direction.LEFT);
		 
		GameControl.setWin(false);
		setGameover(true);
		allEnemy = new ArrayList<>();
		allEnemyLR = new ArrayList<>();
		allEnemyTN = new ArrayList<>();
		
		gameMap = new GameMap(map);
		gameMap.addEntity(player, px, py);
		if(GamePage.numPage== 1) {
			intializeEnemy(3,7);
			intializeEnemy(11,7);
		}
		else if(GamePage.numPage== 2) {
			intializeEnemy(8,7);
			intializeEnemy(11,3);
		}
		else if(GamePage.numPage== 4) {
			intializeEnemy(1,8);
			intializeEnemy(13,8);
			intializeEnemyLR(1,4);
			intializeEnemyLR(13,4);
		}
		else if(GamePage.numPage== 3) {
			intializeEnemy(12,7);
			intializeEnemyLR(7,2);
			intializeEnemyLR(7,12);
			intializeEnemyTN(7,7);
		}
		else if(GamePage.numPage== 5) {
			intializeEnemy(1,4);
			intializeEnemy(13,2);
			intializeEnemy(13,4);
			intializeEnemy(2,1);
			intializeEnemy(8,1);
		}
		else if(GamePage.numPage== 6) {
			intializeEnemyTN(11,1);
			intializeEnemy(8,8);
			intializeEnemy(10,1);
		}
		else if(GamePage.numPage== 7) {
			intializeEnemyTN(1,1);
			intializeEnemyTN(12,1);
			intializeEnemyTN(1,13);
			intializeEnemyTN(13,13);
		}
		
	}
	
	public static void intializeEnemy(int x, int y) {
		Enemy enemy = new Enemy(Direction.LEFT);
		allEnemy.add(enemy);
		gameMap.addEntity(enemy, x, y);
		
	}
	
	public static void intializeEnemyLR(int x, int y) {
		EnemyLR enemylr = new EnemyLR(Direction.RIGHT);
		allEnemyLR.add(enemylr);
		gameMap.addEntity(enemylr, x, y);
	}
	
	public static void intializeEnemyTN(int x, int y) {
		Thanos enemytn = new Thanos();
		allEnemyTN.add(enemytn);
		gameMap.addEntity(enemytn, x, y);
	}
	
	
	public static GameMap getGameMap() {
		return gameMap;
	}
	
	public static void movePlayer(Direction dir) {
		
		player.move(dir);
	}
	
	public static void spit() {
		player.spit();
	}
	
	public static void broke() {
		player.broke();
	}
	
	public static boolean isWin() {
		return is_win;
	}

	public static void setWin(boolean is_win) {
		GameControl.is_win = is_win;
	}


	public static void setGameover(boolean is_gameover) {
		GameControl.is_gameover = is_gameover;
	}
	
	public static boolean getGameover() {
		return is_gameover;
	}

	public static void moveEnemy(GraphicsContext gc) {
		thread1 = new Thread(() -> {
			try {
				while (true) {
			        Thread.sleep(1000);
			        Platform.runLater(new Runnable() {

						public void run() {
							for(Enemy enemy:allEnemy) {
							if(enemy != null) {
								if (!enemy.move(enemy.getDirection())) {
								    int r = (int)(Math.random()*4)+1 ;
								    if(r==1) {
								        enemy.move(Direction.RIGHT) ;
								    }
								    else if(r==2) {
								        enemy.move(Direction.LEFT);
								    }
								    else if(r==3) {
								        enemy.move(Direction.UP);
								    }
								    else if(r==4) {
								        enemy.move(Direction.DOWN);
								    }
								}
							
							}
							}
							for(EnemyLR enemylr:allEnemyLR) {
								if(enemylr != null) {
									if (!enemylr.move(enemylr.getDirection())) {
								        if(enemylr.getDirection()==Direction.RIGHT) {
								        	enemylr.setDirection(Direction.LEFT);
								        } else {
								        	enemylr.setDirection(Direction.RIGHT);
								        }
							        }
								}
							}
							for(Thanos thanos:allEnemyTN) {
								if (thanos != null) {
	                                int deltax = player.getX() - thanos.getX()  ;
	                                int deltay = player.getY() - thanos.getY()  ;
	                                if (deltax < 0) {
	                                    boolean tmove1 = thanos.move(Direction.LEFT);
	                                    
	                                    if ((deltay < 0) && (!tmove1)) {
	                                    thanos.move(Direction.UP);
											
	                                    }
	                                    else if ((deltay > 0) && (!tmove1)) {
	                                        thanos.move(Direction.DOWN);
	                                    }
	                                } else if (deltax > 0) {
	                                    boolean tmove2 = thanos.move(Direction.RIGHT);
	                                    if ((deltay < 0) && (!tmove2)) {
	                                        thanos.move(Direction.UP);
	                                    }
	                                    else if ((deltay > 0) && (!tmove2)) {
	                                        thanos.move(Direction.DOWN);
	                                    }
	                                } else {
	                                    if (deltay < 0) {
	                                        thanos.move(Direction.UP);
	                                    }
	                                    else if (deltay > 0) {
	                                        thanos.move(Direction.DOWN);
	                                    }
	                                }
	                            }
							}
							Platform.runLater(new Runnable() {
                                public void run() {
                                gc.clearRect(0, 0, 600, 600);
                                GamePage.drawGameBoard(gc);
                                }
                            });
						}
					});
			        
			        
			    }
	
			} catch (InterruptedException e) {
                System.out.println(" ");
            } catch (InternalError e2) {
                System.out.println(" Please slow down!!! ");
            } catch (ClassCastException e3) {
                System.out.println(" ");
            }catch (NullPointerException e4) {
            	System.out.println(" P ");
            }catch (Exception e5) {
                e5.printStackTrace();
            }
		});
		thread1.start();
	}
	
	public static void intializeCoin(GraphicsContext gc) {
        thread2 = new Thread(() -> {
            try {
                while(true) {
                	Thread.sleep(2000);
                	int x = (int)(Math.random()*14)+1;
                    int y = (int)(Math.random()*14)+1;
                    while (getGameMap().getEntity(x, y)!=null) {
                    	x = (int)(Math.random()*14)+1;
                        y = (int)(Math.random()*14)+1;
                    }
                    c = new Coin();
                    getGameMap().addEntity(c, x, y);
                    Platform.runLater(new Runnable() {
                        public void run() {
                        gc.clearRect(0, 0, 600, 600);
                        GamePage.drawGameBoard(gc);
                        }
                    });
                }

            } catch (InterruptedException e) {
                System.out.println(" ");
            } catch (InternalError e2) {
                System.out.println(" Please slow down!!! ");
            }catch (ClassCastException e3) {
                System.out.println(" ");
            }catch (NullPointerException e4) {
            	System.out.println(" Please slow down ");
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        });
        thread2.start();

    }
	
	
	
}